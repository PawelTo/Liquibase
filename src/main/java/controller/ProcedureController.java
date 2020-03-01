package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import procedureCaller.DBProcedureCaller;

import java.util.Map;

@RestController
public class ProcedureController {

    @Autowired
    private DBProcedureCaller dbProcedureCaller;

    @GetMapping("/insertRow")
    public Map<String, Object> insertRecords(){
        return dbProcedureCaller.insertRowsStoredProcedure();
    }
}
