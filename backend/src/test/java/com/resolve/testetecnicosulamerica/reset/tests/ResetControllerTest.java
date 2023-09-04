package com.resolve.testetecnicosulamerica.reset.tests;

import com.resolve.testetecnicosulamerica.reset.ResetController;
import com.resolve.testetecnicosulamerica.reset.ResetService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ResetController.class)
public class ResetControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ResetService resetService;

    @Test
    public void testResetEndpoint() throws Exception {
        mockMvc.perform(post("/reset")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        // Verificar se o método reset do ResetService foi chamado
        verify(resetService, times(1)).reset();
    }
}