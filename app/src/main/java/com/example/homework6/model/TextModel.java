package com.example.homework6.model;

import java.io.Serializable;

public class TextModel implements Serializable {
    private String textInput;

    public TextModel(String textInput) {
        this.textInput = textInput;
    }

    public String getTextInput() {
        return textInput;
    }

    public void setTextInput(String textInput) {
        this.textInput = textInput;
    }
}
