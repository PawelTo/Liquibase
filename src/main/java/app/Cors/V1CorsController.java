package app.Cors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(V1CorsController.API_PAHT)
@RestController(V1CorsController.API_PAHT)
public class V1CorsController {

    static final String API_PAHT = "/cors-server";

    @GetMapping
    public CorsReturnedModel getCorsModel() {
        return new CorsReturnedModel(1,"test");
    }
}
