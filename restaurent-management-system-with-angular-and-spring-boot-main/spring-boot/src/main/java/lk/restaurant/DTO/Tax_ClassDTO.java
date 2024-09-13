package lk.restaurant.DTO;

public class Tax_ClassDTO {

    Integer taxClassId;
    Integer taxNo;
    Integer rate;
    Double calculateValue;

    public Double getCalculateValue() {
        return calculateValue;
    }

    public void setCalculateValue(Double calculateValue) {
        this.calculateValue = calculateValue;
    }

    public Integer getTaxClassId() {
        return taxClassId;
    }

    public void setTaxClassId(Integer taxClassId) {
        this.taxClassId = taxClassId;
    }

    public Integer getTaxNo() {
        return taxNo;
    }

    public void setTaxNo(Integer taxNo) {
        this.taxNo = taxNo;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }
}
