package com.app.techradarbackend.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
@EnableWebMvc
public class SwaggerConfiguration {
    public static final String CATEGORY_TAG = "Category Controller";
    public static final String ELEMENT_TAG = "Element Controller";
    public static final String RADAR_TAG = "Radar Controller";
    public static final String LEVEL_TAG = "Level Controller";
    public static final String VERSION_TAG = "Version Controller";
    public static final String STATUS_TAG = "Status Controller";


    @Bean
    public Docket techradarApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.app.techradarbackend"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo())
                .tags(new Tag(CATEGORY_TAG, "In a tech-radar, an element category is a group or category of technologies, tools, and platforms that are related in some way."))
                .tags(new Tag(ELEMENT_TAG, "The elements on a tech-radar can include a wide range of technologies, from established and widely used technologies to newer and more experimental technologies. The specific elements included on a radar will depend on the organization or field that the radar is for, and the goals and priorities of the radar."))
                .tags(new Tag(RADAR_TAG, "A radars can include multiple tech-radars that cover different aspects or domains of the technology landscape, such as infrastructure, development tools, or cloud services"))
                .tags(new Tag(LEVEL_TAG, "In a tech-radar, the elements are typically organized into four different rings: Adopt, Trial, Assess, and Hold. These rings reflect the current stage of adoption or maturity of the element, and provide guidance on how it should be used or considered."))
                .tags(new Tag(VERSION_TAG, "In a tech-radar, an element can have different versions to reflect changes and updates that have been made to it."))
                .tags(new Tag(STATUS_TAG, "In a tech-radar, an element can be either active or inactive. An active element is one that is currently in use or being considered for use within the organization. An inactive element, on the other hand, is one that is not currently being used or considered for use."));

    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Technology Radar API",
                "A techradar is a visual representation of the technology landscape within a specific organization or field. It typically includes a range of technologies, tools, and platforms, along with their current adoption level and future potential",
                "v1.0",
                "Terms of service",
                new Contact("Akshay Sargar", "https://github.com/BYOTechnologyRadar", "akshay.sargar4141@gmail.com"),
                "License of API", "API license URL", Collections.emptyList());
    }
}