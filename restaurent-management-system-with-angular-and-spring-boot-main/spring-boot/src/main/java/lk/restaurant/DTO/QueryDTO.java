package lk.restaurant.DTO;

public class QueryDTO {

    private Integer kot;
    private Integer itemNo;
    private Integer itemCode;
    private Integer qty;
    private Double price;
    private Double priceWithTax;
    private String itemName;
    private String userName;
    private Integer rate;
    private Integer familyId;
    private Double disPercentage;
    private Double cost;

    public Integer getKot() {
        return kot;
    }

    public void setKot(Integer kot) {
        this.kot = kot;
    }

    public Integer getItemNo() {
        return itemNo;
    }

    public Integer getItemCode() {
        return itemCode;
    }

    public void setItemCode(Integer itemCode) {
        this.itemCode = itemCode;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getPriceWithTax() {
        return priceWithTax;
    }

    public void setPriceWithTax(Double priceWithTax) {
        this.priceWithTax = priceWithTax;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public Integer getFamilyId() {
        return familyId;
    }

    public void setFamilyId(Integer familyId) {
        this.familyId = familyId;
    }

    public Double getDisPercentage() {
        return disPercentage;
    }

    public void setDisPercentage(Double disPercentage) {
        this.disPercentage = disPercentage;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }
}
