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
        ImgDoc imgDoc = new ImgDoc.DocBuilder()
                .setPNGFileName("doc_exampleClass.png")
                .setWidth(1400)
                .setHeight(800)
                .init();
        imgDoc.draw(ExampleClass.class);
    }

    @Draw(
            author = "Developer 2",
            version = "Base",
            description = "Sed quis volutpat tellus. Vivamus aliquam pharetra nibh quis tincidunt. " +
                    "Vestibulum id vehicula lacus, sed efficitur leo. Donec nec ex ipsum. " +
                    "Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. " +
                    "Nulla blandit sodales feugiat. Cras eleifend, sapien at placerat sollicitudin, nisl eros rutrum nulla, " +
                    "lacinia ornare odio est sit amet diam. Quisque nec orci enim. Donec nec auctor odio. " +
                    "Pellentesque id mi vitae ex faucibus ultrices in ac magna. Orci varius natoque penatibus et magnis " +
                    "dis parturient montes, nascetur ridiculus mus. Duis ac ultrices leo. Duis consectetur nulla sed " +
                    "tellus consequat, sed vulputate leo molestie."
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
