package com.codessquad.qna.controller;

import com.codessquad.qna.domain.User;
import com.codessquad.qna.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("")
    public String createUser(User user) {
        userService.join(user);
        return "redirect:/users";
    }

    @GetMapping("")
    public String renderUserList(Model model) {
        List<User> getUsers = userService.findAll();
        model.addAttribute("users", getUsers);
        return "user/list";
    }

    @GetMapping("/{userId}")
    public String renderProfile(@PathVariable Long userId, Model model) {
        User findUser = userService.findById(userId);
        model.addAttribute("user", findUser);
        return "user/profile";
    }

    @GetMapping("/{userId}/form")
    public String renderUpdateForm(@PathVariable Long userId, Model model) {
        User findUser = userService.findById(userId);
        model.addAttribute("user", findUser);
        return "user/userUpdateForm";
    }

    @PutMapping("/update")
    public String userUpdate(User user, String newPassword, Model model) {
        if (userService.update(user, newPassword)) {
            return "redirect:/";
        }
        model.addAttribute("fail", true);
        return "user/userUpdateForm";
    }

    @PostMapping("/login")
    public String login(String userId, String password, HttpSession session) {
        User findUser = userService.login(userId, password);
        if (findUser == null) {
            logger.debug("로그인 실패");
            return "redirect:/users/loginForm";
        }
        logger.debug("로그인 성공");
        session.setAttribute("user", findUser);
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "redirect:/";
    }

}
