package lk.restaurant.Repository;

import lk.restaurant.Model.Front_Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Front_PaymentRepository extends JpaRepository<Front_Payment,Integer> {
    Front_Payment save(Front_Payment frontPayment);

    // boolean savePaymentDetailsWhenPrintedBill(Front_PaymentDTO front_paymentDTO);
}
