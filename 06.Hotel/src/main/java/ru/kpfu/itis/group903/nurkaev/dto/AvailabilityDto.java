package ru.kpfu.itis.group903.nurkaev.dto;

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
public class AvailabilityDto {
    private Long dateFrom;
    private Long dateTo;
    private Integer roomsNumber;
    private Integer adultsNumber;
    private Integer childNumber;
}
