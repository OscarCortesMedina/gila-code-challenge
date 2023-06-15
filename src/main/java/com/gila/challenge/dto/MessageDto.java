package com.gila.challenge.dto;
import com.gila.challenge.enums.Category;


public class MessageDto {

    private Category category;
    private String content;

    public MessageDto() {
    }


    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}