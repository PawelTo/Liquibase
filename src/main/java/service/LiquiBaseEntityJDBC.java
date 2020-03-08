package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LiquiBaseEntityJDBC {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public LiquiBaseEntityJDBC(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int addRecord(int integer, String str){
        return jdbcTemplate.update("Insert into Liquibaseentity (str, integerColumn) values (?,?)",str,integer);
    }

    public List<LiquiBaseEntity> getAllRecords(){
        return jdbcTemplate.query("Select * from Liquibaseentity", (rs,rowNum)->new LiquiBaseEntity(
                rs.getString("str"),
                rs.getInt("integerColumn")));
    }
}
