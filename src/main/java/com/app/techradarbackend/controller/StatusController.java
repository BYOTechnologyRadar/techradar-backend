package com.app.techradarbackend.controller;

import com.app.techradarbackend.configuration.SwaggerConfiguration;
import com.app.techradarbackend.dto.ElementDTO;
import com.app.techradarbackend.dto.ElementStatusUpdateDTO;
import com.app.techradarbackend.service.StatusService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/elements")
@AllArgsConstructor
@Api(tags = {SwaggerConfiguration.STATUS_TAG})
@CrossOrigin(origins = "http://localhost:4200")
public class StatusController {
    private final StatusService statusService;

    @PatchMapping("/{elementId}/status")
    public ElementDTO updateElementStatus(@PathVariable Integer elementId, @Valid @RequestBody ElementStatusUpdateDTO elementStatusUpdateDTO) {
        return statusService.updateElementStatus(elementId, elementStatusUpdateDTO);
    }

    @GetMapping("/status/{statusId}")
    public List<ElementDTO> getAllElementsByStatusId(@PathVariable Integer statusId) {
        return statusService.getAllElementsByStatusId(statusId);
    }
}
