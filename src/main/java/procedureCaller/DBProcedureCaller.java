package procedureCaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Map;

@Component
public class DBProcedureCaller {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Map<String, Object> insertRowsStoredProcedure(){
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
        return simpleJdbcCall.withProcedureName("insertRecord").execute(5);
    }

    public BigDecimal findMaxByDbFunctionCall(int x, int y){
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("x",x).addValue("y",y);
        BigDecimal findMax = simpleJdbcCall.withFunctionName("findMax").executeFunction(BigDecimal.class, in);
        System.out.println("wartość max:"+findMax);
        return findMax;
    }
}