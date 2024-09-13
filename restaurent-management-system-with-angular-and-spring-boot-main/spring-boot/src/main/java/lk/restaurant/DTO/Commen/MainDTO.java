package lk.restaurant.DTO.Commen;

public class MainDTO {

    private Integer uId;
    private Integer userType;
    private String message;
    private Integer status;

    public MainDTO(Integer uId, Integer userType, String message, Integer status) {
        this.uId = uId;
        this.userType = userType;
        this.message = message;
        this.status = status;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
