package com.example.projectForGit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example")
public class ProjectForGitApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectForGitApplication.class, args);
	}

}
