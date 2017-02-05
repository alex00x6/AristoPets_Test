import api.utils.Helpers;
import api.utils.JsonGenerator;
import api.utils.RequestGroups;
import api.utils.TestListener;
import com.jayway.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;


@Listeners(TestListener.class)
public class API {

    @BeforeClass
    public void beforeTest(){
        RequestGroups requestGroups = new RequestGroups();
        requestGroups.authorize();
    }

    @Test//it works
    public void updateUser(){
        String json = "{\n" +
                "  \"firstName\": \"василий\",\n" +
                "  \"lastName\": \"куропаточкин\",\n" +
                "  \"email\": \"geloks@bk.ru\",\n" +
                "  \"id\": 23,\n" +
                "  \"userType\": \"USER\",\n" +
                "  \"nursery\": null,\n" +
                "  \"authType\": \"EMAIL\",\n" +
                "  \"authId\": null,\n" +
                "  \"phoneNumber\": null,\n" +
                "  \"club\": null,\n" +
                "  \"photo\": \"/img/notAuth.png\",\n" +
                "  \"contractOfSale\": false\n" +
                "}";

        RequestGroups requestGroups = new RequestGroups();

        Response resp = requestGroups.putUser(json).getResponse();
        String response = resp.asString();

        System.out.println("Response: =>");
        System.out.println(response);
        System.out.println(resp.statusCode());

        Assert.assertTrue(resp.statusCode()==200);
        Assert.assertTrue(response.contains("firstName"));
        Assert.assertTrue(response.contains("lastName"));
        Assert.assertTrue(response.contains("email"));
        Assert.assertTrue(response.contains("id"));
        Assert.assertTrue(response.contains("userType"));
        Assert.assertTrue(response.contains("nursery"));
        Assert.assertTrue(response.contains("authType"));
        Assert.assertTrue(response.contains("authId"));
        Assert.assertTrue(response.contains("phoneNumber"));
        Assert.assertTrue(response.contains("club"));
        Assert.assertTrue(response.contains("socials"));
        Assert.assertTrue(response.contains("photo"));
        Assert.assertTrue(response.contains("contractOfSale"));
    }

    @Test
    public void getUser(){
        RequestGroups requestGroups = new RequestGroups();

        Response response = requestGroups.getUser().getResponse();//делаем get и забираем ответ сервера

        System.out.println("Response: =>");
        System.out.println(response.asString());
        System.out.println(response.statusCode());

        Assert.assertTrue(response.statusCode()==200);
        Assert.assertTrue(response.asString().contains("firstName"));
        Assert.assertTrue(response.asString().contains("lastName"));
        Assert.assertTrue(response.asString().contains("email"));
        Assert.assertTrue(response.asString().contains("id"));
        Assert.assertTrue(response.asString().contains("userType"));
        Assert.assertTrue(response.asString().contains("nursery"));
        Assert.assertTrue(response.asString().contains("authType"));
        Assert.assertTrue(response.asString().contains("authId"));
        Assert.assertTrue(response.asString().contains("phoneNumber"));
        Assert.assertTrue(response.asString().contains("club"));
        Assert.assertTrue(response.asString().contains("socials"));
        Assert.assertTrue(response.asString().contains("photo"));
        Assert.assertTrue(response.asString().contains("contractOfSale"));
        Assert.assertTrue(response.asString().contains("animals"));
        Assert.assertTrue(response.asString().contains("adverts"));
    }

    @Test
    public void userUpdate(){
        //создание всех нужных обьектов
        RequestGroups requestGroups = new RequestGroups();
        Helpers helpers = new Helpers();
        JsonGenerator jsonGenerator = new JsonGenerator();
        //поготовка body запроса
        String name = helpers.randomString();
        String lastname = helpers.randomString();
        String json = jsonGenerator.generateJsonUpdateUser(name,lastname);

        //кидаем get запрос, забираем его в string
        //проверяем, что сейчас юзер не содержит данных из запроса на апдейт
        String response1 = requestGroups.getUser().getResponse().asString();
        System.out.println(response1);
        Assert.assertTrue(!response1.contains(name) || !response1.contains(lastname));

        //апдейтим юзера и проверяем статускод ответа
        Response response2 = requestGroups.putUser(json).getResponse();
        System.out.println(response2.asString());
        Assert.assertTrue(response2.statusCode()==200);

        //забираем юзера и проверяем, что он содержит данные, которые мы в него засунули на предыдущем этапе
        String response3 = requestGroups.getUser().getResponse().asString();
        System.out.println(response3);
        Assert.assertTrue(response3.contains(name) && response3.contains(lastname));

    }


    @Test
    public void getBreeds(){
        RequestGroups requestGroups = new RequestGroups();
        Response response = requestGroups.getBreeds().getResponse();

        System.out.println("Response: =>");
        System.out.println(response.asString());
        System.out.println(response.statusCode());

        Assert.assertTrue(response.statusCode()==200);
        Assert.assertTrue(response.asString().contains("DOG"));
    }

    @Test
    public void getOneBreed(){
        RequestGroups requestGroups = new RequestGroups();
        Response response = requestGroups.getBreed("1").getResponse();

        System.out.println("Response: =>");
        System.out.println(response.asString());
        System.out.println(response.statusCode());

        Assert.assertTrue(response.statusCode()==200);
        Assert.assertTrue(response.asString().contains("DOG"));
        Assert.assertTrue(response.asString().contains("id"));
    }

    @Test
    public void getAllAdverts(){
        RequestGroups requestGroups = new RequestGroups();
        Response response = requestGroups.getAdvertsAll().getResponse();

        System.out.println("Response: =>");
        System.out.println(response.asString());
        System.out.println(response.statusCode());

        Assert.assertTrue(response.statusCode()==200);
    }


    @Test
    public void postPhotoUser(){
        String body = photoJson();

        RequestGroups requestGroups = new RequestGroups();
        Response response = requestGroups.postPhotoUser(body).getResponse();
        System.out.println("Response: =>");
        System.out.println(response.asString());
        System.out.println(response.statusCode());


        Assert.assertTrue(response.statusCode()==200);
        Assert.assertTrue(response.asString().contains("amazonaws"));
        Assert.assertTrue(response.asString().contains("apuserphoto"));
    }

    @Test
    public void postPhotoAdvert(){
        String body = photoJson();

        RequestGroups requestGroups = new RequestGroups();
        Response response = requestGroups.postPhotoAdvert(body).getResponse();
        System.out.println("Response: =>");
        System.out.println(response.asString());
        System.out.println(response.statusCode());


        Assert.assertTrue(response.statusCode()==200);
        Assert.assertTrue(response.asString().contains("amazonaws"));
        Assert.assertTrue(response.asString().contains("apadvertphoto"));
    }

    @Test
    public void postPhotoAnimal(){
        String body = photoJson();

        RequestGroups requestGroups = new RequestGroups();
        Response response = requestGroups.postPhotoAnimal(body).getResponse();
        System.out.println("Response: =>");
        System.out.println(response.asString());
        System.out.println(response.statusCode());


        Assert.assertTrue(response.statusCode()==200);
        Assert.assertTrue(response.asString().contains("amazonaws"));
        Assert.assertTrue(response.asString().contains("apanimalphoto"));
    }

    @Test
    public void updateUserPhoto(){
        String body = photoJson(); //готовим json с картинкой в base 64

        RequestGroups requestGroups = new RequestGroups();
        Helpers helpers = new Helpers();
        String response1 = requestGroups.getUser().getResponse().asString();//получаем json о user'e с сервера

        String photoUrl = requestGroups.postPhotoUser(body).getResponse().asString(); //постим фото в aws

        String newBody = helpers.jsonChangeValue(response1, "photo", photoUrl); //берем json user'a, и меняем в нем линк

        requestGroups.putUser(newBody);//отправляем новый json на сервер

        String response2 = requestGroups.getUser().getResponse().asString();//забираем с сервера инфо о user'e
        System.out.println(response2);

        Assert.assertTrue(!response1.equals(response2));//проверяем, отличается ли инфа сейчас от инфы, полученной ранее
        Assert.assertTrue(response2.contains(photoUrl));//проверяем, есть ли в ответе от сервера url с нашей картинкой
    }

    @Test
    public void addAnimal(){
        RequestGroups requestGroups = new RequestGroups();
        JsonGenerator jsonGenerator = new JsonGenerator();

        String body = jsonGenerator.generateJsonAnimal();

        Response response = requestGroups.postAnimal(body).getResponse();

        Assert.assertTrue(response.asString().contains("id"));
        Assert.assertTrue(response.asString().contains("name"));
        Assert.assertTrue(response.asString().contains("gender"));
        Assert.assertTrue(response.asString().contains("color"));
        Assert.assertTrue(response.asString().contains("club"));
        Assert.assertTrue(response.asString().contains("birthday"));
        Assert.assertTrue(response.asString().contains("nursery"));
        Assert.assertTrue(response.asString().contains("moreInfo"));
        Assert.assertTrue(response.asString().contains("breed"));
        Assert.assertTrue(response.asString().contains("readyToCopulation"));
        Assert.assertTrue(response.asString().contains("userId"));
        Assert.assertTrue(response.asString().contains("photos"));
        Assert.assertTrue(response.asString().contains("titles"));


        String id = response.jsonPath().get("id").toString();
        System.out.println("ID ====>>>"+ id);
        System.out.println(response.asString());

        Response response2 = requestGroups.deleteAnimal(id).getResponse();
        Assert.assertTrue(response2.statusCode()==200);
        System.out.println("ID ====>>>"+ id + " DELETED");

    }

    @Test
    public void updateAnimal(){
        RequestGroups requestGroups = new RequestGroups();
        JsonGenerator jsonGenerator = new JsonGenerator();
        Helpers helpers = new Helpers();

        String createBody = jsonGenerator.generateJsonAnimal();

        Response response = requestGroups.postAnimal(createBody).getResponse();
        String id = response.jsonPath().get("id").toString();
        String json = response.asString();
        System.out.println(json);

        Map<String, String> map = new HashMap<>();
        map.put("name", helpers.randomString());
        map.put("club", helpers.randomString());
        map.put("nursery", helpers.randomString());
        map.put("moreInfo", helpers.randomString());

        String newBody = helpers.jsonChangeValues(createBody, map);

        Response response1 = requestGroups.putAnimal(id, newBody).getResponse();
        System.out.println(response1.asString());
        Assert.assertTrue(response1.statusCode()==200);
        helpers.assertContains(response1.asString(), map);

        Response response3 = requestGroups.deleteAnimal(id).getResponse();
        Assert.assertTrue(response3.statusCode()==200);
    }



    //TODO: отсюда и дальше


    @Test
    public void getAnimal(){
        RequestGroups requestGroups = new RequestGroups();
        Response response = requestGroups.getAnimals().getResponse();
        Assert.assertTrue(response.statusCode()==200);
        System.out.println(response.asString());
    }

    @Test
    public void getAnimalById(){
        RequestGroups requestGroups = new RequestGroups();
        Response response = requestGroups.getAnimals("31").getResponse();
        Assert.assertTrue(response.statusCode()==200);
        System.out.println(response.asString());
    }

    @Test
    public void deleteAnimalById(){
        RequestGroups requestGroups = new RequestGroups();
        Response response = requestGroups.deleteAnimal("31").getResponse();
        Assert.assertTrue(response.statusCode()==200);
        System.out.println(response.statusCode());
        System.out.println(response.asString());
    }

    @Test
    public void getAdverts(){
        RequestGroups requestGroups = new RequestGroups();
        Response response = requestGroups.getAdverts().getResponse();
        Assert.assertTrue(response.statusCode()==200);
        System.out.println(response.statusCode());
        System.out.println(response.asString());

    }

    @Test
    public void getAdvertbyId(){
        RequestGroups requestGroups = new RequestGroups();
        Response response = requestGroups.getAdvert("31").getResponse();
        Assert.assertTrue(response.statusCode()==200);
        System.out.println(response.statusCode());
        System.out.println(response.asString());
    }

    @Test
    public void postAdvert(){
        RequestGroups requestGroups = new RequestGroups();
        String body = "";

        Response response = requestGroups.postAdvert(body).getResponse();
        Assert.assertTrue(response.statusCode()==200);
        System.out.println(response.statusCode());
        System.out.println(response.asString());
    }

    @Test
    public void updateAdvert(){
        RequestGroups requestGroups = new RequestGroups();
        String body = "";

        Response response = requestGroups.putAdvert("31", body).getResponse();
        Assert.assertTrue(response.statusCode()==200);
        System.out.println(response.statusCode());
        System.out.println(response.asString());
    }

    @Test
    public void deleteAdvert(){
        RequestGroups requestGroups = new RequestGroups();
        Response response = requestGroups.deleteAdvert("31").getResponse();
        Assert.assertTrue(response.statusCode()==200);
        System.out.println(response.statusCode());
        System.out.println(response.asString());
    }











    String photoJson(){
        String bodyPhotoBase64 = "{\"photo\":\"data:image/jpeg;base64,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\"}";
        return bodyPhotoBase64;
    }


}
