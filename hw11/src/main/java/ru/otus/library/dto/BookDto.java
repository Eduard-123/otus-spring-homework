package ru.otus.library.dto;

import lombok.*;
import ru.otus.library.model.Author;
import ru.otus.library.model.Book;
import ru.otus.library.model.Comment;
import ru.otus.library.model.Genre;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BookDto {
    private String id;
    private String title;
    private Author author;
    private Genre genre;
    private Comment comment;

    public static BookDto fromBook(Book book) {
        return BookDto.builder()
                .id(book.getId())
                .title(book.getName())
                .author(book.getAuthor())
                .genre(book.getGenre())
                .comment(book.getComment())
                .build();
    }
}
