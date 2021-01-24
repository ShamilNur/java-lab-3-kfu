package ru.kpfu.itis.group903.nurkaev.queries;

/**
 * @author Shamil Nurkaev @nshamil
 * 11-903
 * Sem 1
 */

public class UserQueries {
    // language=SQL
    public static final String SQL_SELECT = "SELECT * FROM user_hotel;";

    // language=SQL
    public static final String SQL_SELECT_BY_ID = "SELECT * FROM user_hotel WHERE id = :id;";

    // language=SQL
    public static final String SQL_SELECT_BY_EMAIL = "SELECT * FROM user_hotel WHERE email = :email;";

    // language=SQL
    public static final String SQL_INSERT = "INSERT INTO user_hotel (first_name, last_name, email, hash_password) VALUES (:first_name, :last_name, :email, :hash_password);";

    // language=SQL
    public static final String SQL_UPDATE_BY_ID = "UPDATE user_hotel SET first_name = :first_name, last_name = :last_name, email = :email, rooms_id = :rooms_id WHERE id = :id;";

    // language=SQL
    public static final String SQL_UPDATE_BY_EMAIL = "UPDATE user_hotel SET first_name = :first_name, last_name = :last_name WHERE email = :email;";

    // language=SQL
    public static final String SQL_DELETE_BY_ID = "DELETE FROM user_hotel WHERE id = :id;";

    // language=SQL
    public static final String SQL_DELETE_BY_EMAIL = "DELETE FROM user_hotel WHERE email = :email;";
}
