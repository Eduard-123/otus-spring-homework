package ru.otus.model;

import com.opencsv.bean.CsvBindByName;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Question {

    @CsvBindByName(column = "title")
    private String title;

    @CsvBindByName(column = "points")
    private Integer points;

    @CsvBindByName(column = "option")
    private List<String> options;

}
