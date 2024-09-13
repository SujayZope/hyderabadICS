package lk.restaurant.DTO;

import lk.restaurant.Model.Front_kot_bot_main;

public class Front_kot_bot_menuDTO {

    private Front_kot_bot_main kot_bot_no;
    private Integer is_setmenu;
    private Integer set_menu_no;


    public Front_kot_bot_main getKot_bot_no() {
        return kot_bot_no;
    }

    public void setKot_bot_no(Front_kot_bot_main kot_bot_no) {
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
