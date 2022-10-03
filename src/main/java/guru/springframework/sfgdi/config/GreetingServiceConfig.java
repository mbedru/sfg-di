package guru.springframework.sfgdi.config;

import com.springframework.pets.PetService;
import com.springframework.pets.PetServiceFactory;
import guru.springframework.sfgdi.datasource.FakeDataSource;
import guru.springframework.sfgdi.repositories.EnglishGreetingRepository;
import guru.springframework.sfgdi.repositories.EnglishGreetingRepositoryImpl;
import guru.springframework.sfgdi.services.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

//1.When the code is ours we use @Stereotypes/annotations for ConponentScan to get it and add it to our context as bean.
//2.But if we dont own the code we cant add @Stereotypes to it so we use @Configurations to add all the beans that we want spring to catch and add it to our context as a bean.

//@ComponentScan will find this @Configuration

//@PropertySource("classpath:datasource.properties")//where the property file is//now since we are using the normal spring-boot(not spring)properties file it'll automaticallyPickUp application.Properties file from resource
@ImportResource("classpath:sfgdi-config.xml")//this@ here or could also be in the mainAppClass(where @Springbootlication)
@Configuration//means we will define some beans in this class.
public class GreetingServiceConfig {

    @Bean
    FakeDataSource fakeDataSource(@Value("${guru.username}") String username,@Value("${guru.password}") String password, @Value("${guru.jdbcurl}") String jdbcurl){
        FakeDataSource  fakeDataSource = new FakeDataSource();
        fakeDataSource.setUsername(username);
        fakeDataSource.setPassword(password);
        fakeDataSource.setJdbcurl(jdbcurl);
        return fakeDataSource;
    }

    @Bean
    PetServiceFactory petServiceFactory() {
        return new PetServiceFactory();
    }

    @Profile({"dog", "default"})
    @Bean("pet")
    PetService dogPetService(PetServiceFactory petServiceFactory) {
        return petServiceFactory.getPetService("dog");
    }
    @Profile("cat")
    @Bean("pet")
    PetService catPetService(PetServiceFactory petServiceFactory) {
        return petServiceFactory.getPetService("cat");
    }

/*  not needed b/c its configured in XML
    @Bean
    ConstructorGreetingService constructorGreetingService() {//fn name will be name of bean(startingWithLowerCase) created ant context for this bean
        return new ConstructorGreetingService();
    }*/
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
