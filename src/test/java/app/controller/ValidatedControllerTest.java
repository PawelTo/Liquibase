package app.controller;

import app.Main;
import app.validation.ValidService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ValidatedController.class) //annotation to load only specified controller, not whole spring context
class ValidatedControllerTest {

    @Autowired
    private MockMvc mockMvc;

    //annotation to add mock to spring context
    @MockBean
    private ValidService validService;

    @Test
    public void givenNameandId_thenReturnString() throws Exception {
        String name = "imie";
        int id = 5;

        mockMvc.perform(post("/methodwithOutValidation")
                .contentType(MediaType.APPLICATION_JSON)
                .param("nazwa",name)
                .param("id", String.valueOf(id)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("nie wykonuje validacje na poziomie metody dla wartości nazwa: "+name+", id: "+id));
    }
}