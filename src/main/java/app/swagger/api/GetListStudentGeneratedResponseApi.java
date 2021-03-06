/**
 * NOTE: This class is auto generated by the swagger code generator program (2.3.1).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package app.swagger.api;

import app.swagger.model.StudentSwag;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-30T02:31:34.304+01:00")

@Api(value = "getListStudentGeneratedResponse", description = "the getListStudentGeneratedResponse API")
public interface    GetListStudentGeneratedResponseApi {

    Logger log = LoggerFactory.getLogger(GetListStudentGeneratedResponseApi.class);

    default Optional<ObjectMapper> getObjectMapper() {
        return Optional.empty();
    }

    default Optional<HttpServletRequest> getRequest() {
        return Optional.empty();
    }

    default Optional<String> getAcceptHeader() {
        return getRequest().map(r -> r.getHeader("Accept"));
    }

    @ApiOperation(value = "", nickname = "getListStudentGeneratedResponseGet", notes = "", response = StudentSwag.class, responseContainer = "List", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "generated from yaml controller", response = StudentSwag.class, responseContainer = "List") })
    @RequestMapping(value = "/getListStudentGeneratedResponse",
        method = RequestMethod.GET)
    default ResponseEntity<List<StudentSwag>> getListStudentGeneratedResponseGet() {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("[ {  \"name\" : \"nazwa\",  \"id\" : 4,  \"passportName\" : \"paszport\"}, {  \"name\" : \"nazwa\",  \"id\" : 4,  \"passportName\" : \"paszport\"} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default GetListStudentGeneratedResponseApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}
