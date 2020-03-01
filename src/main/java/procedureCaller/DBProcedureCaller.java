package procedureCaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class DBProcedureCaller {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertRowsStoredProcedure(){
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
        simpleJdbcCall.withProcedureName("insertRecord").execute(5);
    }
}
