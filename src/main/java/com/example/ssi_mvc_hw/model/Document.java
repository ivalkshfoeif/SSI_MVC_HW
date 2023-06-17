package com.example.ssi_mvc_hw.model;

public class Document{
    private Integer id;
    private String content;

    public Document(Integer id, String content) {
        this.id = id;
        this.content = content;
    }

    public Document() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

