package pl.coderslab;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RedirectController {

    @GetMapping("/first")
    public String firstAction() {
        return "first";
    }

    @GetMapping("/second")
    public String secondAction() {
        return "redirect:third";
    }

    @GetMapping("/third")
    public String thirdAction() {
        return "third";
    }


}
