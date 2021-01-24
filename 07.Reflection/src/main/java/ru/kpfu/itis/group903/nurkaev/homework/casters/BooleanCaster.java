package ru.kpfu.itis.group903.nurkaev.homework.casters;

import java.lang.reflect.Field;

/**
 * @author Shamil Nurkaev @nshamil
 * 11-903
 * Homework
 */

public class BooleanCaster implements Caster {
    @Override
    public boolean isCastable(Field field) {
        return field.getType().getSimpleName().equalsIgnoreCase("boolean");
    }

    @Override
    public String getCast(Field field) {
        return "\"" + field.getName() + "\" BOOLEAN";
    }
}

