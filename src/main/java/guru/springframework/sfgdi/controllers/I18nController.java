package guru.springframework.sfgdi.controllers;

import guru.springframework.sfgdi.services.GreetingService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Controller
public class I18nController  {
    private final GreetingService greetingService;

    public I18nController(@Qualifier("i18Service") GreetingService greetingService) {//but we have 2 services qualified by "i18Service"// we use @Profile so only one of them(bean) is loaded to the context at runtime.
        this.greetingService = greetingService;
    }


    public String sayHello() {
        return greetingService.sayGreeting();
    }
}
