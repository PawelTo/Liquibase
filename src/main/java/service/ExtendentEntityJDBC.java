package service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ExtendentEntityJDBC {

    private JdbcTemplate jdbcTemplate;

    public ExtendentEntityJDBC(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int addRecord(String dTYPE, String stringColumn, int intColumn, Integer integerColumn, long longColumn, double doubleColumn, boolean booleanColumn, String onlyExtendedColumn){
        return jdbcTemplate.update("Insert into Basic_Entity (DTYPE, string_Column, int_Column, integer_Column, long_Column, double_Column, boolean_Column, ONLY_EXTENDENT_COLUMN) " +
                "values (?,?,?,?,?,?,?,?)", dTYPE, stringColumn, intColumn, integerColumn, longColumn, doubleColumn, booleanColumn, onlyExtendedColumn);
    }

    public List<ExtendentEntity> getAll(){
        return jdbcTemplate.query("select * from Basic_Entity",
                (rs, rowNum)-> new ExtendentEntity(
                        rs.getString("string_Column"),
                        rs.getInt("int_Column"),
                        rs.getInt("integer_Column"),
                        rs.getLong("long_Column"),
                        rs.getDouble("double_Column"),
                        rs.getBoolean("boolean_Column"),
                        rs.getString("ONLY_EXTENDENT_COLUMN")
                ));
    }
}
