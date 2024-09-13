package lk.restaurant.Model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "front_kot_bot_item")
public class Front_kot_bot_item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer item_no;
    private Integer Item_Code;
    private Integer kot_bot_no;
    private Integer menu_id;
    private Integer tax_class;
    private Date order_time;
    private Date delivery_time;
    private Double unit_prices;
    private Double discount;
    private Integer QTY;
    private Integer issetmenu;
    private Double unit_cost;
    private String Itemcomment;
    private Double unit_prices_withtax;

    public Integer getItem_no() {
        return item_no;
    }

    public void setItem_no(Integer item_no) {
        this.item_no = item_no;
    }

    public Integer getItem_Code() {
        return Item_Code;
    }

    public void setItem_Code(Integer item_Code) {
        Item_Code = item_Code;
    }

    public Integer getKot_bot_no() {
        return kot_bot_no;
    }

    public void setKot_bot_no(Integer kot_bot_no) {
        this.kot_bot_no = kot_bot_no;
    }

    public Integer getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(Integer menu_id) {
        this.menu_id = menu_id;
    }

    public Integer getTax_class() {
        return tax_class;
    }

    public void setTax_class(Integer tax_class) {
        this.tax_class = tax_class;
    }

    public Date getOrder_time() {
        return order_time;
    }

    public void setOrder_time(Date order_time) {
        this.order_time = order_time;
    }

    public Date getDelivery_time() {
        return delivery_time;
    }

    public void setDelivery_time(Date delivery_time) {
        this.delivery_time = delivery_time;
    }

    public Double getUnit_prices() {
        return unit_prices;
    }

    public void setUnit_prices(Double unit_prices) {
        this.unit_prices = unit_prices;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Integer getQTY() {
        return QTY;
    }

    public void setQTY(Integer QTY) {
        this.QTY = QTY;
    }

    public Integer getIssetmenu() {
        return issetmenu;
    }

    public void setIssetmenu(Integer issetmenu) {
        this.issetmenu = issetmenu;
    }

    public Double getUnit_cost() {
        return unit_cost;
    }

    public void setUnit_cost(Double unit_cost) {
        this.unit_cost = unit_cost;
    }

    public String getItemcomment() {
        return Itemcomment;
    }

    public void setItemcomment(String itemcomment) {
        Itemcomment = itemcomment;
    }

    public Double getUnit_prices_withtax() {
        return unit_prices_withtax;
    }

    public void setUnit_prices_withtax(Double unit_prices_withtax) {
        this.unit_prices_withtax = unit_prices_withtax;
    }
}
