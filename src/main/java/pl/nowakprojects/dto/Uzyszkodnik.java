package pl.nowakprojects.dto;

import lombok.*;

/**
 * Created by Mateusz on 09.03.2017.
 */

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@ToString
public class Uzyszkodnik {

    @Getter(AccessLevel.PROTECTED)
    private String imie;
    private String nazwisko;

}
