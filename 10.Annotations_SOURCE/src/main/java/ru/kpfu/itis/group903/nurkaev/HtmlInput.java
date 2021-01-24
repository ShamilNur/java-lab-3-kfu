package ru.kpfu.itis.group903.nurkaev;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.SOURCE) // доступна только в Compile
@Target(ElementType.FIELD) // для применения только к полям
public @interface HtmlInput {
    String type() default "text";

    String name() default "";        // значения в аннотациях не могут быть установлены в null,

    String placeholder() default ""; // поэтому пустая строка
}
