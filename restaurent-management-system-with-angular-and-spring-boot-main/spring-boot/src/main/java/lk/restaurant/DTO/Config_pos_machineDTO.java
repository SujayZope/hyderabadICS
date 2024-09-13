package lk.restaurant.DTO;

public class Config_pos_machineDTO {

    private Integer pos_machine_id;
    private Integer restraunt_id;
    private Integer pos_no;
    private String pos_ip;

    public Integer getPos_machine_id() {
        return pos_machine_id;
    }

    public void setPos_machine_id(Integer pos_machine_id) {
        this.pos_machine_id = pos_machine_id;
    }

    public Integer getRestraunt_id() {
        return restraunt_id;
    }

    public void setRestraunt_id(Integer restraunt_id) {
        this.restraunt_id = restraunt_id;
    }

    public Integer getPos_no() {
        return pos_no;
    }

    public void setPos_no(Integer pos_no) {
        this.pos_no = pos_no;
    }

    public String getPos_ip() {
        return pos_ip;
    }

    public void setPos_ip(String pos_ip) {
        this.pos_ip = pos_ip;
    }
}
