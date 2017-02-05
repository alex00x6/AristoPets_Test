package api.dto;

public class TestUserDto{

    private String firstName;
    private String lastName;
    private String email;
    private String id;
    private String userType;
    private String nursery;
    private String authType;
    private String authId;
    private String phoneNumber;
    private String club;
    private String socials;
    private String photo;
    private boolean contractOfSale;
  //  private List<String> animals;
   // private List<String> adverts;



    @Override
    public String toString() {
        return "TestUserDto{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", id=" + id +
                ", userType='" + userType + '\'' +
                ", nursery='" + nursery + '\'' +
                ", authType='" + authType + '\'' +
                ", authId='" + authId + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", club='" + club + '\'' +
                ", socials='" + socials + '\'' +
                ", photo='" + photo + '\'' +
                ", contractOfSale=" + contractOfSale +
                '}';
    }

    public String getId() { return id; }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNursery() {
        return nursery;
    }

    public void setNursery(String nursery) {
        this.nursery = nursery;
    }

    public String getAuthType() {
        return authType;
    }

    public void setAuthType(String authType) {
        this.authType = authType;
    }

    public String getAuthId() {
        return authId;
    }

    public void setAuthId(String authId) {
        this.authId = authId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public String getSocials() {
        return socials;
    }

    public void setSocials(String socials) {
        this.socials = socials;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public boolean isContractOfSale() {
        return contractOfSale;
    }

    public void setContractOfSale(boolean contractOfSale) {
        this.contractOfSale = contractOfSale;
    }
//
//    public List<String> getAnimals() {
//        return animals;
//    }
//
//    public void setAnimals(List<String> animals) {
//        this.animals = animals;
//    }
//
//    public List<String> getAdverts() {
//        return adverts;
//    }
//
//    public void setAdverts(List<String> adverts) {
//        this.adverts = adverts;
//    }
}
