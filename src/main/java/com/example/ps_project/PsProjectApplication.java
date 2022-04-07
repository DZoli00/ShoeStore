package com.example.ps_project;

import com.example.ps_project.configuration.CSVConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class PsProjectApplication {
    public static void main(String[] args) {
        SpringApplication.run(PsProjectApplication.class, args);
    }
}