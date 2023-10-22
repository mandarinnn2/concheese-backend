package net.concheese.server.user.controller;


import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import net.concheese.server.user.model.LoginSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class LoginController {

  private final HttpSession httpSession;

  @GetMapping("/")
  public String index(Model model) {
    LoginSession user = (LoginSession) httpSession.getAttribute("user");
    if (user != null) {
      model.addAttribute("id", user.getId());
    }
    return "index";
  }
}