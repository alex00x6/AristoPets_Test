package api.urls;


public enum ApiUrls {

    BASE("http://aristo-pets.com"),
    ADVERTSALL("/api/adverts/all"),
    ADVERT("/api/advert"),
    BREEDS("/api/breeds"),//supports "/id"
    USER("/api/user/"), //supports "/"
    PHOTO("/api/photo"),
    PHOTOANIMAL("/api/photo/animal/"),
    PHOTOADVERT("/api/photo/advert/"),
    PHOTOUSER("/api/photo/user/"),
    LOGIN("/login"),
    ANIMAL("/api/animal");//supports "/id"

    private String uri;

    ApiUrls(String url) {
        this.uri = url;
    }

    public String getUri() {
        return this.uri;
    }

    public String getUri(String suffix) {
        return this.uri + "/" + suffix;
    }

}