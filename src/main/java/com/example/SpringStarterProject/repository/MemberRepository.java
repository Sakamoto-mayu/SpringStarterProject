package com.example.SpringStarterProject.repository;

import org.springframework.jdbc.core.RowMapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.SpringStarterProject.model.Member;

@Repository
public class MemberRepository {
    @Autowired
    private NamedParameterJdbcTemplate template;

    private static final String FIND_SQL = """
            SELECT *
            FROM members
            WHERE name LIKE :name
            """;

    private static final RowMapper<Member> MEMBER_ROW_MAPPER = (rs, numRow) -> {
        Member member = new Member();
        member.setName(rs.getString("name"));
        return member;
    };

    public List<Member> find(String str) {
        SqlParameterSource params = new MapSqlParameterSource().addValue("name", '%' + str + '%');
        List<Member> memberList = template.query(FIND_SQL, params, MEMBER_ROW_MAPPER);
        return memberList;
    }
}
