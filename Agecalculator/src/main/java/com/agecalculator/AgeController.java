package com.agecalculator;

import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class AgeController {

    @GetMapping("/calculate-age")
    public Map<String, Object> calculateAge(@RequestParam String birthday) {
        Map<String, Object> response = new HashMap<>();

        try {
            LocalDate birthDate = LocalDate.parse(birthday); // expected: YYYY-MM-DD
            LocalDate today = LocalDate.now();
            int age = Period.between(birthDate, today).getYears();

            //response.put("birthday", birthday);
            response.put("age of year", age);
        } catch (DateTimeParseException e) {
            response.put("error", "Invalid date format. Use YYYY-MM-DD.");
        }

        return response;
    }
}
