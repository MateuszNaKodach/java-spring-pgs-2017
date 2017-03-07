package pl.nowakprojects;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //Adnotacja jest typem interfejsu, jest Call, Document, Runtime. Zależnie od typu mamy handler. Np. Runtime
//On bierze adnotacje, pobiera parametry, gdy aplikacja startuje
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
