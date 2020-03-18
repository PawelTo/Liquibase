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
}
