package webbh.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class HomeController {
    HttpSession session;
    HttpServletRequest request;

    @GetMapping("/login/form")
    public String index(Model model) {
        // String title = "Học spring boot";
        // String q = request.getParameter("q");
        // session.setAttribute("user", "Nguyen Van A");
        // model.addAttribute("title", title);
        // model.addAttribute("hello", q);
        return "home/index";
    }

    @PostMapping("/login/check")
    public String login(Model model) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if ("admin".equals(username) && "12345".equals(password)) {
            session.setAttribute("user", username);
            return "redirect:/home";
        }
        return "home/index";
    }
}
