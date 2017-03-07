package pl.nowakprojects.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Mateusz on 07.03.2017.
 */

@RestController //komponent aplikacji, kontroler RESTowy RestController z Web dependency
@RequestMapping("/hello") //wszystkie metody tego kontrolera oczekują na zapytania pod adresem zaczynajacym się od /hello
public class HelloWorldController {

    @RequestMapping("/world") //jesli zapytamy o /world uruchom tą metodę
    public String helloWorld(){
        return "Hello World";
    }

    @RequestMapping("/{name}")
    public String helloName(@PathVariable String name){
        return "Hello " + name;
    }

}
