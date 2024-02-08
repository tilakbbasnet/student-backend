package com.test.firstproject.configuration;

import com.test.firstproject.model.Project;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
//@Profile("qa")
public class ProjectConfiguration {

    @Bean("project1")
    public Project project1() {
        //Project project = new Project("Web Application1", "Software", 6.5d, 1000d); //creating project bean
        Project project = Project.builder()
                .name("Web Application1")
                .domain("Software")
                .duration(6.5d)
                .budget(1000d)
                .build();
        return project;
    }

    @Bean("project2")
    public Project project2() {
        Project project = Project.builder()
                .budget(2000d)
                .duration(6.4d)
                .build();
        //Project project = new Project("Web Application2", "Healthcare", 5.5d, 2000d); //creating project bean
        return project;
    }
}



















