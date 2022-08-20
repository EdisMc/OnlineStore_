package com.example.mystore.model.binding;

import javax.validation.constraints.Size;

public class MessageBindingModel {

    @Size(min = 1)
    private String message;

    public String getMessage() {
        return message;
    }

    public MessageBindingModel setMessage(String message) {
        this.message = message;
        return this;
    }

}
