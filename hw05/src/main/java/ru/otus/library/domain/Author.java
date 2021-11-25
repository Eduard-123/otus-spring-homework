package ru.otus.library.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@ToString
public class Author {
    @Getter
    @Setter
    private long id;

    @Getter
    @Setter
    private String name;
}
