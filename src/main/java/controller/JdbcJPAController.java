package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import service.BasicEntity;
import service.BasicEntityService;
import service.LiquiBaseEntity;
import service.LiquiBaseEntityJDBC;

import java.util.List;

@RestController
public class JdbcJPAController {

    @Autowired
    private LiquiBaseEntityJDBC liquiBaseEntityJDBC;

    @Autowired
    private BasicEntityService basicEntityService;

    @GetMapping("/getAllLiquibaseJdbc")
    public List<LiquiBaseEntity> getAllLiquiBaseJdbc(){
        return liquiBaseEntityJDBC.getAllRecords();
    }

    @GetMapping("/getAllBasicEntityByJPA")
    public List<BasicEntity> getAllBasicEntityByJPA(){
        return basicEntityService.getAllJPA();
    }

    @PostMapping("/addBasicEntityJPA")
    public BasicEntity addBasicEntityJPA(){
        return basicEntityService.addJPA();
    }

    @GetMapping("/getAllBasicEntityJdbc")
    public List<BasicEntity> getAllBasicEntityJdbc(){
        return basicEntityService.getAllJDBC();
    }

    @PostMapping("/addBasicEntityJdbc")
    public int addBasicEntityJdbc(){
        return basicEntityService.insertJdbc();
    }
}
