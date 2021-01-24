package ru.kpfu.itis.group903.nurkaev.homework.casters;

import java.lang.reflect.Field;

/**
 * @author Shamil Nurkaev @nshamil
 * 11-903
 * Homework
 */

public class StringCaster implements Caster {
    @Override
    public boolean isCastable(Field field) {
        return field.getType().getSimpleName().equals("String");
    }

    @Override
    public String getCast(Field field) {
        return "\"" + field.getName() + "\" VARCHAR(255)";
    }
}