package com.codessquad.qna.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User writer;

    @OneToMany(mappedBy = "question")
    @OrderBy("id ASC ")
    private List<Answer> answerList;

    private String title;
    private String contents;
    private LocalDateTime writeTime;

    public List<Answer> getAnswerList() {
        return answerList;
    }

    public String getWriteTime() {
        return writeTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"));
    }

    public void setWriteTime(LocalDateTime writeTime) {
        this.writeTime = writeTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void changeWriter(User writer) {
        this.writer = writer;
    }

    public User getWriter() {
        return writer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getContents() {
        return contents;
    }


}
