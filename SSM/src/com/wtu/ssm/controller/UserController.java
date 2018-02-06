package com.wtu.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Author menglanyingfei
 * Created on 2018.01.25 10:17
 */
@Controller
public class UserController {

    @RequestMapping("/login.do")
    public String login(HttpSession session, String username, String password) {
        if (username != null && !"".equals(username)) {
            // 将用户信息保存到session中
            session.setAttribute("username", username);
            return "redirect:/findItemsByName.do";
        } else {
            return "forward:/jsp/login.jsp";
        }

    }

    @RequestMapping("/exit.do")
    public String exit(HttpSession session) {
        // 清除session
        session.invalidate();

        return "redirect:/jsp/login.jsp";
    }
}
