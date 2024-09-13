package lk.restaurant.Model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "front_kot_bot_menu")
public class Front_kot_bot_menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer menu_id;
    private Integer kot_bot_no;
    private Integer is_setmenu;
    private Integer set_menu_no;

    public Integer getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(Integer menu_id) {
        this.menu_id = menu_id;
    }

    public Integer getKot_bot_no() {
        return kot_bot_no;
    }

    public void setKot_bot_no(Integer kot_bot_no) {
        this.kot_bot_no = kot_bot_no;
    }

    public Integer getIs_setmenu() {
        return is_setmenu;
    }

    public void setIs_setmenu(Integer is_setmenu) {
        this.is_setmenu = is_setmenu;
    }

    public Integer getSet_menu_no() {
        return set_menu_no;
    }

    public void setSet_menu_no(Integer set_menu_no) {
        this.set_menu_no = set_menu_no;
    }


}
