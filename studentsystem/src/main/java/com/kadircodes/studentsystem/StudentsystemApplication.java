package com.kadircodes.studentsystem;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication()

public class StudentsystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentsystemApplication.class, args);
	}
	
	//Request ve responseların dönüşümünde kullandığımız ModelMapper'ın konfigürasyonunu 
	// Bean tanımlayarak yapıyoruz.
	@Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }



}
