package pl.nowakprojects.service.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import pl.nowakprojects.service.WeatherService;
import pl.nowakprojects.service.impl.conditions.LinuxCondition;

/**
 * Created by Mateusz on 14.03.2017.
 */
@Conditional(LinuxCondition.class)
@Service("cute") //override defaultowych nazw dla beanow
public class CuteWeatherServiceImpl implements WeatherService {

    @Override
    public String getWeather() {
        return "It's shiny!";
    }
}
