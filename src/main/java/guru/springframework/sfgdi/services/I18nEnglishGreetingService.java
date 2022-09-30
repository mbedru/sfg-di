package guru.springframework.sfgdi.services;

//import org.springframework.context.annotation.Profile;
//import org.springframework.stereotype.Service;

import guru.springframework.sfgdi.repositories.EnglishGreetingRepository;

//@Profile({"EN", "default"})
//@Service("i18Service")
public class I18nEnglishGreetingService implements GreetingService{

    private final EnglishGreetingRepository englishGreetingRepository;

    public I18nEnglishGreetingService(EnglishGreetingRepository englishGreetingRepository) {
        this.englishGreetingRepository = englishGreetingRepository;
    }

    @Override
    public String sayGreeting() {
//        return /*"Hello world - EN"*/
        return englishGreetingRepository.getGreeting();
    }
}
