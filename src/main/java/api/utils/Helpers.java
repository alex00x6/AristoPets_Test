package api.utils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.security.SecureRandom;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

/**
 * Created by Storm on 27.01.2017.
 */
public class Helpers {

    public String randomString(){
        int length = 6;
        String rand = createRandomText(length, "ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        return rand;
    }

    public int randomInt(){
        int rand = Math.toIntExact(generateRandomNumber(6));

        return rand;
    }


    private String createRandomText(int codeLength, String id) {
        return new SecureRandom()
                .ints(codeLength, 0, id.length())
                .mapToObj(id::charAt)
                .map(Object::toString)
                .collect(Collectors.joining());
    }

    private long generateRandomNumber(int n) {
        long min = (long) Math.pow(10, n - 1);
        return ThreadLocalRandom.current().nextLong(min, min * 10);
    }


    public String jsonChangeValue(String jsonString, String key, String newValue){
        JsonObject object = (JsonObject) new JsonParser().parse(jsonString);
        object.remove(key);
        object.addProperty(key, newValue);

        return object.toString();
    }
}
