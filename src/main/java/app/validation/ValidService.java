package app.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
