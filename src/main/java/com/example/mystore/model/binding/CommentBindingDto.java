package com.example.mystore.model.binding;

import javax.validation.constraints.NotEmpty;

public class CommentBindingDto {

    @NotEmpty
    private String textContent;

    public String getTextContent() {
        return textContent;
    }

    public CommentBindingDto setTextContent(String textContent) {
        this.textContent = textContent;
        return this;
    }

}
