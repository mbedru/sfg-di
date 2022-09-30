package guru.springframework.sfgdi.services;

//import org.springframework.context.annotation.Primary;
//import org.springframework.stereotype.Service;

//DEMONSTRATED ON -==>> MyController

//@Qualifier have more precedence;//many can be take this impementation at same time.
//@Primary//if they dont have @qualifier&they dont know which implementation to take they will take @primary annotated one;
//@Service
public class PrimaryGreetingService implements GreetingService{

    @Override
    public String sayGreeting() {
        return "Hello world -- PRIMARY (primaryBeansExample)";
    }
}
