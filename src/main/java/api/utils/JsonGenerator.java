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


    /*
    {
	"name": "Brunhilda",
	"gender": "FEMALE",
	"color": "White-red",
	"birthday": "2015-01-01",
	"club": "KSU",
	"nursery": "FRANCUZSKOE VELIKOLEPIE",
	"moreInfo": "Cute Dog",
	"breedId": 1,
	"readyToCopulation": false,
	"userId": 1,
	"photos": ["https://apadvertphoto.s3.eu-central-1.amazonaws.com/d0854045-fd86-4aed-88b6-3afd1001ed3a"],
	"titles": ["Mark:Excellent", "YOU"]
}
     */

    public String generateJsonAnimal(){
        String jsonObject = new JSONObject()
                .put("name", "DaniilTheCoder")
                .put("gender", "none")
                .put("color", "white")
                .put("birthday", "2016-01-02")//без этой штуки error 500 nullpointerexception
                .put("club", "Hillel")
                .put("nursery", "Hillelskoe Velikolepie")
                .put("moreInfo", "great pet")
                .put("breedId", 1)//int
//                .put("readyToCopulation", "false")//boolean
//                .put("userId", "1")//int
 //               .put("photos", "photos")//array here
//                .put("titles", "titles")//array here
                .toString();
        return jsonObject;
    }



}
