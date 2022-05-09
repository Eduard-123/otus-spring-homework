package ru.otus.library.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import ru.otus.library.model.Comment;

@Data
@Builder
@AllArgsConstructor
public class CommentDto {
    private String id;
    private String comment;

    public static CommentDto fromComment(Comment comment) {
        return CommentDto.builder()
                .id(comment.getId())
                .comment(comment.getCommentVal())
                .build();
    }
}
