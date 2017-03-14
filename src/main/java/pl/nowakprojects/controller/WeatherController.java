package pl.nowakprojects.controller;

import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.nowakprojects.service.WeatherService;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Created by Mateusz on 14.03.2017.
 */
@RestController
//@Controller
@RequestMapping("/api")
public class WeatherController {

    //Zazwyczaj wiecej implementacji maja validatory, np. lista validatorow i iterujemy po nich: dlugosc, format itp, a nas interesuje false lub true
    //@Qualifier(value = "cute") //wybieramy ktory servis chcemy
    @Autowired  //mozna tez zamiennie @Inject - znajdz ten weatherservice
    private WeatherService cuteWeatherService;

    //@Qualifier("ugly")
    @Autowired
    private WeatherService uglyWeatherService;

    @Autowired //wybiera implementacje kolekcji a potem pakuje te servicy
    Collection<WeatherService> ourServices;

    @RequestMapping("/weather/cute")
    //@ResponseBody
    public String getCuteWeather(){
        String ourWeather = "";
        for(WeatherService service: ourServices){
            ourWeather += service.getWeather();
        }

        return ourWeather;

       // return cuteWeatherService.getWeather();
    }

    @RequestMapping("/weather/ugly")
    //@ResponseBody
    public String getUglyWeather(){
        return uglyWeatherService.getWeather();
    }
}
