package lk.restaurant.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "m_item")
public class M_ItemEntity {

    @Id
    private Integer item_code;
    private Integer majer_gno;
    private Integer familyGno;
    private Integer master_gno;
    private Integer unit_no;
    private String item_name;
    private Integer deafault_Rate;
    private String item_Image;
    private Integer isSetMenu;
    private Integer userId;
    private Date currDate;
    private Integer revenueType;
    private Integer printer;
    private Integer itemOrderNo;
    private Double roundprice;
    private Double txtwithtax;
    private Integer invOutlet;
    private Integer groupNo;
    private Integer subMenu;
    private Integer isSubItem;
    private Integer currencyId;
    private Integer isSpa;
    private String barCode;
    private Double uberPickmePrice;

    public String getBra_code() {
        return bra_code;
    }

    public void setBra_code(String bra_code) {
        this.bra_code = bra_code;
    }

    private String bra_code;
    private Integer taxCalssid;
    private Double cost;


    public Double getUberPickmePrice() {
        return uberPickmePrice;
    }

    public void setUberPickmePrice(Double uberPickmePrice) {
        this.uberPickmePrice = uberPickmePrice;
    }

    public Integer getItem_code() {
        return item_code;
    }

    public void setItem_code(Integer item_code) {
        this.item_code = item_code;
    }

    public Integer getMajer_gno() {
        return majer_gno;
    }

    public void setMajer_gno(Integer majer_gno) {
        this.majer_gno = majer_gno;
    }

    public Integer getFamilyGno() {
        return familyGno;
    }

    public void setFamilyGno(Integer familyGno) {
        this.familyGno = familyGno;
    }

    public Integer getMaster_gno() {
        return master_gno;
    }

    public void setMaster_gno(Integer master_gno) {
        this.master_gno = master_gno;
    }

    public Integer getUnit_no() {
        return unit_no;
    }

    public void setUnit_no(Integer unit_no) {
        this.unit_no = unit_no;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public Integer getDeafault_Rate() {
        return deafault_Rate;
    }

    public void setDeafault_Rate(Integer deafault_Rate) {
        this.deafault_Rate = deafault_Rate;
    }

    public String getItem_Image() {
        return item_Image;
    }

    public void setItem_Image(String item_Image) {
        this.item_Image = item_Image;
    }

    public Integer getIsSetMenu() {
        return isSetMenu;
    }

    public void setIsSetMenu(Integer isSetMenu) {
        this.isSetMenu = isSetMenu;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getCurrDate() {
        return currDate;
    }

    public void setCurrDate(Date currDate) {
        this.currDate = currDate;
    }

    public Integer getRevenueType() {
        return revenueType;
    }

    public void setRevenueType(Integer revenueType) {
        this.revenueType = revenueType;
    }

    public Integer getPrinter() {
        return printer;
    }

    public void setPrinter(Integer printer) {
        this.printer = printer;
    }

    public Integer getItemOrderNo() {
        return itemOrderNo;
    }

    public void setItemOrderNo(Integer itemOrderNo) {
        this.itemOrderNo = itemOrderNo;
    }

    public Double getRoundprice() {
        return roundprice;
    }

    public void setRoundprice(Double roundprice) {
        this.roundprice = roundprice;
    }

    public Double getTxtwithtax() {
        return txtwithtax;
    }

    public void setTxtwithtax(Double txtwithtax) {
        this.txtwithtax = txtwithtax;
    }

    public Integer getInvOutlet() {
        return invOutlet;
    }

    public void setInvOutlet(Integer invOutlet) {
        this.invOutlet = invOutlet;
    }

    public Integer getGroupNo() {
        return groupNo;
    }

    public void setGroupNo(Integer groupNo) {
        this.groupNo = groupNo;
    }

    public Integer getSubMenu() {
        return subMenu;
    }

    public void setSubMenu(Integer subMenu) {
        this.subMenu = subMenu;
    }

    public Integer getIsSubItem() {
        return isSubItem;
    }

    public void setIsSubItem(Integer isSubItem) {
        this.isSubItem = isSubItem;
    }

    public Integer getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(Integer currencyId) {
        this.currencyId = currencyId;
    }

    public Integer getIsSpa() {
        return isSpa;
    }

    public void setIsSpa(Integer isSpa) {
        this.isSpa = isSpa;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public Integer getTaxCalssid() {
        return taxCalssid;
    }

    public void setTaxCalssid(Integer taxCalssid) {
        this.taxCalssid = taxCalssid;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }
}

