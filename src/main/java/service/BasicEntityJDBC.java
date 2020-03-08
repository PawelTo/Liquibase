package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BasicEntityJDBC {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public BasicEntityJDBC(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int addRecord(String stringColumn, int intColumn, Integer integerColumn, long longColumn, double doubleColumn, boolean booleanColumn){
        return jdbcTemplate.update("Insert into Basic_Entity (stringColumn, intColumn, integerColumn, longColumn, doubleColumn, booleanColumn) " +
                "values (?,?,?,?,?,?)",stringColumn, intColumn, integerColumn, longColumn, doubleColumn, booleanColumn);
    }

    public List<BasicEntity> getAll(){
        return jdbcTemplate.query("select * from Basic_Entity",
                (rs, rowNum)-> new BasicEntity(
                        rs.getString("stringColumn"),
                        rs.getInt("intColumn"),
                        rs.getInt("integerColumn"),
                        rs.getLong("longColumn"),
                        rs.getDouble("doubleColumn"),
                        rs.getBoolean("booleanColumn")
                ));
    }
}
