package pl.nowakprojects.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Currency;

/**
 * Created by Mateusz on 09.03.2017.
 */
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode

public class CurrencyDTO {
    private BigDecimal value;
    private Currency currency;
}
