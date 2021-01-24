package ru.kpfu.itis.group903.nurkaev.queries;

/**
 * @author Shamil Nurkaev @nshamil
 * 11-903
 * Homework
 */

public class Queries {
    // language=SQL
    public static final String SQL_SELECT = "SELECT * FROM student";

    // language=SQL
    public static final String SQL_SELECT_BY_ID = "SELECT * FROM student WHERE id = ?";

    // language=SQL
    public static final String SQL_SELECT_BY_AGE = "SELECT * FROM student WHERE age = ?";

    // language=SQL
    public static final String SQL_INSERT = "INSERT INTO student (first_name, last_name, age) VALUES (?, ?, ?)";

    // language=SQL
    public static final String SQL_UPDATE_BY_ID = "UPDATE student SET first_name = ?, last_name = ?, age = ? WHERE id = ?";

    // language=SQL
    public static final String SQL_DELETE_BY_ID = "DELETE FROM student WHERE id = ?";

    // language=SQL
    public static final String SQL_INSERT_USER_SECOND = "INSERT INTO user_second (first_name, last_name, email, password, uuid) VALUES (?, ?, ?, ?, ?)";

    //language=SQL
    public static final String SQL_SELECT_USER_BY_EMAIL = "SELECT * FROM user_second WHERE email = ?";

    //language=SQL
    public static final String SQL_SELECT_USER_BY_UUID = "SELECT * FROM user_second WHERE uuid = ?";
}
