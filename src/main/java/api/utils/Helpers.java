package api.utils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.security.SecureRandom;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;


public class Helpers {

    public String randomString(){
        int length = 6;
        String rand = createRandomText(length, "ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        return rand;
    }

    public int randomInt(){
        int length = 6;
        int rand = Math.toIntExact(generateRandomNumber(length));
        return rand;
    }


    private String createRandomText(int length, String id) {
        return new SecureRandom()
                .ints(length, 0, id.length())
                .mapToObj(id::charAt)
                .map(Object::toString)
                .collect(Collectors.joining());
    }

    private long generateRandomNumber(int length) {
        long min = (long) Math.pow(10, length - 1);
        return ThreadLocalRandom.current().nextLong(min, min * 10);
    }


    public String jsonChangeValue(String jsonString, String key, String newValue){
        JsonObject object = (JsonObject) new JsonParser().parse(jsonString);
        object.remove(key);
        object.addProperty(key, newValue);

        return object.toString();
    }
}
