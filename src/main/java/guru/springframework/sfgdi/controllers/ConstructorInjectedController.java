package guru.springframework.sfgdi.controllers;

import guru.springframework.sfgdi.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class ConstructorInjectedController {//most preferred

    //@Autowired //after Spring 4.2 it is possible to omit the @Autowired annot b/c it'll do it by default/internally.
    private final GreetingService greetingService;

    public ConstructorInjectedController(@Qualifier("constructorGreetingService")GreetingService greetingService){
        this.greetingService = greetingService;
    }
    public String getGreeting() {
        return greetingService.sayGreeting();
    }
}
