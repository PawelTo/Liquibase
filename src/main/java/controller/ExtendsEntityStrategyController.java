package controller;

import extendsEntity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExtendsEntityStrategyController {

    @Autowired
    private ExtendsService extendsService;

    @PostMapping("/saveMapSup")
    public MapSubSubEntity saveMapSup(String str, int id) {
        return extendsService.addMapSubSubJpa(str, id);
    }

    @PostMapping("/addMapSubEntity")
    public MapSubEntity addMapSubEntity(String name, int id) {
        return extendsService.addMapSubJpa(name, id);
    }

    @PostMapping("/addBaseSingleBaseRepo")
    public BaseSingeTable addBaseSingleBaseRepo(String name, int id) {
        return extendsService.addBaseSingleBaseRepo(name, id);
    }

    @PostMapping("/addExSingleBaseRepo")
    public ExtSingleTable addExSingleBaseRepo(String name, int id) {
        return extendsService.addExSingleBaseRepo(name, id);
    }

    @PostMapping("/addExSingleExRepo")
    public ExtSingleTable addExSingleExRepo(String name, int id) {
        return extendsService.addExSingleExRepo(name, id);
    }

    @PostMapping("/addBaseJoinedRepo")
    public BaseJoinedTable addBaseJoinedRepo(String name, int id) {
        return extendsService.addBaseJoinedRepo(name, id);
    }

    @PostMapping("/addExtJoinedRepo")
    public ExtJoinedTable addExtJoinedRepo(String name, int id){
        return extendsService.addExJoinedRepo(name, id);
    }

    @PostMapping("/addBaseTabPerEntRepo")
    public BaseTabPerEnt addBaseTabPerEntRepo(String name, int id){
        return extendsService.addBaseTabPerEntRepo(name,id);
    }

    @PostMapping("/addExTabPerEntRepo")
    public ExTabPerEnt addExTabPerEntRepo(String name, int id){
        return extendsService.addExTabPerEntRepo(name, id);
    }

    @PostMapping("/addMapSubSub2")
    public MapSubSub2Entity addMapSubSub2(String name, int id){
        return extendsService.addMapSubSub2(name, id);
    }
}
