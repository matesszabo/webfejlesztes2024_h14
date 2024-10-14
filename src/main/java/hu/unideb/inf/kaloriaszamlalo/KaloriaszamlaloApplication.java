package hu.unideb.inf.kaloriaszamlalo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class KaloriaszamlaloApplication {

	public static void main(String[] args) {
		SpringApplication.run(KaloriaszamlaloApplication.class, args);
	}

}
