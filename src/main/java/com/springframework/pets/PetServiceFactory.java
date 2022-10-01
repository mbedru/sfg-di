package com.springframework.pets;

//we dont add @stereotypes b/c we thinkthecodeisntwithus(its,3rdparty)
//@Service
public class PetServiceFactory {

    public PetService getPetService(String petType) {
        switch(petType){
            case "cat" :
                return new CatPetService();
            case "dog" :
                return new DogPetService();
            default:
                return new DogPetService();
        }
    }
}
