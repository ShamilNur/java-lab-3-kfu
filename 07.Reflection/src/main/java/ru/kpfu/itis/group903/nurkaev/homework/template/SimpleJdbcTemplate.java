package ru.kpfu.itis.group903.nurkaev.homework.template;

import javax.sql.DataSource;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Shamil Nurkaev @nshamil
 * 11-903
 * Homework
 */

public class SimpleJdbcTemplate {

    private final DataSource dataSource;

    public SimpleJdbcTemplate(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void update(String sql) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public <T> T queryForObject(String sql, Class<T> resultType) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            if (resultSet == null) {
                throw new SQLException("Empty result");
            }

            Field[] fields = resultType.getDeclaredFields();
            Class<?>[] paramTypes = new Class[fields.length];
            Object[] params = new Object[fields.length];

            // This resultSet has only one row
            resultSet.next();
            for (int i = 0; i < fields.length; i++) {
                paramTypes[i] = fields[i].getType();
                params[i] = resultSet.getObject(fields[i].getName(), fields[i].getType());
            }

            return resultType.getConstructor(paramTypes).newInstance(params);
        } catch (SQLException | NoSuchMethodException | InstantiationException
                | IllegalAccessException | InvocationTargetException e) {
            throw new IllegalStateException(e);
        }
    }
}
