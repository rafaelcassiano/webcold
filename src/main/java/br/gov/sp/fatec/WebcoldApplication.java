package br.gov.sp.fatec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.ViewResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;

@SpringBootApplication
public class WebcoldApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebcoldApplication.class, args);
	}
}
