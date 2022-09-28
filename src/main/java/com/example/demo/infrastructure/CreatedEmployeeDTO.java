package com.example.demo.infrastructure;

import lombok.Value;
//ta klasa ogarnia jeśli id się bedzie powtarzało wrzuca nulla i daje najniżysz wolne id
@Value //dodaje do pol finalne i inne potrzebne opisy żeby było value
public class CreatedEmployeeDTO {

    String name;
    String lastName;
    String position;
}
