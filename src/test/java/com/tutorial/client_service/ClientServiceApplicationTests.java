package com.tutorial.client_service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.hamcrest.core.StringContains.containsString;
import static org.hamcrest.core.StringContains.containsStringIgnoringCase;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.test.web.servlet.MvcResult;

@SpringBootTest()
@AutoConfigureMockMvc
//@ContextConfiguration(classes = ClientServiceApplicationTests.class)
@ActiveProfiles("ci")


public class ClientServiceApplicationTests {

    @Autowired
    private MockMvc mvc;


    @Test
    void existUser() throws Exception {

        MvcResult result = this.mvc.perform(get("/api/user-service/consulta")
                        .param("user", "edisonenc1409")
                        .param("pass", "lamismadeayer")
                )
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Usuario existe"))).andReturn();

    }
    @Test
    void userIncorrect() throws Exception {

        MvcResult result = this.mvc.perform(get("/api/user-service/consulta")
                        .param("user", "edisonenc1409")
                        .param("pass", "lamismadeayer3")
                )
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Usuario/Clave incorrecto"))).andReturn();

    }
    @Test
    void noExistUser() throws Exception {

        MvcResult result = this.mvc.perform(get("/api/user-service/consulta")
                        .param("user", "edisonenc1401")
                        .param("pass", "lamismadeayer2")
                )
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Usuario No Existe"))).andReturn();

    }

}
