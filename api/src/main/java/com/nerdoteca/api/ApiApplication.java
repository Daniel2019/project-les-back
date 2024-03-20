package com.nerdoteca.api;

import com.nerdoteca.api.domain.Cidade;
import com.nerdoteca.api.domain.Endereco;
import com.nerdoteca.api.domain.Estado;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

}
