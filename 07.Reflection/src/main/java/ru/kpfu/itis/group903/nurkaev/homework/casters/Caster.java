package ru.kpfu.itis.group903.nurkaev.homework.casters;

import java.lang.reflect.Field;

public interface Caster {
    boolean isCastable(Field field);

    String getCast(Field field);

    default String getValue(Field field, Object obj) {
        String value;
        try {
            field.setAccessible(true);
            value = "'" + field.get(obj).toString() + "'";
        } catch (NullPointerException e) {
            value = "NULL";
        } catch (IllegalAccessException e) {
            throw new IllegalStateException(e);
        }
        return value;
    }
}
