package com.app.techradarbackend.api.controller;

import com.app.techradarbackend.controller.ElementController;
import com.app.techradarbackend.service.ElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockitoTestExecutionListener;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.web.servlet.MockMvc;
import org.testng.annotations.Test;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = ElementController.class)
@AutoConfigureWebMvc
@AutoConfigureMockMvc
@TestExecutionListeners(MockitoTestExecutionListener.class)
public class ElementControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ElementService elementService;

    @Test(enabled = false)
    public void EC_01_Get_All_Elements_Successful() throws Exception {
        this.mockMvc.perform(get("/api/elements")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("utf-8"))
                        .andDo(print())
                        .andExpect(status().isOk());

        verify(elementService, times(1)).getAllElements();
    }

    @Test(enabled = false)
    public void EC_02_Get_Element_Successful() throws Exception {
        int elementId = 1;

        this.mockMvc.perform(get("/api/elements/" + elementId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(elementService, times(1)).getElementById(elementId);

    }

    @Test(enabled = false)
    public void EC_03_Delete_Element_Successful() throws Exception {
        int elementId = 1;

        this.mockMvc.perform(get("/api/elements/" + elementId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("If-Match", elementId))
                        .andExpect(status().isOk());

        verify(elementService, times(1)).deleteElementById(elementId);

    }
}
