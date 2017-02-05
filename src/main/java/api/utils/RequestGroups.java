package api.utils;

import api.urls.ApiUrls;

public class RequestGroups{
    //for authorization
    private final String email = "1@1.com";
    private final String password = "111111";
    private final boolean remember = true;

    public void authorize(){
        RequestSender requestSender = new RequestSender();
        requestSender.authorize(email, password, remember);
    }

    public RequestSender getUser(){
        RequestSender requestSender = new RequestSender();
        requestSender.createEmptyRequestAuth().get(ApiUrls.USER.getUri());
        return requestSender;
    }

    public RequestSender putUser(String body){
        RequestSender requestSender = new RequestSender();
        requestSender.createRequestAuth(body).put(ApiUrls.USER.getUri());
        return requestSender;
    }

    public RequestSender getBreeds(){
        RequestSender requestSender = new RequestSender();
        requestSender.createEmptyRequestAuth().get(ApiUrls.BREEDS.getUri());
        return requestSender;
    }

    public RequestSender getBreed(String id){
        RequestSender requestSender = new RequestSender();
        requestSender.createEmptyRequestAuth().get(ApiUrls.BREEDS.getUri(id));
        return requestSender;
    }

    public RequestSender getAdvertsAll(){
        RequestSender requestSender = new RequestSender();
        requestSender.createEmptyRequestAuth().get(ApiUrls.ADVERTSALL.getUri());
        return  requestSender;
    }

    public RequestSender postPhotoUser(String body){
        RequestSender requestSender = new RequestSender();
        requestSender.createRequestAuth(body).post(ApiUrls.PHOTOUSER.getUri());
        return requestSender;
    }

    public RequestSender postPhotoAnimal(String body){
        RequestSender requestSender = new RequestSender();
        requestSender.createRequestAuth(body).post(ApiUrls.PHOTOANIMAL.getUri());
        return requestSender;
    }

    public RequestSender postPhotoAdvert(String body){
        RequestSender requestSender = new RequestSender();
        requestSender.createRequestAuth(body).post(ApiUrls.PHOTOADVERT.getUri());
        return requestSender;
    }

    public RequestSender postAnimal(String body){
        RequestSender requestSender = new RequestSender();
        requestSender.createRequestAuth(body).post(ApiUrls.ANIMAL.getUri(""));
        return requestSender;
    }

    public RequestSender putAnimal(String id, String body){
        RequestSender requestSender = new RequestSender();
        requestSender.createRequestAuth(body).put(ApiUrls.ANIMAL.getUri(id));
        return requestSender;
    }

    public RequestSender getAnimals(){
        RequestSender requestSender = new RequestSender();
        requestSender.createEmptyRequestAuth().get(ApiUrls.ANIMAL.getUri(""));
        return requestSender;
    }

    public RequestSender getAnimals(String id){
        RequestSender requestSender = new RequestSender();
        requestSender.createEmptyRequestAuth().get(ApiUrls.ANIMAL.getUri(id));
        return requestSender;
    }

    public RequestSender deleteAnimal(String id){
        RequestSender requestSender = new RequestSender();
        requestSender.createEmptyRequestAuth().delete(ApiUrls.ANIMAL.getUri(id));
        return requestSender;
    }

    public RequestSender getAdverts(){
        RequestSender requestSender = new RequestSender();
        requestSender.createEmptyRequestAuth().get(ApiUrls.ADVERT.getUri(""));
        return requestSender;
    }

    public RequestSender getAdvert(String id){
        RequestSender requestSender = new RequestSender();
        requestSender.createEmptyRequestAuth().get(ApiUrls.ADVERT.getUri(id));
        return requestSender;
    }

    public RequestSender postAdvert(String body){
        RequestSender requestSender = new RequestSender();
        requestSender.createRequestAuth(body).post(ApiUrls.ADVERT.getUri());
        return requestSender;
    }

    public RequestSender putAdvert(String id, String body){
        RequestSender requestSender = new RequestSender();
        requestSender.createRequestAuth(body).put(ApiUrls.ADVERT.getUri(id));
        return requestSender;
    }

    public RequestSender deleteAdvert(String id){
        RequestSender requestSender = new RequestSender();
        requestSender.createEmptyRequestAuth().delete(ApiUrls.ADVERT.getUri(id));
        return requestSender;
    }
}
