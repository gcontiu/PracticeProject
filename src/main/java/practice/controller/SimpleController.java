package practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by IntelliJ IDEA.
 * User: anghel
 * Date: 1/23/12
 * Time: 11:49 AM
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class SimpleController {

    @RequestMapping("/simple.htm")
    public String testSimpleController() {
        System.out.println("Entered method.");
        return "success";
    }
}
