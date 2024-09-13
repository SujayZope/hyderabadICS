package lk.restaurant.DTO;

import java.io.Serializable;

public class Front_kot_bot_item_voidDTO implements Serializable {

    private Integer id;
    private Integer kotNo;
    private Integer userId;
    private Integer userType;
    private Integer restaurantId;
    private Integer itemNo;
    private Integer qty;
    private Integer voidNo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getKotNo() {
        return kotNo;
    }

    public void setKotNo(Integer kotNo) {
        this.kotNo = kotNo;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }

    public Integer getItemNo() {
        return itemNo;
    }

    public void setItemNo(Integer itemNo) {
        this.itemNo = itemNo;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Integer getVoidNo() {
        return voidNo;
    }

    public void setVoidNo(Integer voidNo) {
        this.voidNo = voidNo;
    }
}
