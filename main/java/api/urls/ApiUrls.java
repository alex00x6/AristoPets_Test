package api.urls;


public enum ApiUrls {

    BASE("http://aristo-pets.com"),
    ADVERTS("/api/adverts"),
    BREEDS("/api/breeds"),
    USER("/api/user"),
    ANIMAL("/api/animal");

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