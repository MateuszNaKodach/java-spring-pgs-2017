package pl.nowakprojects;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.nowakprojects.dto.Uzyszkodnik;

@Slf4j
@SpringBootApplication //Adnotacja jest typem interfejsu, jest Call, Document, Runtime. Zależnie od typu mamy handler. Np. Runtime
//On bierze adnotacje, pobiera parametry, gdy aplikacja startuje
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		Uzyszkodnik u = new Uzyszkodnik("imie","nazwisko");
		log.info(u.toString());
		Uzyszkodnik.builder().imie("Mateusz").nazwisko("Nowak").build();
	}
}
