package hu.unideb.inf.kaloriaszamlalo;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class KaloriaszamlaloApplication {

	public static void main(String[] args) {
		SpringApplication.run(KaloriaszamlaloApplication.class, args);
	}


	@Bean
	ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper;

		//return new ModelMapper();
	}

}
