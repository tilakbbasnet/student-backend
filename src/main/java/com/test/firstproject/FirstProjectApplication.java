package com.test.firstproject;

import com.test.firstproject.model.Project;
import com.test.firstproject.service.StudentService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@Configuration, @EnableAutoConfiguration, @ComponentScan
public class FirstProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstProjectApplication.class, args);

		// Accessing beans
		/*ApplicationContext applicationContext = SpringApplication.run(FirstProjectApplication.class, args);
		Project project = applicationContext.getBean(Project.class);
		System.err.println(project);
		System.err.println(".... "+project.getName());*/

		//ApplicationContext applicationContext = SpringApplication.run(FirstProjectApplication.class, args);
		// Using application context
		/*StudentService studentService = applicationContext.getBean(StudentService.class);
		StudentService studentService = bf.getBean(StudentService.class);
		studentService.display();*/

		// Using bean factory
		/*BeanFactory bf = applicationContext.getAutowireCapableBeanFactory();
		StudentService studentService = bf.getBean(StudentService.class);
		studentService.display();*/
	}

}
