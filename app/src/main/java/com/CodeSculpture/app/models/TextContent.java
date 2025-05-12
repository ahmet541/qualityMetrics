package com.CodeSculpture.app.models;

import com.CodeSculpture.app.models.interfaces.Content;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TextContent implements Content {
    private String type;
    private String text;

    public TextContent (String text) {
        this.type = "text";
        this.text = text;
    }

    @Override
    public String toString() {
        return this.text;
    }
}