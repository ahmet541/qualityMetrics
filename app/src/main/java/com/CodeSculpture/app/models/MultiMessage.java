package com.CodeSculpture.app.models;

import com.CodeSculpture.app.models.interfaces.Content;
import com.CodeSculpture.app.models.interfaces.Message;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Data
@AllArgsConstructor
public class MultiMessage implements Message {
    private String role;
    private List<Content> content;
}