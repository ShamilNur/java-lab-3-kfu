package ru.kpfu.itis.group903.nurkaev.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Shamil Nurkaev @nshamil
 * 11-903
 * Sem 1
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Tag {
    private Long id;
    private String tagName;
}
