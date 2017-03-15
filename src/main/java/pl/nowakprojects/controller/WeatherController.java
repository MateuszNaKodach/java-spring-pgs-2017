package pl.nowakprojects.controller;

import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.nowakprojects.service.WeatherService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
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
   // @Autowired  //mozna tez zamiennie @Inject - znajdz ten weatherservice
   // private WeatherService cuteWeatherService;

    //@Qualifier("ugly")
   // @Autowired
   // private WeatherService uglyWeatherService;

    @Autowired //wybiera implementacje kolekcji a potem pakuje te servicy
    private Collection<WeatherService> ourServices;

    @Autowired
    @Qualifier("otherWeatherType")
    private String myBean;

    @RequestMapping("/weather")
    public List<String> allWeathers(){
        List<String> weathersList = new ArrayList<>();

        ourServices.forEach(s -> weathersList.add(s.getWeather()));

        weathersList.add(myBean);
        return weathersList;
    }


    @RequestMapping("/weather/status")
    public ResponseEntity<List<String>> allWeathersStatus(){
        List<String> weathersList = new ArrayList<>();

        ourServices.forEach(s -> weathersList.add(s.getWeather()));

        return new ResponseEntity<List<String>>(weathersList, HttpStatus.CREATED);
    }

    @RequestMapping("/weather/status/dec")
    public List<String> allWeathersStatusDecorator(
            HttpServletRequest request,
            HttpServletResponse response
    ){
        List<String> weathersList = new ArrayList<>();

        ourServices.forEach(s -> weathersList.add(s.getWeather()));

        response.setStatus(401);

        return weathersList;

    }


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

   // @RequestMapping("/weather/ugly")
    //@ResponseBody
    //public String getUglyWeather(){
   //     return uglyWeatherService.getWeather();
   // }
}
