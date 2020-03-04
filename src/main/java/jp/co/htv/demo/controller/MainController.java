package jp.co.htv.demo.controller;

import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.unbescape.html.HtmlEscape;

/**
 * Controller for home page and login.
 * 
 * @author Nguyen Phung Hai
 *
 */
@Controller
public class MainController {

    @GetMapping("/")
    public String root(Locale locale) {
        return "redirect:/plate/list";
    }

    /**
     * Login Screen.
     * @return
     */
    @GetMapping("/login.html")
    public String login() {
        return "login";
    }

    /** Login form with error. */
    @GetMapping("/login-error.html")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }


    /** Error page. */
    @GetMapping("/error.html")
    public String error(HttpServletRequest request, Model model) {
        model.addAttribute("errorCode", "Error " + request.getAttribute("javax.servlet.error.status_code"));
        Throwable throwable = (Throwable) request.getAttribute("javax.servlet.error.exception");
        StringBuilder errorMessage = new StringBuilder();
        errorMessage.append("<ul>");
        while (throwable != null) {
            errorMessage.append("<li>").append(HtmlEscape.escapeHtml5(throwable.getMessage())).append("</li>");
            throwable = throwable.getCause();
        }
        errorMessage.append("</ul>");
        model.addAttribute("errorMessage", errorMessage.toString());
        return "error";
    }

    /** Error page. */
    @GetMapping("/403.html")
    public String forbidden() {
        return "403";
    }
}
