package app.swagger.cont;

import app.swagger.api.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
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
