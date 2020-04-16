package app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasicEntityService {

    private BasicEntityJDBC basicEntityJDBC;
    private BasicEntityRepository basicEntityRepository;

    @Autowired
    public BasicEntityService(BasicEntityJDBC basicEntityJDBC, BasicEntityRepository basicEntityRepository) {
        this.basicEntityJDBC = basicEntityJDBC;
        this.basicEntityRepository = basicEntityRepository;
    }

    public List<BasicEntity> getAllJPA(){
        return basicEntityRepository.findAll();
    }

    public BasicEntity addJPA(String str){
        BasicEntity basicEntity = new BasicEntity("JPA_"+str,2,new Integer(5),5L,2,true);
        return basicEntityRepository.save(basicEntity);
    }

    public List<BasicEntity> getAllJDBC(){
        return basicEntityJDBC.getAll();
    }

   public int insertJdbc(String str){
        return basicEntityJDBC.addRecord("BasicEntity","JDBCDataType_"+str,3,5,2,1,false);
   }
}
