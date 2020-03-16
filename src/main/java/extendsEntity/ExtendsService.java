package extendsEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExtendsService {

    @Autowired
    private MapSubSubRepo mapSubSubRepo;

    public MapSubSubEntity addJpa(String str, int id){
        //MapSubSubEntity mapSubSubEntity = new MapSubSubEntity(1+id, "JPA_MapSubSub",str);
        MapSubSubEntity mapSubSubEntity = new MapSubSubEntity();
        mapSubSubEntity.setId(id);
        mapSubSubEntity.setName("name_"+str);
        return mapSubSubRepo.save(mapSubSubEntity);
    }
}