package lk.restaurant.DTO;

import java.text.DecimalFormat;

public class Front_kot_bot_itemDTO {

    private Integer itemNo;
    private Integer itemCode;
    private String itemName;
    private Double unitPrices;
    private Double discount;
    private Integer qty;
    private Double unitCost;
    private Double unitPricesWithTax;
    private Integer familyId;
    private Integer discountType;
    private Double value;
    private Integer isFamily;
    private Double taxAmount;

    public Integer getItemNo() {
        return itemNo;
    }

    public void setItemNo(Integer itemNo) {
        this.itemNo = itemNo;
    }

    public Integer getItemCode() {
        return itemCode;
    }

    public void setItemCode(Integer itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Double getUnitPrices() {
        return unitPrices;
    }

    public void setUnitPrices(Double unitPrices) {
        this.unitPrices = unitPrices;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Double getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(Double unitCost) {
        this.unitCost = unitCost;
    }

    public Double getUnitPricesWithtax() {
        return unitPricesWithTax;
    }

    public void setUnitPricesWithtax(Double unitPricesWithtax) {
        this.unitPricesWithTax = unitPricesWithtax;
    }

    public Integer getFamilyId() {
        return familyId;
    }

    public void setFamilyId(Integer familyId) {
        this.familyId = familyId;
    }

    public Double getUnitPricesWithTax() {
        return unitPricesWithTax;
    }

    public void setUnitPricesWithTax(Double unitPricesWithTax) {
        this.unitPricesWithTax = unitPricesWithTax;
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

    public Integer getDiscountType() {
        return discountType;
    }

    public void setDiscountType(Integer discountType) {
        this.discountType = discountType;
    }

    public Double getTaxAmount() {
        DecimalFormat df = new DecimalFormat("#.##");
        taxAmount = Double.valueOf(df.format(taxAmount));
        return taxAmount;
    }

    public void setTaxAmount(Double taxAmount) {
        DecimalFormat df = new DecimalFormat("#.##");
        taxAmount = Double.valueOf(df.format(taxAmount));
        this.taxAmount = taxAmount;
    }
}
