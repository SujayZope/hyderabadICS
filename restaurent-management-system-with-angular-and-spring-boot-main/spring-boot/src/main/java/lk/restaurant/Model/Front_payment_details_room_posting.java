package lk.restaurant.Model;

import javax.persistence.*;

//@Entity
//@Table(name = "front_payment_details_room_posting")
public class Front_payment_details_room_posting {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer Detail_id;
    Integer Payment_id;
    String Room_no;
    String Guest_id;
    String Conf_no;
}
