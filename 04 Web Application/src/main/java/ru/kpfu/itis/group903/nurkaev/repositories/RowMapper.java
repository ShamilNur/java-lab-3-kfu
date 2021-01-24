package ru.kpfu.itis.group903.nurkaev.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Shamil Nurkaev @nshamil
 * 11-903
 * Homework
 */

public interface RowMapper<T> {
    T mapRow(ResultSet row) throws SQLException;
}
