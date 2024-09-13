package lk.restaurant.DTO;

public class ItemDetailsDTO {

    private Integer kot;
    private Integer qty;
    private String name;
    private Double amount;
    private String userName;

    public Integer getKot() {
        return kot;
    }

    public void setKot(Integer kot) {
        this.kot = kot;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
