package app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExtendentEntityService {

    private ExtendentEntityJDBC extendentEntityJDBC;
    private ExtendentEntityRepository extendentEntityRepository;

    @Autowired
    public ExtendentEntityService(ExtendentEntityJDBC extendentEntityJDBC, ExtendentEntityRepository extendentEntityRepository) {
        this.extendentEntityJDBC = extendentEntityJDBC;
        this.extendentEntityRepository = extendentEntityRepository;
    }

    public List<ExtendentEntity> getAllJPA(){
        return extendentEntityRepository.findAll();
    }

    public ExtendentEntity addExtendentJPA(String str){
        ExtendentEntity extendentEntity = new ExtendentEntity("JPA_"+str,5,2,6,9.2,false,"only extendend");
        return extendentEntityRepository.save(extendentEntity);
    }

    public List<ExtendentEntity> getAllJdbc(){
        return extendentEntityJDBC.getAll();
    }

    public int addExtendentJdbc(String str){
        return extendentEntityJDBC.addRecord("ExtendentEntity","JDBC_"+str,5,6,7,8.6,true,"only extendend Jdbc");
    }
}
