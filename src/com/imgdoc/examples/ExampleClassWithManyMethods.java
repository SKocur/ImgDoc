package com.imgdoc.examples;

import com.skocur.imgdoc.Draw;
import com.skocur.imgdoc.ImgDoc;

@Draw(
        author = "Team Four",
        version = "v.1.2.3",
        description = "Example class which contains many methods created for testing purposes."
)
public class ExampleClassWithManyMethods {

    public static void main(String[] args) {
        ImgDoc.init(ExampleClassWithManyMethods.class, "doc_manyMethods.png");
    }

    @Draw(
          description = "Some stuff"
    )
    private void method1() {

    }

    @Draw(
            version = "0.7"
    )
    private String method2() {
        return "";
    }

    @Draw(
            author = "Jeff",
            version = "0.1 very unstable",
            description = "Returns array of numbers 0, 1, 2"
    )
    public int[] method3() {
        int[] arr = { 0, 1, 2 };
        return arr;
    }


    @Draw(
            description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec ut auctor tellus. " +
                    "Cras posuere tincidunt urna, nec lacinia turpis fringilla non. Phasellus odio nulla, " +
                    "hendrerit sed fermentum non, cursus ut lorem. Nulla euismod laoreet nisl, ut accumsan lorem. " +
                    "Nulla facilisi. Nam id ligula vel felis varius eleifend at et turpis. Nunc ornare neque tellus, at "
    )
    protected long method4() {
        return 3274862749L;
    }

    @Draw(
            author = "Alice",
            description = "Sed quis volutpat tellus. Vivamus aliquam pharetra nibh quis tincidunt. " +
                    "Vestibulum id vehicula lacus, sed efficitur leo. Donec nec ex ipsum. " +
                    "Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. " +
                    "Nulla blandit sodales feugiat. Cras eleifend, sapien at placerat sollicitudin, nisl eros rutrum nulla, " +
                    "lacinia ornare odio est sit amet diam. Quisque nec orci enim. Donec nec auctor odio. " +
                    "Pellentesque id mi vitae ex faucibus ultrices in ac magna. Orci varius natoque penatibus et magnis " +
                    "dis parturient montes, nascetur ridiculus mus. Duis ac ultrices leo. Duis consectetur nulla sed " +
                    "tellus consequat, sed vulputate leo molestie."
    )
    void method5() {

    }

    @Draw(
            version = "0.4.2"
    )
    private Class<?> method6() {
        return this.getClass();
    }

    @Draw(
            author = "The People",
            version = "1.0.1",
            description = "Sed quis volutpat tellus. Vivamus aliquam pharetra nibh quis tincidunt. " +
                    "Vestibulum id vehicula lacus, sed efficitur leo. Donec nec ex ipsum. " +
                    "Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. " +
                    "Nulla blandit sodales feugiat. Cras eleifend, sapien at placerat sollicitudin, nisl eros rutrum nulla, " +
                    "lacinia ornare odio est sit amet diam. Quisque nec orci enim. Donec nec auctor odio. " +
                    "Pellentesque id mi vitae ex faucibus ultrices in ac magna. Orci varius natoque penatibus et magnis " +
                    "dis parturient montes, nascetur ridiculus mus. Duis ac ultrices leo. Duis consectetur nulla sed " +
                    "tellus consequat, sed vulputate leo molestie."
    )
    private double method7() {
        return 3.14;
    }

    @Draw(
            description = "Sed quis volutpat tellus. Vivamus aliquam pharetra nibh quis tincidunt. " +
                    "Vestibulum id vehicula lacus, sed efficitur leo. Donec nec ex ipsum. " +
                    "Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. " +
                    "Nulla blandit sodales feugiat. Cras eleifend, sapien at placerat sollicitudin, nisl eros rutrum nulla, " +
                    "lacinia ornare odio est sit amet diam. Quisque nec orci enim. Donec nec auctor odio. " +
                    "Pellentesque id mi vitae ex faucibus ultrices in ac magna. Orci varius natoque penatibus et magnis " +
                    "dis parturient montes, nascetur ridiculus mus. Duis ac ultrices leo. Duis consectetur nulla sed " +
                    "tellus consequat, sed vulputate leo molestie."
    )
    public Object method8() {
        return this;
    }

    @Draw(
            author = "Anonymous",
            version = "Stable",
            description = "Finally this the last method from our ManyMethods class."
    )
    private void method9() {

    }
}
