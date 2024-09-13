package lk.restaurant.DTO;

public class RestaurantDTO {

    private Integer restaurantId;
    private String rName;

    public RestaurantDTO() { }

    public RestaurantDTO(Integer restaurantId, String rName) {
        this.restaurantId = restaurantId;
        this.rName = rName;
    }

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getrName() {
        return rName;
    }

    public void setrName(String rName) {
        this.rName = rName;
    }
}
