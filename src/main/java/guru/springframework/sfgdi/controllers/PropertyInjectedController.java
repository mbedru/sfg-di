package guru.springframework.sfgdi.controllers;

import guru.springframework.sfgdi.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class PropertyInjectedController {

    //property injected//must be public to all b/c its given it's value from outside.
    //PropInject is the least preferred method b/c it assigns by accessing the property property.
   @Qualifier("propertyGreetingService")//qualify only from this implementation/class of the interface.
   @Autowired
    public GreetingService greetingService;


    public String getGreeting() {
        return greetingService.sayGreeting();
    }
}
