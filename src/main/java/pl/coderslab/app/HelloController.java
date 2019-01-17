package pl.coderslab.app;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

@Controller
public class HelloController {

    @GetMapping("/workers")
    public String workersAction(Model model) {
        Random rand = new Random();
        model.addAttribute("user", findUserById(rand.nextInt(30)+1));
        return "workers";
    }


    public String findUserById(int id) {
        String line = "";
        try {
            File file = ResourceUtils.getFile("workers.txt");
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                line = scan.nextLine();
                if (line.contains(String.format("%d",id))) {
                    break;
                }
            }
            scan.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return line.substring(line.indexOf(",") + 1).trim();
    }

}
