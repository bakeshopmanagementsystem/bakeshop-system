package com.timesbakeshop.system;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class LoginControllerTest {

    @Autowired
    private MockMvc mvc;

    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void login() throws Exception {
        Map<String, String> params = new HashMap<>();
        params.put("username", "admin");
        params.put("password", "password");

        String payload = mapper.writeValueAsString(params);

        mvc.perform(MockMvcRequestBuilders.post("/login").accept(MediaType.APPLICATION_JSON)
                        .param("username", "admin")
                        .param("password", "password"))
                .andExpect(status().isOk())
                .andExpect(content().string("Successfully logged in."));
    }

}
