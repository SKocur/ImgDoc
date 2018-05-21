package com.imgdoc.examples;

import com.skocur.imgdoc.Draw;
import com.skocur.imgdoc.ImgDoc;

@Draw(
        author = "Developer 1",
        version = "1.0 Test",
        description = "This is example class"
)
public class ExampleClass {
    public static void main(String[] args) {
        ImgDoc.init(ExampleClass.class, "doc_exampleClass.png");
    }

    @Draw(
            author = "Developer 2",
            version = "Base",
            description = "This method does something"
    )
    private void doSomething() {
        // something
    }

    @Draw(
            version = "0.4 unstable",
            description = "This method is responsible for processing difficult task, " +
                    "like returing text."
    )
    private String returnString(String text) {
        return text;
    }
}
