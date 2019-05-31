package bookshare.api.models;

public class OrderApproveRequest {

    Integer userId;
    Integer announceId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getAnnounceId() {
        return announceId;
    }

    public void setAnnounceId(Integer announceId) {
        this.announceId = announceId;
    }

    public OrderApproveRequest(){}

    public OrderApproveRequest(Integer userId, Integer announceId) {
        this.userId = userId;
        this.announceId = announceId;
    }
}

