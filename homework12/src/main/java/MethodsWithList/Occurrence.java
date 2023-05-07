package MethodsWithList;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Occurrence {
    private final String word;
    private final int count;
}
