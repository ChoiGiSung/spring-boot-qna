package com.codessquad.qna.domain;

import com.codessquad.qna.domain.dto.AnswerDto;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Answer extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User writer;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "question_id")
    private Question question;

    @Enumerated(EnumType.STRING)
    private DisplayStatus status = DisplayStatus.OPEN;

    private String contents;

    public Answer() {
    }

    public Answer(User writer, Question question, String contents) {
        this.writer = writer;
        this.contents = contents;
        this.question = question;
        question.addAnswer(this);
    }

    public User getWriter() {
        return writer;
    }

    public String getContents() {
        return contents;
    }

    public DisplayStatus getStatus() {
        return status;
    }

    public Question getQuestion() {
        return question;
    }

    public void deleteAnswer(DisplayStatus displayStatus) {
        this.question.deleteAnswer(this);
        this.status = displayStatus;
    }

    public AnswerDto returnDto() {
        return new AnswerDto(this);
    }
}
