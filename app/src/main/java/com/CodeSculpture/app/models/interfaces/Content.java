package com.CodeSculpture.app.models.interfaces;

public interface Content {
    String getType();
    String getText();
}
// Format for requst
//"messages": [
//        {
//        "role": "user",
//        "content": [
//        {
//          "type": "text",
//          "text": "What's in this image?"
//        },
//        {
//          "type": "image_url",
//          "image_url": {
//            "url": "https://upload.wikimedia.org/wikipedia/commons/thumb/d/dd/Gfp-wisconsin-madison-the-nature-boardwalk.jpg/2560px-Gfp-wisconsin-madison-the-nature-boardwalk.jpg"
//          }
//        }
//        ]
//        }
//]

