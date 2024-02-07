package com.example.SpringStarterProject.form;

public class CartForm {
    private String index;
    private String deleteIndex;

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return "CartForm [index=" + index + ", deleteIndex=" + deleteIndex + "]";
    }

    public Integer getDeleteIndex() {
        return Integer.parseInt(deleteIndex);
    }

    public void setDeleteIndex(String deleteIndex) {
        this.deleteIndex = deleteIndex;
    }

}
