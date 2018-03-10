package com.example.vladimirbabenko.android_base_homeworks.lesson6CalssMaterial;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by VladimirBabenko on 3/1/2018.
 */

@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CountryLess6 {
    private @Getter @Setter  String countryName;
    private @Getter @Setter  String countryCapital;
    private @Getter @Setter int flag;
}
