package guru.springframework.sfgdi.controllers;

import com.springframework.pets.PetService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class PetController {

        private final PetService petService;

        public PetController(@Qualifier("pet") PetService petService) {
            this.petService = petService;
        }

        public String whichPetIsTheBest(){
            return petService.getPetType();
        }
}

