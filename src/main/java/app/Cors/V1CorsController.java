package app.Cors;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "CorsController")
@ApiModel(description = "CorsController for tutorial", value = "CorsController API Model")
@RequestMapping(V1CorsController.API_PAHT)
@RestController
public class V1CorsController {

    static final String API_PAHT = "/cors-server";

    @GetMapping
    public CorsReturnedModel getCorsModel() {
        return new CorsReturnedModel(1,"test");
    }
}
