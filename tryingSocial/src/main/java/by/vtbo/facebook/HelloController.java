package by.vtbo.facebook;


import org.springframework.social.facebook.api.Facebook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping(value = "/")
public class HelloController {

    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "index";
    }
}



