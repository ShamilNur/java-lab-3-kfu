package ru.kpfu.itis.group903.nurkaev.homework.manager;

import ru.kpfu.itis.group903.nurkaev.homework.casters.*;
import ru.kpfu.itis.group903.nurkaev.homework.models.User;
import ru.kpfu.itis.group903.nurkaev.homework.template.SimpleJdbcTemplate;

import javax.sql.DataSource;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Shamil Nurkaev @nshamil
 * 11-903
 * Homework
 */

public class EntityManager {
    private final SimpleJdbcTemplate template;
    private final List<Caster> casters = new ArrayList<>();

    public EntityManager(DataSource dataSource) {
        this.template = new SimpleJdbcTemplate(dataSource);
        this.casters.add(new BooleanCaster());
        this.casters.add(new IntegerCaster());
        this.casters.add(new LongCaster());
        this.casters.add(new StringCaster());
    }

    public <T> void createTable(String tableName, Class<T> entityClass) {
        StringBuilder sql = new StringBuilder();

        sql.append("CREATE TABLE IF NOT EXISTS \"").append(tableName).append("\" ( ");

        Field[] fields = entityClass.getDeclaredFields();
        for (Field field : fields) {
            for (Caster caster : casters) {
                if (caster.isCastable(field)) {
                    sql.append(caster.getCast(field)).append(", ");
                    break;
                }
            }
        }
        // replace the last two characters ", "
        replaceLastTwoCharacters(sql, ");");

        template.update(sql.toString());
    }

    private void replaceLastTwoCharacters(StringBuilder sql, String s) {
        sql.replace(sql.length() - 2, sql.length(), s);
    }

    public void save(String tableName, Object entity) {
        Class<?> classOfEntity = entity.getClass();
        StringBuilder sql = new StringBuilder();

        // Generate sql request "INSERT INTO tableName (field1, ...)
        //                       VALUES (field1Value, ...);"
        sql.append("INSERT INTO \"").append(tableName).append("\" ( ");

        Field[] fields = classOfEntity.getDeclaredFields();
        for (Field field : fields) {
            for (Caster caster : casters) {
                if (caster.isCastable(field)) {
                    sql.append("\"").append(field.getName()).append("\", ");
                }
            }
        }
        // replace the last two characters ", "
        sql.replace(sql.length() - 2, sql.length(), ") VALUES ( ");

        for (Field field : fields) {
            for (Caster caster : casters) {
                if (caster.isCastable(field)) {
                    sql.append(caster.getValue(field, entity)).append(", ");
                }
            }
        }
        // replace the last two characters ", "
        sql.replace(sql.length() - 2, sql.length(), ");");

        template.update(sql.toString());
    }

    public <T, ID> T findById(String tableName, Class<T> resultType, Class<ID> idType, ID idValue) {
        // Generate sql request "SELECT * FROM tableName WHERE id = idValue;"
        String sql = "SELECT * FROM \"" + tableName + "\" WHERE id = " + idValue.toString() + ";";
        return template.queryForObject(sql, resultType);
    }
}
