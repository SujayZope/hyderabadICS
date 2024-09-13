package lk.restaurant.Model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "userlogin")
public class UserLogin {

    @Id
    private Integer User_Id;
    private String userName;
    private String Pwd;
    private Integer User_type;
    private Integer active;
    private String pwCord;
    private Integer Is_custom;
    private Integer Is_delete;
    private Integer isshow;

    public Integer getUser_Id() {
        return User_Id;
    }

    public void setUser_Id(Integer user_Id) {
        User_Id = user_Id;
    }


    public String getPwd() {
        return Pwd;
    }

    public void setPwd(String pwd) {
        Pwd = pwd;
    }

    public Integer getUser_type() {
        return User_type;
    }

    public void setUser_type(Integer user_type) {
        User_type = user_type;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPwCord() {
        return pwCord;
    }

    public void setPwCord(String pwCord) {
        this.pwCord = pwCord;
    }

    public Integer getIsshow() {
        return isshow;
    }

    public void setIsshow(Integer isshow) {
        this.isshow = isshow;
    }

    public Integer getIs_custom() {
        return Is_custom;
    }

    public void setIs_custom(Integer is_custom) {
        Is_custom = is_custom;
    }

    public Integer getIs_delete() {
        return Is_delete;
    }

    public void setIs_delete(Integer is_delete) {
        Is_delete = is_delete;
    }


}
