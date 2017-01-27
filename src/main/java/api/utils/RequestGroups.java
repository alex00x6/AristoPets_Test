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
//        requestSender.authorize(email, password, remember);
        requestSender.createEmptyRequestAuth().get(ApiUrls.USER.getUri());
        return requestSender;
    }

    public RequestSender putUser(String body){
        RequestSender requestSender = new RequestSender();
//        requestSender.authorize(email, password, remember);
        requestSender.createRequestAuth(body).put(ApiUrls.USER.getUri());
        return requestSender;
    }

}
