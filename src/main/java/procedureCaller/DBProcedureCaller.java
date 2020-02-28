package procedureCaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Component;

@Component
public class DBProcedureCaller {

    @Autowired
    private SimpleJdbcCall simpleJdbcCall;
}
