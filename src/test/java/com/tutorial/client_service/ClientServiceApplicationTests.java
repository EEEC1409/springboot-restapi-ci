package com.tutorial.client_service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.hamcrest.core.StringContains.containsString;
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
    void contextLoads() throws Exception {

        MvcResult result = this.mvc.perform(get("/api/user-service/consulta")
                        .param("user", "edisonenc1409")
                        .param("pass", "lamismadeayer")
                )
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Usuario existe"))).andReturn();
        String content = result.getResponse().getContentAsString();
    }

}
