package com.skocur.imgdoc;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <h1>@Draw</h1>
 * This annotation is used to provide data from annotated classes and methods to draw() method
 * from ImgDoc class {@link ImgDoc}.
 */
@Target( {ElementType.TYPE, ElementType.METHOD} )
@Retention(RetentionPolicy.RUNTIME)
public @interface Draw {
    String author() default "-";
    String version() default "-";
    String description() default "-";
}