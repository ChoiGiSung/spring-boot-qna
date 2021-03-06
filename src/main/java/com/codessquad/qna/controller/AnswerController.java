package com.codessquad.qna.controller;

import com.codessquad.qna.domain.dto.UserDto;
import com.codessquad.qna.service.AnswerService;
import com.codessquad.qna.util.HttpSessionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/questions/{questionId}/answers")
public class AnswerController {

    private final AnswerService answerService;

    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @PostMapping
    public String create(@PathVariable Long questionId, String contents, HttpSession session) {
        UserDto user = HttpSessionUtils.getUserFromSession(session);
        answerService.write(user, contents, questionId);
        return "redirect:/questions/" + questionId;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id, HttpSession session) {
        UserDto user = HttpSessionUtils.getUserFromSession(session);
        answerService.delete(id, user);
        return "redirect:/";
    }

}
