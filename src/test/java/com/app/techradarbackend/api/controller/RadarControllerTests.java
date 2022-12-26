package com.app.techradarbackend.api.controller;

import com.app.techradarbackend.controller.RadarController;
import com.app.techradarbackend.dao.RadarDAO;
import com.app.techradarbackend.dto.RadarCreateAndUpdateDTO;
import com.app.techradarbackend.dto.RadarDTO;
import com.app.techradarbackend.dto.RadarInfoDTO;
import com.app.techradarbackend.service.RadarService;
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
@WebMvcTest(value = RadarController.class)
public class RadarControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RadarService radarService;

    @MockBean
    private RadarDAO radarDAO;

    @Test
    public void RC_01_Get_All_Radars_Successful() throws Exception {
        mockMvc.perform(get("/radars")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(radarService, times(1)).getAllRadars();
    }

    @Test
    public void RC_02_Add_Radar_Successful() throws Exception {
        RadarDTO mockRadar = new RadarDTO();
        mockRadar.setId(1);
        mockRadar.setName("InFiNIT Technology Radar");
        mockRadar.setDescription("A techradar is a visual representation of the technology landscape within a specific organization or field. It typically includes a range of technologies, tools, and platforms, along with their current adoption level and future potential.");

        String inputInJson = this.mapToJson(mockRadar);
        String URI = "/radars";

        when(radarService.createRadar(any(RadarCreateAndUpdateDTO.class))).thenReturn(mockRadar);

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
    public void RC_03_Get_Radar_Successful() throws Exception {
        RadarInfoDTO mockRadarInfoDTO = new RadarInfoDTO();
        RadarDTO mockRadarDTO = new RadarDTO();
        mockRadarDTO.setId(1);
        mockRadarDTO.setName("InFiNIT Technology Radar");
        mockRadarDTO.setDescription("A techradar is a visual representation of the technology landscape within a specific organization or field. It typically includes a range of technologies, tools, and platforms, along with their current adoption level and future potential.");
        mockRadarInfoDTO.setRadarDTO(mockRadarDTO);
        mockRadarInfoDTO.setCategorySet(new HashSet<>());

        String URI = "/radars/1";

        when(radarService.getRadarById(anyInt())).thenReturn(mockRadarInfoDTO);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get(URI)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();

        String expectedJson = this.mapToJson(mockRadarInfoDTO);
        String outputInJson = response.getContentAsString();

        assertThat(outputInJson).isEqualTo(expectedJson);
        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

    @Test
    public void RC_04_Delete_Radar_Successful() throws Exception {
        int radarId = 1;

        mockMvc.perform(delete("/radars/{radarId}", radarId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void RC_05_Search_Radar_Validation() throws Exception {
        mockMvc.perform(post("/radars/search")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(status().isBadRequest());
    }

    private String mapToJson(Object object) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(object);
    }
}
