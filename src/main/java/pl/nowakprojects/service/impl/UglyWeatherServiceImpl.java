package pl.nowakprojects.service.impl;

import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import pl.nowakprojects.service.WeatherService;
import pl.nowakprojects.service.impl.conditions.WindowsCondition;

/**
 * Created by Mateusz on 14.03.2017.
 */
@Conditional(WindowsCondition.class)
@Primary
@Service("ugly")
public class UglyWeatherServiceImpl implements WeatherService {

    @Override
    public String getWeather() {
        return "It's rainy";
    }
}
