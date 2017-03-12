package pl.nowakprojects.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * Created by Mateusz on 09.03.2017.
 */
@Getter
@Setter
@EqualsAndHashCode

public class CurrencyDTO {
    private BigDecimal value;
    private String currency;



}
