package lk.restaurant.DTO;

import java.io.Serializable;
import java.util.Date;

public class Front_kot_bot_discountDTO implements Serializable {

    private Integer discountType;
    private Double value;
    private Integer isFamily;



    public Integer getDiscountType() {
        return discountType;
    }

    public void setDiscountType(Integer discountType) {
        this.discountType = discountType;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Integer getIsFamily() {
        return isFamily;
    }

    public void setIsFamily(Integer isFamily) {
        this.isFamily = isFamily;
    }
}
