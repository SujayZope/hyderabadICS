package lk.restaurant.Model;

import javax.persistence.*;

@Entity
@Table(name = "config_restaurant_item")
public class Config_restaurant_item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer res_no;
    private Integer majer_no;
    private Integer family_no;
    private Integer master_no;
    private Integer item_no;

}
