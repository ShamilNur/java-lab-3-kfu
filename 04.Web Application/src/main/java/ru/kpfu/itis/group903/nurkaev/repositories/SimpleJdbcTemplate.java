package ru.kpfu.itis.group903.nurkaev.repositories;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    public <T> List<T> queryForList(String sql, RowMapper<T> rowMapper, Object... args) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            int position = 1;
            for (Object arg : args) {
                preparedStatement.setObject(position, arg);
                position++;
            }

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                List<T> result = new ArrayList<>();

                if (resultSet == null) {
                    throw new SQLException("Empty result");
                }

                while (resultSet.next()) {
                    result.add(rowMapper.mapRow(resultSet));
                }

                return result;
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public <T> void query(String sql, RowMapper<T> rowMapper, Object... args) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            int position = 1;
            for (Object arg : args) {
                preparedStatement.setObject(position, arg);
                position++;
            }

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet == null) {
                    throw new SQLException("Empty result");
                }

                while (resultSet.next()) {
                    rowMapper.mapRow(resultSet);
                }
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }
}
