package dev.arcaninar.cookbook.docobjects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NutritionalFacts {
    private Integer calories;
    private Integer carbs;
    private Integer fat;
    private Integer protein;
}
