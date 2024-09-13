package lk.restaurant.Service.Impl;

import lk.restaurant.DTO.Consolidate_detailDTO;
import lk.restaurant.DTO.Front_PaymentDTO;
import lk.restaurant.Model.Consolidatedetail;
import lk.restaurant.Model.Front_Payment;
import lk.restaurant.Repository.ConsoliDateDetailsRepository;
import lk.restaurant.Repository.Front_PaymentRepository;
import lk.restaurant.Service.Payment_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class Payment_ServiceImpl implements Payment_Service {

    @Autowired
    Front_PaymentRepository front_paymentRepository;

    @Autowired
    ConsoliDateDetailsRepository detailsRepository;

    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    Date date = new Date();

    @Override
    public boolean addPayment(Front_PaymentDTO paymentDTO) {
        Front_Payment front_payment=new Front_Payment();
        Consolidatedetail consolidatedetail;
        List<Consolidatedetail> consolidateModelArray = new ArrayList<Consolidatedetail>();



        front_payment.setPaymentId(0);
        front_payment.setPaymentType(paymentDTO.getPaymentType());
        front_payment.setPaymentdate(date);
        front_payment.setPaymentAmount(paymentDTO.getAmount());
        front_payment.setKot_No(paymentDTO.getKotNo());
        front_payment.setStat(0);
        front_payment.setVoid(0);
        front_payment.setUserid(paymentDTO.getUserId());
        front_payment.setAccountno(paymentDTO.getAccountNo());
        front_payment.setDiscountno(paymentDTO.getDiscountNo());
        front_payment.setResturentid(paymentDTO.getResturentId());
        front_payment.setFromPms(1);
        front_payment.setSubBillno(null);
        front_payment.setDiscountType(0);
        front_payment.setFbsId(0);

        Front_Payment savedPayment = front_paymentRepository.save(front_payment);
        if (savedPayment.getPaymentId() != null){
            System.out.println("Payment Saved+++++++++++++++++++");
            return true;

        }else{
            System.out.println("Failled to save payment");
            return false;

        }
//        for (Consolidate_detailDTO conDTO: paymentDTO.getItemList()) {
//
//            consolidateModelArray.add(new Consolidatedetail(0,
//                    paymentDTO.getKotNo(),
//                    conDTO.getRstName(),
//                    conDTO.getFName(),
//                    date,
//                    conDTO.getItemNo(),
//                    conDTO.getItemCode(),
//                    conDTO.getQty(),
//                    conDTO.getUnitPrice(),
//                    conDTO.getTotalVal(),1,
//                    0.00,
//                    0.00,
//                    0.00));
//
//
//
//
//
//
//
//        }



//        consolidatedetail.setItem_no();


        //        front_paymentRepository.save(front_payment);
//        System.err.println("Front_payment_Working................");
    }

    @Override
    public boolean addConsolidateDetails(Consolidate_detailDTO consolidate_detailDTO) {
        Consolidatedetail consolidatedetail = new Consolidatedetail();
        consolidatedetail.setId(consolidate_detailDTO.getId());
        consolidatedetail.setKot_no(consolidate_detailDTO.getKot_no());
        consolidatedetail.setRst_name(consolidate_detailDTO.getRst_name());
        consolidatedetail.setF_name(consolidate_detailDTO.getF_name());
        consolidatedetail.setPayment_date(date);
        consolidatedetail.setItem_no(consolidate_detailDTO.getItem_no());
        consolidatedetail.setItem_code(consolidate_detailDTO.getItem_code());
        consolidatedetail.setQty(consolidate_detailDTO.getQty());
        consolidatedetail.setUnit_prices(consolidate_detailDTO.getUnit_prices());
        consolidatedetail.setTtlvalue(consolidate_detailDTO.getTtlvalue());
        consolidatedetail.setFamily_gno(consolidate_detailDTO.getFamily_gno());
        consolidatedetail.setService_charge(consolidate_detailDTO.getService_charge());
        consolidatedetail.setTax(consolidate_detailDTO.getTax());
        consolidatedetail.setItem_discount(consolidate_detailDTO.getItem_discount());

        Consolidatedetail savedCondo = detailsRepository.save(consolidatedetail);

        if (savedCondo.getRst_name() != null){
            System.out.println("Condo saved Successfully");
            return true;
        }else {
            System.out.println("Condo saving failled");
            return false;
        }


    }

//    @Override
//    public boolean savePaymentDetailsWhenPrintedBill(Front_PaymentDTO front_paymentDTO) {
//        Front_Payment front_payment = new Front_Payment();
//        front_payment.setPaymentAmount(front_paymentDTO.getAmount());
//        front_payment.setKot_No(front_paymentDTO.getKotNo());
//         front_paymentRepository.savePaymentDetailsWhenPrintedBill(front_paymentDTO);
//        return true;
//    }




}
