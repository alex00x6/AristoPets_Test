package api.utils;


import org.json.JSONObject;


public class JsonGenerator {

    /*
    "{\n" +
            "  \"firstName\": \"василий\",\n" +
            "  \"lastName\": \"петухович\",\n" +
            "  \"email\": \"geloks@bk.ru\",\n" +
            "  \"id\": 27,\n" +
            "  \"userType\": \"USER\",\n" +
            "  \"nursery\": null,\n" +
            "  \"authType\": \"EMAIL\",\n" +
            "  \"authId\": null,\n" +
            "  \"phoneNumber\": null,\n" +
            "  \"club\": null,\n" +
            "  \"photo\": \"/img/notAuth.png\",\n" +
            "  \"contractOfSale\": false\n" +
            "}";
    */
    public String generateJsonUpdateUser(String name, String lastname){
        String jsonObject = new JSONObject()
                .put("firstName", name)
                .put("lastName", lastname)
//               .put("email", "email")
                .put("id", "27")
                .put("userType", "USER")
//                .put("nursery", "nursery")
//                .put("authType", "authtype")
//                .put("authId", "authid")
//                .put("phoneNumber", "phonenumber")
//                .put("club", "club")
                .put("photo", "/img/notAuth.png")
//                .put("contractOfSale", "contractofsale")
                .toString();
        return jsonObject;
    }


}
