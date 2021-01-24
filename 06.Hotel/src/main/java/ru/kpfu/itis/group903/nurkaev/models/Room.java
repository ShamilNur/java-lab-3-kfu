package ru.kpfu.itis.group903.nurkaev.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Shamil Nurkaev @nshamil
 * 11-903
 * Sem 1
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Room {
    private Long id;
    private String name;
    private String photo;
    private Long dateFrom;
    private Long dateTo;
    private Integer roomsNumber;
    private Integer adultsNumber;
    private Integer childNumber;
    private Integer price;
}
