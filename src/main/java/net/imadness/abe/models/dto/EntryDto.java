package net.imadness.abe.models.dto;

import net.imadness.abe.models.Entry;

import java.util.Date;

/**
 * Data Transfer Object для сущности Entry
 */
public class EntryDto {
    private String content;
    private String author;
    private Long date;
    private Long authorId;
    private Long boardId;

    public EntryDto() {
    }

    public EntryDto(String content, Long date, Long authorId, Long boardId) {
        this.content = content;
        this.date = date;
        this.authorId = authorId;
        this.boardId = boardId;
    }

    public Entry createEntry() {
        Entry result = new Entry();
        result.setContent(this.content);
        result.setDate(new Date(this.date));
        return result;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public Long getBoardId() {
        return boardId;
    }

    public void setBoardId(Long boardId) {
        this.boardId = boardId;
    }
}
