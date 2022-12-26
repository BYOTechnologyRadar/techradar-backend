package com.app.techradarbackend.api.controller;

import com.app.techradarbackend.controller.ElementController;
import com.app.techradarbackend.dao.ElementDAO;
import com.app.techradarbackend.dto.ElementCreateDTO;
import com.app.techradarbackend.dto.ElementDTO;
import com.app.techradarbackend.dto.ElementInfoDTO;
import com.app.techradarbackend.enums.ElementLevel;
import com.app.techradarbackend.enums.ElementStatus;
import com.app.techradarbackend.enums.ElementVersion;
import com.app.techradarbackend.service.ElementService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ElementController.class)
public class ElementControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ElementService elementService;

    @MockBean
    private ElementDAO elementDAO;

    @Test
    public void EC_01_Get_All_Elements_Successful() throws Exception {
        mockMvc.perform(get("/elements")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(elementService, times(1)).getAllElements();
    }

    @Test
    public void EC_02_Add_Element_Successful() throws Exception {
        ElementCreateDTO elementCreateDTO = new ElementCreateDTO();
        elementCreateDTO.setName("Java");
        elementCreateDTO.setLevel(ElementLevel.ADOPT);
        elementCreateDTO.setVersion(ElementVersion.New);
        elementCreateDTO.setStatus(ElementStatus.ACTIVE);
        elementCreateDTO.setCategoryId(1);
        elementCreateDTO.setDescription("Java is a high-level, class-based, object-oriented programming language that is designed to have as few implementation dependencies as possible.");

        ElementDTO mockElementDTO = new ElementDTO();
        mockElementDTO.setId(1);
        mockElementDTO.setName("Java");
        mockElementDTO.setStatus(ElementStatus.ACTIVE);
        mockElementDTO.setVersion(ElementVersion.New);
        mockElementDTO.setLevel(ElementLevel.ADOPT);

        String inputInJson = this.mapToJson(elementCreateDTO);
        String URI = "/elements";

        when(elementService.addElement(any(ElementCreateDTO.class))).thenReturn(mockElementDTO);

        RequestBuilder requestBuilder = post(URI)
                .accept(MediaType.APPLICATION_JSON).content(inputInJson)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

    @Test
    public void EC_03_Get_Element_Successful() throws Exception {
        ElementInfoDTO mockElementInfoDTO = new ElementInfoDTO();
        ElementDTO mockElementDTO = new ElementDTO();
        mockElementDTO.setId(1);
        mockElementDTO.setName("Java");
        mockElementInfoDTO.setCategoryId(1);
        mockElementDTO.setLevel(ElementLevel.ADOPT);
        mockElementDTO.setVersion(ElementVersion.New);
        mockElementDTO.setStatus(ElementStatus.ACTIVE);
        mockElementInfoDTO.setElementDTO(mockElementDTO);
        mockElementInfoDTO.setDescription("Java is a high-level, class-based, object-oriented programming language that is designed to have as few implementation dependencies as possible.");

        when(elementService.getElementById(anyInt())).thenReturn(mockElementInfoDTO);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/elements/1")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();

        String expectedJson = this.mapToJson(mockElementInfoDTO);
        String outputInJson = response.getContentAsString();

        assertThat(outputInJson).isEqualTo(expectedJson);
        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

    @Test
    public void EC_04_Delete_Element_Successful() throws Exception {
        int elementId = 1;

        mockMvc.perform(delete("/elements/{elementId}", elementId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void EC_05_Get_All_Elements_By_Category_Successful() throws Exception {
        int categoryId = 1;

        mockMvc.perform(get("/elements/category/{categoryId}", categoryId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void EC_06_Search_Element_Validation() throws Exception {
        mockMvc.perform(post("/elements/search")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(status().isBadRequest());
    }

    private String mapToJson(Object object) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(object);
    }
}
