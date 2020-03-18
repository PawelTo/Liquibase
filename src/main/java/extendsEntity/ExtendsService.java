package extendsEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExtendsService {

    @Autowired
    private MapSubSubRepo mapSubSubRepo;

    @Autowired
    private MapSubRepo mapSubRepo;

    @Autowired
    private BaseSingleRepo baseSingleRepo;

    @Autowired
    private ExSingRepo exSingRepo;

    public MapSubSubEntity addMapSubSubJpa(String str, int id){
        //MapSubSubEntity mapSubSubEntity = new MapSubSubEntity(1+id, "JPA_MapSubSub",str);
        MapSubSubEntity mapSubSubEntity = new MapSubSubEntity();
        mapSubSubEntity.setId(id);
        mapSubSubEntity.setName("MapSubSubEntity_"+str);
        return mapSubSubRepo.save(mapSubSubEntity);
    }

    public MapSubEntity addMapSubJpa(String name, int id){
        MapSubEntity mapSubEntity = new MapSubEntity();
        mapSubEntity.setId(id);
        mapSubEntity.setName("MapSubEntity_"+name);
        return mapSubRepo.save(mapSubEntity);
    }

    public BaseSingeTable addBaseSingleBaseRepo(String name, int id){
        BaseSingeTable baseSingeTable = new BaseSingeTable();
        baseSingeTable.setId(id);
        baseSingeTable.setName("addBaseSingleBaseRepo_"+name);
        return baseSingleRepo.save(baseSingeTable);
    }

    public ExtSingleTable addExSingleBaseRepo(String name, int id){
        ExtSingleTable extSingleTable = new ExtSingleTable();
        extSingleTable.setId(id);
        extSingleTable.setName("addExSingleBaseRepo_"+name);
        extSingleTable.setNamesub("addExSingleBaseRepo_SubName_"+name);
        return baseSingleRepo.save(extSingleTable);
    }

    public ExtSingleTable addExSingleExRepo(String name, int id){
        ExtSingleTable extSingleTable = new ExtSingleTable();
        extSingleTable.setId(id);
        extSingleTable.setName("addExSingleExRepo_Name_"+name);
        extSingleTable.setNamesub("addExSingleBaseRepo_SubName_"+name);
        return exSingRepo.save(extSingleTable);
    }
}
