package lk.restaurant.DTO;

public class TempDataDTO {
    Integer kotNo;
    Integer itemCode;
    Integer qty;
    Integer type;
    Integer print;

    public TempDataDTO(Integer kotNo, Integer itemCode, Integer qty, Integer type, Integer print) {
        this.kotNo = kotNo;
        this.itemCode = itemCode;
        this.qty = qty;
        this.type = type;
        this.print = print;
    }

    public Integer getKotNo() {
        return kotNo;
    }

    public void setKotNo(Integer kotNo) {
        this.kotNo = kotNo;
    }

    public Integer getItemCode() {
        return itemCode;
    }

    public void setItemCode(Integer itemCode) {
        this.itemCode = itemCode;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getPrint() {
        return print;
    }

    public void setPrint(Integer print) {
        this.print = print;
    }
}
