package procedureCaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class DBProcedureCaller {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Map<String, Object> insertRowsStoredProcedure(){
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
        return simpleJdbcCall.withProcedureName("insertRecord").execute(5);
    }
}
