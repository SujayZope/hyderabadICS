package lk.restaurant.Service;

import lk.restaurant.DTO.Consolidate_detailDTO;
import lk.restaurant.DTO.Front_PaymentDTO;

public interface Payment_Service {

    boolean addPayment(Front_PaymentDTO paymentDTO);

    boolean addConsolidateDetails(Consolidate_detailDTO consolidate_detailDTO);

   // boolean savePaymentDetailsWhenPrintedBill(Front_PaymentDTO front_paymentDTO);
}
