package app.controller;

import app.validation.ValidOb;
import app.validation.ValidService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
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

/**
 * Class for integration test of restAPI controller - mocked serviced layer
 */
@RunWith(SpringRunner.class)
@WebMvcTest(ValidatedController.class) //annotation to load only specified controller, not whole spring context
class ValidatedController_IntegrationTestForRestApi {

    @Autowired
    private MockMvc mockMvc;

    //annotation to add mock to spring context
    @MockBean
    private ValidService mockBeanValidService;

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

    @Test
    public void addValidated_thenReturnValidObject() throws Exception {
        //given
        int id =33;
        String notNull = "testObject";
        double positive =5;
        int range =5;
        ValidOb validOb = new ValidOb(id,notNull,positive,range);
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(validOb);

        //when
        Mockito.when(mockBeanValidService.addEntityValid(validOb)).thenReturn(validOb);

        mockMvc.perform(post("/addValidated")
                .contentType(MediaType.APPLICATION_JSON)
                .param("id",String.valueOf(id))
                .param("notNull",notNull)
                .param("positive", String.valueOf(positive))
                .param("range",String.valueOf(range))
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(json))
        ;
        Mockito.verify(mockBeanValidService, Mockito.times(1)).addEntityValid(validOb);
    }

    @Test
    public void addValidatedBody_thenReturnValidObject() throws Exception {
        //given
        int id =33;
        String notNull = "testObject";
        double positive =5;
        int range =5;
        ValidOb validOb = new ValidOb(id,notNull,positive,range);
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(validOb);

        //when
        Mockito.when(mockBeanValidService.addEntityValid(validOb)).thenReturn(validOb);

        mockMvc.perform(post("/addValidatedBody")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(json))
        ;
        Mockito.verify(mockBeanValidService, Mockito.times(1)).addEntityValid(validOb);
    }
}