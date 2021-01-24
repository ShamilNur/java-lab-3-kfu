package ru.kpfu.itis.group903.nurkaev;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.SOURCE) // доступна только в Compile
@Target(ElementType.TYPE) // для применения только к классам
public @interface HtmlForm {
    String method() default "get";

    String action() default "/";
}
