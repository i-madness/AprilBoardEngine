package net.imadness.abe.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * Сущность, описывающая запись, содержащуюся на доске
 */
@Entity
public class Entry implements Serializable {
    @Id
    @Column(name = "entry_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    private String content;

    @NotNull
    private Date date;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;

    public Entry() {
    }

    public Entry(String content, Date date, Board board) {
        this.content = content;
        this.date = date;
        this.board = board;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", date=" + date +
                ", board=" + board +
                '}';
    }
}
