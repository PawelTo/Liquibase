package app.controller;

import app.procedureCaller.DBProcedureCaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Map;

@RestController
public class ProcedureController {

    @Autowired
    private DBProcedureCaller dbProcedureCaller;

    @GetMapping("/insertRow")
    public Map<String, Object> insertRecords(){
        return dbProcedureCaller.insertRowsStoredProcedure();
    }

    @GetMapping("/findMax")
    public BigDecimal findMax(){
        return dbProcedureCaller.findMaxByDbFunctionCall(3, 12);
    }

    @GetMapping("/packageProcedure")
    public void callPackageProcedure(){
        dbProcedureCaller.callPackageProcedure();
    }
}
