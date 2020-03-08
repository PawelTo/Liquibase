package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import service.LiquiBaseEntity;
import service.LiquiBaseEntityJDBC;

import java.util.List;

@RestController
public class JdbcJPAController {

    @Autowired
    private LiquiBaseEntityJDBC liquiBaseEntityJDBC;

    @GetMapping("/getAllLiquibaseJdbc")
    public List<LiquiBaseEntity> getAllLiquiBaseJdbc(){
        return liquiBaseEntityJDBC.getAllRecords();
    }
}
