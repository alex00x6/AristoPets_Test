package api.utils;


import api.dto.TestAnimalDto;
import api.dto.TestUserDto;

public class DtoGenerator extends Helpers{
    TestUserDto testUserDto = null;
    TestAnimalDto testAnimalDto = null;

    public TestUserDto generateUserMinimum(){
        testUserDto.setFirstName("MockFirstName");
        testUserDto.setLastName("MockLastName");
        testUserDto.setUserType("USER");
        testUserDto.setPhoto("/img/notAuth.png");
        return testUserDto;
    }

    public TestUserDto generateUserRandomMinimum(){
        testUserDto.setFirstName(randomString());
        testUserDto.setLastName(randomString());
        testUserDto.setUserType("USER");
        testUserDto.setPhoto("/img/notAuth.png");
        return testUserDto;
    }

    public TestAnimalDto generateAnimalMinimum(){
        testAnimalDto.setName("Василиса");
        testAnimalDto.setGender("FEMALE");
        testAnimalDto.setColor("White");
        testAnimalDto.setBirthday("2015-01-01");
        testAnimalDto.setClub("KSU");
        testAnimalDto.setNursery("Hillelskaya prelest");
        testAnimalDto.setMoreInfo("great dog with big teeth");
        testAnimalDto.setBreedId(1);

        return testAnimalDto;
    }



}
