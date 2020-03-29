package app.controller;

import app.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JdbcJPAController {

    @Autowired
    private LiquiBaseEntityJDBC liquiBaseEntityJDBC;

    @Autowired
    private BasicEntityService basicEntityService;

    @Autowired
    private ExtendentEntityService extendentEntityService;

    @Autowired
    private Extend2EntityRepository extend2EntityRepository;

    @Autowired
    private ExtendetLvl2EntityRepository extendetLvl2EntityRepository;

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

    @PostMapping("/addExtendetLvl2Entity")
    public ExtendetLvl2Entity addExtendetLvl2Entity(String str){
        ExtendetLvl2Entity extendetLvl2Entity = new ExtendetLvl2Entity();
        extendetLvl2Entity.setOnlyExtendetLvl2("Lvl2_JPA_"+str);
        extendetLvl2Entity.setStringColumn("Lvl2_JPA_"+str);
        return extendetLvl2EntityRepository.save(extendetLvl2Entity);
    }

    @GetMapping("/getExtendetLvl2Entity")
    public List<ExtendetLvl2Entity> getExtendetLvl2Entity(){
        return extendetLvl2EntityRepository.findAll();
    }

    @PostMapping("/addExtend2Entity")
    public Extend2Entity addExtend2Entity(String str){
        Extend2Entity extend2Entity = new Extend2Entity();
        extend2Entity.setExtend2EntityOnly("extend2_JPA_"+str);
        extend2Entity.setStringColumn("2exted_JPA_"+str);
        return extend2EntityRepository.save(extend2Entity);
    }

    @GetMapping("/getExtend2Entity")
    public List<Extend2Entity> getExtend2Entity(){
        return extend2EntityRepository.findAll();
    }
}
