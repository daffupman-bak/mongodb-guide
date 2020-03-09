package io.daff.start;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author daffupman
 * @since 2020/3/9
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {

    private String name;
    private Integer score;
}
