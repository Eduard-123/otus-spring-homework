package ru.otus.library.converter;

import lombok.experimental.UtilityClass;
import ru.otus.library.dto.BookDto;
import ru.otus.library.model.Book;

@UtilityClass
public class BookConverter {

    public static Book convert(BookDto bookDto) {
        Book book = new Book();
        book.setId(bookDto.getId());
        book.setName(bookDto.getTitle());
        book.setAuthor(bookDto.getAuthor());
        book.setGenre(bookDto.getGenre());
        book.setComment(bookDto.getComment());
        return book;
    }

}
