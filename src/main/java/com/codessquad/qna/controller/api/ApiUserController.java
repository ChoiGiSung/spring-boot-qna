package com.codessquad.qna.controller.api;

import com.codessquad.qna.domain.User;
import com.codessquad.qna.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class ApiUserController {

    private final UserService userService;

    public ApiUserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public User show(@PathVariable Long id){
        //todo : DTO로 변환
        return userService.findById(id);
    }
}