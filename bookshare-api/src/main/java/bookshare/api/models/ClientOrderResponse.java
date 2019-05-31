package bookshare.api.models;

public class ClientOrderResponse {
    Integer userId;
    String firstName;
    String lastName;
    Integer announceId;
    String comment;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public Integer getAnnounceId() {
        return announceId;
    }

    public void setAnnounceId(Integer announceId) {
        this.announceId = announceId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public ClientOrderResponse(){}

    public ClientOrderResponse(Integer userId, String firstName, String lastName, Integer announceId, String comment) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.announceId = announceId;
        this.comment = comment;
    }
}
