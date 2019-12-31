package swaggerNew.swaggP.io.swagger.cont;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import swaggerNew.swaggP.io.swagger.api.*;
import swaggerNew.swaggP.io.swagger.model.StudentSwag;
import swaggerNew.swaggP.io.swagger.model.StudentSwagList;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Optional;

@Controller
public class StudentSwagControllerImp implements GetListStudentSwagSwaggerWithResponseApi, GetStudentSwagSwaggerApi,
        GetStudentSwagSwaggerWithResponseApi, PostStudentSwagSwaggerApi, PostStudentSwagSwaggerWithResponseApi,
        GetListStudentGeneratedResponseApi, GetSetStudentGeneratedResponseApi{

    @Override
    public Optional<ObjectMapper> getObjectMapper() {
        return Optional.empty();
    }

    @Override
    public Optional<HttpServletRequest> getRequest() {
        return Optional.empty();
    }

    @Override
    public Optional<String> getAcceptHeader() {
        return Optional.empty();
    }
}
