package guru.springframework.sfgdi.config;

import guru.springframework.sfgdi.repositories.EnglishGreetingRepository;
import guru.springframework.sfgdi.repositories.EnglishGreetingRepositoryImpl;
import guru.springframework.sfgdi.services.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

//1.When the code is ours we use @Stereotypes/annotations for ConponentScan to get it and add it to our context as bean.
//2.But if we dont own the code we cant add @Stereotypes to it so we use @Configurations to add all the beans that we want spring to catch and add it to our context as a bean.

//@ComponentScan will find this @Configuration
@Configuration//means we will define some beans in this class.
public class GreetingServiceConfig {

    @Bean
    ConstructorGreetingService constructorGreetingService() {//fn name will be name of bean(startingWithLowerCase) created ant context for this bean
        return new ConstructorGreetingService();
    }
    //we can add qualifier("beanNameWeWantToNameIt")//but theNameItWillHaveAt context is theNameOfTheContext
    @Bean
    PropertyGreetingService propertyGreetingService() {//fn name will be name of bean(startingWithLowerCase) created ant context for this bean
        return new PropertyGreetingService();
    }
    @Bean
    SetterGreetingService setterGreetServ() {
        return new SetterGreetingService();
    }
    @Primary
    @Bean
    PrimaryGreetingService primaryGreetingService() {
        return new PrimaryGreetingService();
    }
//we want can make #1&2 to be same name/Qualifier but in java no 2 methodscanHaveSameName,
// so we give its beannameAtContext) through
//#1.
    @Profile({"ES", "default"})
    @Bean("i18Service")
    I18SpanishGreetingService i18SpanishService() {
        return new I18SpanishGreetingService();
    }
//#2
    @Bean
    I18nEnglishGreetingService i18Service(EnglishGreetingRepository englishGreetingRepository) {
        return new I18nEnglishGreetingService(englishGreetingRepository);
    }
    @Profile({"EN"})
    @Bean
    EnglishGreetingRepository englishGreetingRepository() {
        return new EnglishGreetingRepositoryImpl();
    }
}
