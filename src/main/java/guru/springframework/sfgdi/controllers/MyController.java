package guru.springframework.sfgdi.controllers;

import guru.springframework.sfgdi.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Controller;
//USED TO DEMONSTRATE -==>> PrimaryGreetingService
@Controller
public class MyController {
    GreetingService greetingService;

    public MyController(GreetingService greetingService) {// by default spring >4.2 @Autowired inserted
        this.greetingService =greetingService;
    }
    public String sayHello() {
        return greetingService.sayGreeting();
    }

}
