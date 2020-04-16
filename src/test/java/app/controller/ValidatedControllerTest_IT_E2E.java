package app.controller;

import app.validation.ValidOb;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ValidatedControllerTest_IT_E2E {

    @Autowired
    private MockMvc mockMvc;

    private static String NAME;
    private static int id;
    private static int RANGE;
    private static int POSITIVE;

    @Test
    @Transactional
    void test_addUnValidated() throws Exception {
        // given
        NAME = "imie z test_addUnValidated transactional";
        id = 123;
        POSITIVE = 3;
        RANGE = 4;
        ValidOb validOb = new ValidOb(id,NAME,POSITIVE,RANGE);
        String json = new ObjectMapper().writeValueAsString(validOb);

        // when
        mockMvc.perform(post("/addUnValidated")
                .contentType(MediaType.APPLICATION_JSON)
                .param("id", String.valueOf(id))
                .param("notNull", NAME)
                .param("positive", String.valueOf(POSITIVE))
                .param("range", String.valueOf(RANGE)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(json))
        ;
    }

    @Test
    void test_allValidOb() throws Exception {
        mockMvc.perform(get("/allValidOb"))
                .andDo(print());
    }
}