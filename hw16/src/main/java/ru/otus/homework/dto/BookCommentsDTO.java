package ru.otus.homework.dto;

import ru.otus.homework.domain.Book;
import ru.otus.homework.domain.Comment;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class BookCommentsDTO {

    Book book;

    List<Comment> comments;

}
