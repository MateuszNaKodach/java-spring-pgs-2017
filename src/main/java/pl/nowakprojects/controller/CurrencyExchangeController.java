package pl.nowakprojects.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Currency;

/**
 * Created by Mateusz on 07.03.2017.
 */

@RestController
public class CurrencyExchangeController {

    @RequestMapping("/multiply/{number}")
    public Long multiplyByTwo(@PathVariable Long number){
        return number*2;
    }

    //Example: http://localhost:8090/currency/10?currency=$
    @RequestMapping("currency/{value}")
    public String addCurrencySingature(@PathVariable Long value, @RequestParam("currency") String currency){
        return value+currency;
    }

    //Example: http://localhost:8090/multiplier/10/2?from=PLN&to=USD
    @RequestMapping("multiplier/{value}/{multiplier}")
    public String currencyMultiplier(@PathVariable Long value,
                                     @PathVariable Long multiplier,
                                     @RequestParam("from") String from,
                                     @RequestParam("to") String to){

        try{
            Currency.getInstance(from);
            Currency.getInstance(to);
            return value + from + " = " + (value*multiplier) + to;
        }catch (IllegalArgumentException e){
            throw new RuntimeException("Something is no yes");
        }


    }



}
