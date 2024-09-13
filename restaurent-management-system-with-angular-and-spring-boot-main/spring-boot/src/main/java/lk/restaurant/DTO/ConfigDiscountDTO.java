package lk.restaurant.DTO;

import java.io.Serializable;
import java.util.List;

public class ConfigDiscountDTO implements Serializable {

    private Integer disNo;
    private Integer familyNo;
    private String disPosName;
    private Integer disType;
    private Double disPercentage;
    private Double disValue;
    private Integer isFamily;

    public ConfigDiscountDTO() {
    }

    public ConfigDiscountDTO(Integer disNo, Integer familyNo, String disPosName, Integer disType, Double disPercentage, Double disValue, Integer isFamily) {
        this.disNo = disNo;
        this.familyNo = familyNo;
        this.disPosName = disPosName;
        this.disType = disType;
        this.disPercentage = disPercentage;
        this.disValue = disValue;
        this.isFamily = isFamily;
    }

    public Integer getDisNo() {
        return disNo;
    }

    public void setDisNo(Integer disNo) {
        this.disNo = disNo;
    }

    public Integer getFamilyNo() {
        return familyNo;
    }

    public void setFamilyNo(Integer familyNo) {
        this.familyNo = familyNo;
    }

    public String getDisPosName() {
        return disPosName;
    }

    public void setDisPosName(String disPosName) {
        this.disPosName = disPosName;
    }

    public Integer getDisType() {
        return disType;
    }

    public void setDisType(Integer disType) {
        this.disType = disType;
    }

    public Double getDisPercentage() {
        return disPercentage;
    }

    public void setDisPercentage(Double disPercentage) {
        this.disPercentage = disPercentage;
    }

    public Double getDisValue() {
        return disValue;
    }

    public void setDisValue(Double disValue) {
        this.disValue = disValue;
    }


    public Integer getIsFamily() {
        return isFamily;
    }

    public void setIsFamily(Integer isFamily) {
        this.isFamily = isFamily;
    }
}
