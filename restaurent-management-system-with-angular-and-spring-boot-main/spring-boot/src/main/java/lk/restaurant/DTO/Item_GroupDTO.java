package lk.restaurant.DTO;

import java.text.DecimalFormat;

public class Item_GroupDTO {

    private Integer iid;
    private String name;
    private Double price;
    private Double taxPrice;
    private String barCode;
    private Double uberPickmePrice;

    public Item_GroupDTO(Integer iid, String name, Double price, Double taxPrice,Double uberPickmePrice) {
        this.iid = iid;
        this.name = name;
        this.price = price;
        this.taxPrice = taxPrice;
        this.uberPickmePrice = uberPickmePrice;

    }

    public Item_GroupDTO(){}

    public Item_GroupDTO(Integer item_code, String item_name, Double rate_value, Double roundprice) {
        this.iid = iid;
        this.name = name;
        this.price = price;
        this.taxPrice = taxPrice;
    }

    public Double getUberPickmePrice() {
        return uberPickmePrice;
    }

    public void setUberPickmePrice(Double uberPickmePrice) {
        this.uberPickmePrice = uberPickmePrice;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public Integer getIid() {
        return iid;
    }

    public void setIid(Integer iid) {
        this.iid = iid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        DecimalFormat df = new DecimalFormat("#.##");
        price = Double.valueOf(df.format(price));
        return price;
    }

    public void setPrice(Double price)
    {
        DecimalFormat df = new DecimalFormat("#.##");
        price = Double.valueOf(df.format(price));
        this.price = price;
    }

    public Double getTaxPrice() {
        DecimalFormat df = new DecimalFormat("#.##");
        price = Double.valueOf(df.format(price));
        return taxPrice;
    }

    public void setTaxPrice(Double taxPrice) {
        DecimalFormat df = new DecimalFormat("#.##");
        taxPrice = Double.valueOf(df.format(taxPrice));
        this.taxPrice = taxPrice;
    }
}
