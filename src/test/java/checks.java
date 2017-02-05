import api.utils.Helpers;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Storm on 05.02.2017.
 */
public class checks {

    @Test
    public void mapTest(){
        Helpers helpers = new Helpers();
        String json = "{\"id\":2067,\"name\":\"DaniilTheCoder\",\"gender\":\"FEMALE\",\"color\":\"white\",\"birthday\":\"2016-01-02\",\"club\":\"Hillel\",\"nursery\":\"Hillelskoe Velikolepie\",\"moreInfo\":\"great pet\",\"breed\":{\"id\":1,\"name\":\"Affenpinscher\",\"animalType\":\"DOG\"},\"readyToCopulation\":false,\"userId\":0,\"photos\":[\"/img/noAnimal.jpg\"],\"titles\":null}";

        Map<String, String> map = new HashMap<>();
        map.put("name", "cat");
        map.put("club", "clubless");

        String novi = helpers.jsonChangeValues(json, map);
        System.out.println(novi);

    }
}
