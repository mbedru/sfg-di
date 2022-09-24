package guru.springframework.sfgdi.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("ES")
@Service("i18Service")//qualify me by this name
public class I18SpanishService implements GreetingService{
    @Override
    public String sayGreeting() {
        return "Hola Mundo -ES";
    }
}
