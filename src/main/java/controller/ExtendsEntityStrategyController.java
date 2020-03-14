package controller;

import extendsEntity.ExtendsService;
import extendsEntity.MapSubSubEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExtendsEntityStrategyController {

    private ExtendsService extendsService;

    @PostMapping("/saveMapSup")
    public MapSubSubEntity saveMapSup(String str, int id){
        return extendsService.addJpa(str, id);
    }
}
