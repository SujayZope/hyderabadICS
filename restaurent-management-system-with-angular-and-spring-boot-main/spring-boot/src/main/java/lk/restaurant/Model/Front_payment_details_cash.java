package lk.restaurant.Model;

import javax.persistence.*;

//@Entity
//@Table(name = "front_payment_details_cash")
public class Front_payment_details_cash {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer Detail_id;
    Integer Payment_id;
    Double Amount;
    Integer Currencyno;
    Double Exchngrate;
    Integer State;
}
