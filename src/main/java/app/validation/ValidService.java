package app.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class ValidService {

    private ValidRepo validRepo;

    @Autowired
    public ValidService(ValidRepo validRepo) {
        this.validRepo = validRepo;
    }

    public ValidOb addEntityValid(ValidOb valied){
        return validRepo.save(valied);
    }

    public List<ValidOb> connectCurrentPrevNextEntity(int currentId){
        List<ValidOb> total = new LinkedList();
        int objectPosition = -1;
        List<ValidOb> all = validRepo.findAllByOrderById();

        for (ValidOb curr : all) {
            if (curr.getId() == currentId) {
                objectPosition = all.indexOf(curr);
                break;
            }
        }

        if(objectPosition==-1) return total;

        if(objectPosition>0) total.add(all.get(objectPosition-1));
        total.add(all.get(objectPosition));
        if(objectPosition<total.size()) total.add(all.get(objectPosition+1));
        total.add(connectAllObject(total));
        return total;
    }

    private ValidOb connectAllObject(List<ValidOb> list){
        ValidOb connectedObject = new ValidOb(0,"",0 ,0);
        for (ValidOb single : list) {
            connectedObject.setId(connectedObject.getId()+single.getId());
            connectedObject.setNotNull(connectedObject.getNotNull()+"_x_"+single.getNotNull());
            connectedObject.setPositive(connectedObject.getPositive()+single.getPositive());
            connectedObject.setRange(connectedObject.getRange()+single.getRange());
        }
        return connectedObject;
    }

    public List<ValidOb> findAllByOrderById() { return validRepo.findAllByOrderById();}
}
