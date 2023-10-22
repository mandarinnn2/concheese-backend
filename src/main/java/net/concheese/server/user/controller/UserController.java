package net.concheese.server.user.controller;


import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import net.concheese.server.user.model.UserSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class UserController {

  private final HttpSession httpSession;

  @GetMapping("/")
  public String index(Model model) {
    UserSession user = (UserSession) httpSession.getAttribute("user");
    if (user != null) {
      model.addAttribute("id", user.getId());
    }
    return "index";
  }
}