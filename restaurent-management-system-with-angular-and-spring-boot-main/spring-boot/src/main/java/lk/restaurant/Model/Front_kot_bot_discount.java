package lk.restaurant.Model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Front_kot_bot_discount")
public class Front_kot_bot_discount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer discountNo;
    private Integer kotBotNo;
    private Integer disvountType;
    private Double value;

    @Temporal(value = TemporalType.DATE)
    private Date cdate;
    private Integer userId;
    private String remark;
    private Integer Valuetype;
    private Integer isfamily;
    private Integer itemNo;
    private Integer frompms;
    private Integer havetotalbilldis;

    public Integer getDiscountNo() {
        return discountNo;
    }

    public void setDiscountNo(Integer discountNo) {
        this.discountNo = discountNo;
    }

    public Integer getKotBotNo() {
        return kotBotNo;
    }

    public void setKotBotNo(Integer kotBotNo) {
        this.kotBotNo = kotBotNo;
    }

    public Integer getDisvountType() {
        return disvountType;
    }

    public void setDisvountType(Integer disvountType) {
        this.disvountType = disvountType;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Date getCdate() {
        return cdate;
    }

    public void setCdate(Date cdate) {
        this.cdate = cdate;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getValuetype() {
        return Valuetype;
    }

    public void setValuetype(Integer valuetype) {
        Valuetype = valuetype;
    }

    public Integer getIsfamily() {
        return isfamily;
    }

    public void setIsfamily(Integer isfamily) {
        this.isfamily = isfamily;
    }

    public Integer getItemNo() {
        return itemNo;
    }

    public void setItemNo(Integer itemNo) {
        this.itemNo = itemNo;
    }

    public Integer getFrompms() {
        return frompms;
    }

    public void setFrompms(Integer frompms) {
        this.frompms = frompms;
    }

    public Integer getHavetotalbilldis() {
        return havetotalbilldis;
    }

    public void setHavetotalbilldis(Integer havetotalbilldis) {
        this.havetotalbilldis = havetotalbilldis;
    }
}
