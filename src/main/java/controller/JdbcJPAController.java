package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import service.*;

import java.util.List;

@RestController
public class JdbcJPAController {

    @Autowired
    private LiquiBaseEntityJDBC liquiBaseEntityJDBC;

    @Autowired
    private BasicEntityService basicEntityService;

    @Autowired
    private ExtendentEntityService extendentEntityService;

    @GetMapping("/getAllLiquibaseJdbc")
    public List<LiquiBaseEntity> getAllLiquiBaseJdbc(){
        return liquiBaseEntityJDBC.getAllRecords();
    }

    @GetMapping("/getAllBasicEntityByJPA")
    public List<BasicEntity> getAllBasicEntityByJPA(){
        return basicEntityService.getAllJPA();
    }

    @PostMapping("/addBasicEntityJPA")
    public BasicEntity addBasicEntityJPA(String str){
        return basicEntityService.addJPA(str);
    }

    @GetMapping("/getAllBasicEntityJdbc")
    public List<BasicEntity> getAllBasicEntityJdbc(){
        return basicEntityService.getAllJDBC();
    }

    @PostMapping("/addBasicEntityJdbc")
    public int addBasicEntityJdbc(String str){
        return basicEntityService.insertJdbc(str);
    }

    @GetMapping("/getAllExtendedByJPA")
    public List<ExtendentEntity> getAllExtendedByJPA(){return extendentEntityService.getAllJPA();}

    @PostMapping("/addExtendedJPA")
    public ExtendentEntity addExtendedJPA(String str){return extendentEntityService.addExtendentJPA(str);}

    @GetMapping("/getAllExtendedJdbc")
    public List<ExtendentEntity> getAllExtendedJdbc(){

        List<ExtendentEntity> allJdbc = extendentEntityService.getAllJdbc();
        allJdbc.stream().forEach((e)-> System.out.println(e));
        return allJdbc;}

    @PostMapping("/addExtendedJdbc")
    public int addExtendedJdbc(String str){ return extendentEntityService.addExtendentJdbc(str);}
}
