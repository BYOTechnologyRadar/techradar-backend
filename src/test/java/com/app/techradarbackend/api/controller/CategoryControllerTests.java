package com.app.techradarbackend.api.controller;

import com.app.techradarbackend.controller.CategoryController;
import com.app.techradarbackend.dao.CategoryDAO;
import com.app.techradarbackend.dto.CategoryCreateAndUpdateDTO;
import com.app.techradarbackend.dto.CategoryDTO;
import com.app.techradarbackend.service.CategoryService;
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

import java.util.HashSet;

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
@WebMvcTest(value = CategoryController.class)
public class CategoryControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CategoryService categoryService;

    @MockBean
    private CategoryDAO categoryDAO;

    @Test
    public void CC_01_Get_All_Categories_Successful() throws Exception {
        mockMvc.perform(get("/categories")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(categoryService, times(1)).getAllCategories();
    }

    @Test
    public void CC_02_Add_Category_Successful() throws Exception {
        CategoryDTO mockCategoryDTO = new CategoryDTO();
        mockCategoryDTO.setId(1);
        mockCategoryDTO.setName("Languages & Frameworks");
        mockCategoryDTO.setDescription("We've placed development languages (such as Scala or Golang) here, as well as more low-level development frameworks (such as Play or Symfony), which are useful for implementing custom software of all kinds.");

        String inputInJson = this.mapToJson(mockCategoryDTO);
        String URI = "/categories";

        when(categoryService.addCategory(any(CategoryCreateAndUpdateDTO.class))).thenReturn(mockCategoryDTO);

        RequestBuilder requestBuilder = post(URI)
                .accept(MediaType.APPLICATION_JSON).content(inputInJson)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();

        String outputInJson = response.getContentAsString();

        assertThat(outputInJson).isEqualTo(inputInJson);
        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

    @Test
    public void CC_03_Get_Category_Successful() throws Exception {
        CategoryDTO mockCategoryDTO = new CategoryDTO();
        mockCategoryDTO.setId(1);
        mockCategoryDTO.setName("Languages & Frameworks");
        mockCategoryDTO.setDescription("We've placed development languages (such as Scala or Golang) here, as well as more low-level development frameworks (such as Play or Symfony), which are useful for implementing custom software of all kinds.");
        mockCategoryDTO.setElementSet(new HashSet<>());
        mockCategoryDTO.setRadarId(1);

        String URI = "/categories/1";

        when(categoryService.getCategoryById(anyInt())).thenReturn(mockCategoryDTO);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get(URI)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();

        String expectedJson = this.mapToJson(mockCategoryDTO);
        String outputInJson = response.getContentAsString();

        assertThat(outputInJson).isEqualTo(expectedJson);
        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

    @Test
    public void CC_04_Delete_Category_Successful() throws Exception {
        int categoryId = 1;

        mockMvc.perform(delete("/categories/{categoryId}", categoryId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void CC_05_Get_All_Categories_By_Radar_Successful() throws Exception {
        int radarId = 1;

        mockMvc.perform(get("/categories/radar/{radarId}", radarId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void CC_06_Search_Category_Validation() throws Exception {
        mockMvc.perform(post("/categories/search")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(status().isBadRequest());
    }

    private String mapToJson(Object object) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(object);
    }
}
