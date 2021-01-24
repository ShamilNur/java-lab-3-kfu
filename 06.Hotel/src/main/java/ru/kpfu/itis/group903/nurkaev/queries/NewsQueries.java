package ru.kpfu.itis.group903.nurkaev.queries;

/**
 * @author Shamil Nurkaev @nshamil
 * 11-903
 * Sem 1
 */

public class NewsQueries {
    // language=SQL
    public static final String SQL_SELECT = "SELECT * FROM news_hotel;";

    // language=SQL
    public static final String SQL_SELECT_BY_ID = "SELECT * FROM news_hotel WHERE id = :id;";

    // language=SQL
    public static final String SQL_SELECT_BY_TAG =
            "WITH _title_tag_id AS (\n" +
                    "    SELECT nh.id, nh.title, nh.description, nh.photo, nt.tag_id\n" +
                    "    FROM news_hotel nh\n" +
                    "             LEFT JOIN news_tag nt on nh.id = nt.news_id)\n" +
                    "SELECT _title_tag_id.id, _title_tag_id.title, _title_tag_id.description, _title_tag_id.photo\n" +
                    "FROM _title_tag_id\n" +
                    "         INNER JOIN tag_hotel th ON th.id = _title_tag_id.tag_id\n" +
                    "WHERE name = :tag_name;";

    // language=SQL
    public static final String SQL_INSERT = "INSERT INTO news_hotel (title, description, photo) " +
            "VALUES (:title, :description, :photo);";

    // language=SQL
    public static final String SQL_UPDATE_BY_ID = "UPDATE news_hotel " +
            "SET title = :title, description = :description, photo = :photo WHERE id = :id;";

    // language=SQL
    public static final String SQL_DELETE_BY_ID = "DELETE FROM news_hotel WHERE id = :id;";
}
