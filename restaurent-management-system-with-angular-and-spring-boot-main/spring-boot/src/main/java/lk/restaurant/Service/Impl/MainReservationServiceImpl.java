package lk.restaurant.Service.Impl;

import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lk.restaurant.DTO.Front_kot_bot_itemDTO;
import lk.restaurant.DTO.Main_ReservationDTO;
import lk.restaurant.DTO.TempDataDTO;
import lk.restaurant.Exception.ApiRuleViolationException;
import lk.restaurant.Model.Consolidatedetail;
import lk.restaurant.Model.Front_bill_split;
import lk.restaurant.Model.Front_kot_bot_discount;
import lk.restaurant.Model.Front_kot_bot_item;
import lk.restaurant.Model.Front_kot_bot_main;
import lk.restaurant.Model.Front_kot_bot_menu;
import lk.restaurant.Model.Front_kot_bot_tax;
import lk.restaurant.Model.Front_kot_item_temp;
import lk.restaurant.Model.Front_posguest;
import lk.restaurant.Model.ItemsQueryEntity;
import lk.restaurant.Model.M_Item;
import lk.restaurant.Model.Tax;
import lk.restaurant.Model.TempData;
import lk.restaurant.Repository.ConsoliDateDetailsRepository;
import lk.restaurant.Repository.Front_Kot_Bot_Item_Repository;
import lk.restaurant.Repository.Front_Kot_Bot_Main_Repository;
import lk.restaurant.Repository.Front_Kot_Bot_Menu_Repository;
import lk.restaurant.Repository.Front_Kot_Bot_Tax_Repository;
import lk.restaurant.Repository.Front_PosGuest_Repository;
import lk.restaurant.Repository.Front_bill_split_Repository;
import lk.restaurant.Repository.Front_kot_bot_discount_Repository;
import lk.restaurant.Repository.QueryRepository;
import lk.restaurant.Repository.TableCloseRepository;
import lk.restaurant.Repository.TaxClass_Repository;
import lk.restaurant.Repository.TempDataRepository;
import lk.restaurant.Repository.Custom.Front_kot_item_temp_Custom;
import lk.restaurant.Repository.Custom.Impl.Front_kot_item_temp_CustomImpl;
import lk.restaurant.Service.MainReservationService;

@Service
public class MainReservationServiceImpl implements MainReservationService {

    @Autowired
    Front_PosGuest_Repository front_posGuest_repository;

    @Autowired
    Front_Kot_Bot_Main_Repository front_kot_bot_main_repository;

    @Autowired
    Front_Kot_Bot_Menu_Repository front_kot_bot_menu_repository;

    @Autowired
    Front_Kot_Bot_Item_Repository front_kot_bot_item_repository;

    @Autowired
    ConsoliDateDetailsRepository consoliDateDetailsRepository;

    @Autowired
    TempDataRepository tempDataRepository;

    @Autowired
    Front_Kot_Bot_Tax_Repository front_kot_bot_tax_repository;

    @Autowired
    Front_bill_split_Repository front_bill_split_repository;

    @Autowired
    TaxClass_Repository taxClass_repository;

    @Autowired
    Front_kot_bot_discount_Repository front_kot_bot_discount_repository;

    @Autowired
    QueryRepository queryRepository;

    @Autowired
    TableCloseRepository tableCloseRepository;

    Front_kot_item_temp_Custom front_kot_item_temp_custom = new Front_kot_item_temp_CustomImpl();

    @Transactional
    @Override
    public Integer add(Main_ReservationDTO main_reservationDTO) {
        Front_kot_bot_main botMain = new Front_kot_bot_main();
        Front_kot_bot_menu botMenu = new Front_kot_bot_menu();
        Front_posguest posGuest = new Front_posguest();
        Front_kot_bot_item front_kot_bot_item = new Front_kot_bot_item();
        Front_kot_bot_tax front_kot_bot_tax = new Front_kot_bot_tax();
        Front_bill_split front_bill_split = new Front_bill_split();
        Consolidatedetail details = new Consolidatedetail();
        ItemsQueryEntity itemsQueryEntity = new ItemsQueryEntity();


        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();


        posGuest.setTable_no(main_reservationDTO.getFrontPosGuestDTO().getTableNo());
        posGuest.setWaiter_no(0);
        posGuest.setFirst_name(main_reservationDTO.getFrontPosGuestDTO().getfName());
        posGuest.setLast_name(main_reservationDTO.getFrontPosGuestDTO().getfName());
        posGuest.setAdult(main_reservationDTO.getFrontPosGuestDTO().getAdult());
        posGuest.setChildren(main_reservationDTO.getFrontPosGuestDTO().getChildren());
        posGuest.setTabledate(date);
        posGuest.setRemrk("");
        posGuest.setStates(1);
        posGuest.setSystemdate(date);
        posGuest.setStrart_time(null);
        posGuest.setEnd_time(null);
        posGuest.setTransactionno("");
        posGuest.setIstax(1);
        posGuest.setRoomno("");
        posGuest.setConfno(0);
        posGuest.setMealcheck(0);
        posGuest.setMealno(0);
        posGuest.setWalkingguest(1);
        posGuest.setMinibar(0);
        posGuest.setGuest_states(1);
        posGuest.setHouse_no(0);
        posGuest.setPackage("0");
        posGuest = front_posGuest_repository.save(posGuest);

        if (posGuest.getPosguestNo() != null) {
            try {
                botMain.setPos_Guest_no(posGuest.getPosguestNo());
                botMain.setResturent_id(main_reservationDTO.getFrontKotBotMainDTO().getRestaurantId());
                botMain.setTableno(main_reservationDTO.getFrontPosGuestDTO().getTableNo());
                botMain.setRemark(null);
                botMain.setMeal_period(main_reservationDTO.getFrontKotBotMainDTO().getMealPeriod());
                botMain.setCurrentdate(date);
                botMain.setUserid(main_reservationDTO.getFrontKotBotMainDTO().getUserId());
                botMain.setState(1);
                botMain.setViewuser(0);
                botMain.setLoguserID(0);
                botMain.setBillno("");
                botMain.setIntbillno(0);
                botMain.setIsenter(0);
                botMain.setResroom(main_reservationDTO.getFrontKotBotMainDTO().getRoomId());
                botMain.setPrint_time(null);
                botMain.setPrint_user(0);
                botMain.setHassplit(0);
                botMain.setHasmergeId(0);
                botMain.setMerge_bill_no("0");
                botMain.setInt_merge_bill_no(0);
                botMain.setOpen_in_table(1);
                botMain.setNightdate(null);
                botMain.setTableStatus(1);
                botMain = front_kot_bot_main_repository.save(botMain);
            } catch (ApiRuleViolationException e) {
                throw new ApiRuleViolationException("Problem in Front_kot_bot_main ");
            }
        }

        if (botMain.getKotNo() != null) {
            try {
                List<Front_kot_bot_itemDTO> front_kot_bot_itemDTOS = main_reservationDTO.getFrontKotBotItemDTO();
                for (Front_kot_bot_itemDTO botItem : front_kot_bot_itemDTOS) {

                    Front_kot_bot_item bot_item = new Front_kot_bot_item();

                    List<M_Item> m_items = taxClass_repository.getAll(botItem.getItemCode());
                    Front_kot_bot_tax front_tax = new Front_kot_bot_tax();

                    bot_item.setItem_Code(botItem.getItemCode());
                    bot_item.setKot_bot_no(botMain.getKotNo());
                    bot_item.setMenu_id(0);
                    bot_item.setTax_class(m_items.get(0).getTaxCalssid());
                    bot_item.setOrder_time(date);
                    bot_item.setDelivery_time(null);
                    bot_item.setUnit_prices(botItem.getUnitPrices());
                    bot_item.setDiscount(botItem.getDiscount());
                    bot_item.setQTY(botItem.getQty());
                    bot_item.setIssetmenu(0);
                    bot_item.setUnit_cost(0.0);
                    bot_item.setItemcomment(null);
                    bot_item.setUnit_prices_withtax(botItem.getUnitPricesWithtax());
                    front_kot_bot_item = front_kot_bot_item_repository.save(bot_item);

                    Front_kot_bot_menu bot_menu = new Front_kot_bot_menu();
                    bot_menu.setKot_bot_no(botMain.getKotNo());
                    bot_menu.setIs_setmenu(0);
                    bot_menu.setSet_menu_no(0);
                    front_kot_bot_menu_repository.save(bot_menu);


                    List<Tax> taxes = taxClass_repository.getAllTax(bot_item.getTax_class());

                    if (botItem.getTaxAmount() != 0) {
                        for (int x = 0; x < taxes.size(); x++) {
                            front_tax.setKb_taxno(0);
                            front_tax.setKb_itemno(bot_item.getItem_no());
                            front_tax.setTaxno(taxes.get(x).getTaxno());
                            front_tax.setTaxamount(taxes.get(x).getTaxcalculatevalue() * bot_item.getUnit_prices() * bot_item.getQTY());
                            front_kot_bot_tax = front_kot_bot_tax_repository.save(front_tax);
                        }
                    }

                    if (botItem.getValue() != null) {
                        Front_kot_bot_discount front_kot_bot_discount = new Front_kot_bot_discount();
                        front_kot_bot_discount.setDiscountNo(0);
                        front_kot_bot_discount.setKotBotNo(botMain.getKotNo());
                        front_kot_bot_discount.setDisvountType(botItem.getDiscountType());
                        front_kot_bot_discount.setValue(botItem.getValue());
                        front_kot_bot_discount.setCdate(date);
                        front_kot_bot_discount.setUserId(botMain.getUserid());
                        front_kot_bot_discount.setRemark("");
                        front_kot_bot_discount.setValuetype(1);
                        front_kot_bot_discount.setIsfamily(botItem.getIsFamily());
                        front_kot_bot_discount.setItemNo(bot_item.getItem_no());
                        front_kot_bot_discount.setFrompms(1);
                        front_kot_bot_discount.setHavetotalbilldis(0);
                        front_kot_bot_discount_repository.save(front_kot_bot_discount);
                    }

                    ItemsQueryEntity queryEntity = new ItemsQueryEntity();
                    queryEntity.setItemNo(bot_item.getItem_no());
                    queryEntity.setItemCode(bot_item.getItem_Code());
                    queryEntity.setKot(botMain.getKotNo());
                    queryEntity.setQty(bot_item.getQTY());
                    queryEntity.setPrice(bot_item.getUnit_prices());
                    queryEntity.setPriceWithTax(bot_item.getUnit_prices_withtax());
                    queryEntity.setItemName(botItem.getItemName());
                    queryEntity.setUserName(main_reservationDTO.getFrontKotBotMainDTO().getUserName());
                    queryEntity.setRate(main_reservationDTO.getFrontKotBotMainDTO().getRate());
                    queryEntity.setFamilyId(botItem.getFamilyId());

                    if (botItem.getValue() != null) {

                        queryEntity.setDisPercentage(botItem.getValue());
                        queryEntity.setDisType(botItem.getDiscountType());


                    } else {
                        queryEntity.setDisPercentage(0.0);
                        queryEntity.setDisType(0);
                    }
                    queryRepository.save(queryEntity);

                    Front_kot_item_temp front_kot_item_temp1 = new Front_kot_item_temp();
                    front_kot_item_temp1.setKotno(botMain.getKotNo());
                    front_kot_item_temp1.setItemcode(bot_item.getItem_Code());
                    front_kot_item_temp1.setQty(bot_item.getQTY());
                    front_kot_item_temp1.setType(0);
                    front_kot_item_temp1.setPrinter(0);

                    System.err.println("1." + botMain.getKotNo());
                    System.err.println("2." + bot_item.getItem_Code());
                    System.err.println("3." + bot_item.getQTY());
                    try {
                        boolean b = front_kot_item_temp_custom.saveTemp(front_kot_item_temp1);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }


                }
            } catch (ApiRuleViolationException e) {
                throw new ApiRuleViolationException("Problem in Front_kot_bot_item");
            }
        }

        if (front_kot_bot_item.getItem_no() != null) {
            try {
                {
                    front_bill_split.setKotNo(botMain.getKotNo());
                    front_bill_split.setBill_no("0");
                    front_bill_split.setBill_time(null);
                    front_bill_split.setInt_bill_no(0);
                    front_bill_split.setIspaid(0);
                    front_bill_split.setPayment_id(0);
                    front_bill_split.setRoom_no("");
                    front_bill_split = front_bill_split_repository.save(front_bill_split);

                }
            } catch (ApiRuleViolationException e) {
                throw new ApiRuleViolationException("Problem in Bill Split");
            }
        }

        if (main_reservationDTO.getFrontKotBotMainDTO().getRate() == 5) {
            Front_kot_bot_main main = tableCloseRepository.getOne(botMain.getKotNo());
            main.setOpen_in_table(0);
            main.setTableStatus(0);
            tableCloseRepository.save(main);
        }
        return botMain.getKotNo();
    }

    @Transactional
    @Override
    public Integer update(Main_ReservationDTO main_reservationDTO) {

        Front_kot_bot_main botMain = new Front_kot_bot_main();
        Front_kot_bot_item front_kot_bot_item = new Front_kot_bot_item();
        Front_kot_item_temp front_kot_item_temp = new Front_kot_item_temp();
        Front_kot_bot_menu botMenu = new Front_kot_bot_menu();
        Consolidatedetail consolidatedetail = new Consolidatedetail();
        Front_kot_bot_discount front_kot_bot_discount = new Front_kot_bot_discount();
        ItemsQueryEntity queryEntity = new ItemsQueryEntity();

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();

        List<Front_kot_bot_itemDTO> front_kot_bot_itemDTOS = main_reservationDTO.getFrontKotBotItemDTO();

        for (Front_kot_bot_itemDTO botItem : front_kot_bot_itemDTOS) {
            Front_kot_bot_item bot_item = new Front_kot_bot_item();

            List<M_Item> m_items = taxClass_repository.getAll(botItem.getItemCode());
            Front_kot_bot_tax front_tax = new Front_kot_bot_tax();


            if (botItem.getItemNo() == 0) {
                bot_item.setItem_Code(botItem.getItemCode());
                bot_item.setKot_bot_no(main_reservationDTO.getFrontKotBotMainDTO().getKotNo());
                bot_item.setMenu_id(0);
                bot_item.setTax_class(m_items.get(0).getTaxCalssid());
                bot_item.setOrder_time(date);
                bot_item.setDelivery_time(null);
                bot_item.setUnit_prices(botItem.getUnitPrices());
                bot_item.setDiscount(botItem.getDiscount());
                bot_item.setQTY(botItem.getQty());
                bot_item.setIssetmenu(0);
                bot_item.setUnit_cost(0.0);
                bot_item.setItemcomment(null);
                bot_item.setUnit_prices_withtax(botItem.getUnitPricesWithtax());
                front_kot_bot_item = front_kot_bot_item_repository.save(bot_item);

                queryEntity.setId(0);
                queryEntity.setItemNo(front_kot_bot_item.getItem_no());
                queryEntity.setItemCode(bot_item.getItem_Code());
                queryEntity.setKot(main_reservationDTO.getFrontKotBotMainDTO().getKotNo());
                queryEntity.setQty(bot_item.getQTY());
                queryEntity.setPrice(bot_item.getUnit_prices());
                queryEntity.setPriceWithTax(bot_item.getUnit_prices_withtax());
                queryEntity.setItemName(botItem.getItemName());
                queryEntity.setUserName(main_reservationDTO.getFrontKotBotMainDTO().getUserName());
                queryEntity.setRate(main_reservationDTO.getFrontKotBotMainDTO().getRate());
                queryEntity.setFamilyId(botItem.getFamilyId());

                if (botItem.getValue() != null) {
                    queryEntity.setDisPercentage(botItem.getValue());
                    queryEntity.setDisType(botItem.getDiscountType());

                } else {
                    queryEntity.setDisPercentage(0.0);
                    queryEntity.setDisType(0);
                }

                queryRepository.save(queryEntity);

                if (botItem.getValue() != null) {
                    front_kot_bot_discount.setDiscountNo(0);
                    front_kot_bot_discount.setKotBotNo(main_reservationDTO.getFrontKotBotMainDTO().getKotNo());
                    front_kot_bot_discount.setDisvountType(botItem.getDiscountType());
                    front_kot_bot_discount.setValue(botItem.getValue());
                    front_kot_bot_discount.setCdate(date);
                    front_kot_bot_discount.setUserId(main_reservationDTO.getFrontKotBotMainDTO().getUserId());
                    front_kot_bot_discount.setRemark("");
                    front_kot_bot_discount.setValuetype(1);
                    front_kot_bot_discount.setIsfamily(botItem.getIsFamily());
                    front_kot_bot_discount.setItemNo(bot_item.getItem_no());
                    front_kot_bot_discount.setFrompms(1);
                    front_kot_bot_discount.setHavetotalbilldis(0);
                    front_kot_bot_discount_repository.save(front_kot_bot_discount);
                }

                List<Tax> taxes = taxClass_repository.getAllTax(bot_item.getTax_class());

                if (botItem.getTaxAmount() != 0) {
                    for (int x = 0; x < taxes.size(); x++) {
                        front_tax.setKb_taxno(0);
                        front_tax.setKb_itemno(bot_item.getItem_no());
                        front_tax.setTaxno(taxes.get(x).getTaxno());
                        front_tax.setTaxamount(taxes.get(x).getTaxcalculatevalue() * bot_item.getUnit_prices());
                        front_kot_bot_tax_repository.save(front_tax);
                    }
                }

                botMenu.setKot_bot_no(botMain.getKotNo());
                botMenu.setIs_setmenu(0);
                botMenu.setSet_menu_no(0);
                botMenu = front_kot_bot_menu_repository.save(botMenu);

                Front_kot_item_temp front_kot_item_temp1 = new Front_kot_item_temp();
                front_kot_item_temp1.setKotno(main_reservationDTO.getFrontKotBotMainDTO().getKotNo());
                front_kot_item_temp1.setItemcode(bot_item.getItem_Code());
                front_kot_item_temp1.setQty(bot_item.getQTY());
                front_kot_item_temp1.setType(0);
                front_kot_item_temp1.setPrinter(0);
                try {
                    front_kot_item_temp_custom.saveTemp(front_kot_item_temp1);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else {
                bot_item.setItem_no(botItem.getItemNo());
                bot_item.setItem_Code(botItem.getItemCode());
                bot_item.setKot_bot_no(main_reservationDTO.getFrontKotBotMainDTO().getKotNo());
                bot_item.setMenu_id(0);
                bot_item.setTax_class(m_items.get(0).getTaxCalssid());
                bot_item.setOrder_time(date);
                bot_item.setDelivery_time(null);
                bot_item.setUnit_prices(botItem.getUnitPrices());
                bot_item.setDiscount(botItem.getDiscount());
                bot_item.setQTY(botItem.getQty());
                bot_item.setIssetmenu(0);
                bot_item.setUnit_cost(0.0);
                bot_item.setItemcomment(null);
                bot_item.setUnit_prices_withtax(botItem.getUnitPricesWithtax());
                front_kot_bot_item_repository.save(bot_item);


                List<Front_kot_bot_discount> disList = null;
                Integer disNo = null;
                try {
                    disList = front_kot_bot_discount_repository.getDisNo(botItem.getItemNo());
                    if (botItem.getDiscountType() != null) {
                        if (disList.size() == 0 && botItem.getValue() != 0) {
                            front_kot_bot_discount.setDiscountNo(0);
                            front_kot_bot_discount.setKotBotNo(main_reservationDTO.getFrontKotBotMainDTO().getKotNo());
                            front_kot_bot_discount.setDisvountType(botItem.getDiscountType());
                            front_kot_bot_discount.setValue(botItem.getValue());
                            front_kot_bot_discount.setCdate(date);
                            front_kot_bot_discount.setUserId(main_reservationDTO.getFrontKotBotMainDTO().getUserId());
                            front_kot_bot_discount.setRemark(null);
                            front_kot_bot_discount.setValuetype(1);
                            front_kot_bot_discount.setIsfamily(botItem.getIsFamily());
                            front_kot_bot_discount.setItemNo(bot_item.getItem_no());
                            front_kot_bot_discount.setFrompms(1);
                            front_kot_bot_discount.setHavetotalbilldis(0);
                            front_kot_bot_discount_repository.save(front_kot_bot_discount);
                        } else {

                            front_kot_bot_discount_repository.updateDiscountFDetails(botItem.getItemNo(),
                                    botItem.getValue(), botItem.getDiscountType());

                        }
                    } else {
                        front_kot_bot_discount_repository.deleteDiscount(botItem.getItemNo());
                        queryRepository.updateItemDiscount(botItem.getItemNo(), botItem.getFamilyId(), 0.0, 0);

                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

                queryRepository.updateItemDetails(bot_item.getItem_no(), bot_item.getQTY(), bot_item.getUnit_prices(),
                        bot_item.getUnit_prices_withtax());

                Front_kot_item_temp front_kot_item_temp1 = new Front_kot_item_temp();
                front_kot_item_temp1.setKotno(main_reservationDTO.getFrontKotBotMainDTO().getKotNo());
                front_kot_item_temp1.setItemcode(bot_item.getItem_Code());
                front_kot_item_temp1.setQty(bot_item.getQTY());
                front_kot_item_temp1.setType(0);
                front_kot_item_temp1.setPrinter(0);
                try {
                    front_kot_item_temp_custom.updateItemTemp(front_kot_item_temp1);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                if (botItem.getValue() != 0) {
                    queryRepository.updateItemDiscount(botItem.getItemNo(), botItem.getFamilyId(), botItem.getValue(), botItem.getDiscountType());

                }
            }
        }


        return 1;
    }

    @Override
    public List<Main_ReservationDTO> searchLike(Integer userId, String username, String pwd) {
        return null;
    }

    @Override
    public List<Main_ReservationDTO> get(Integer id) {
        return null;
    }


    @Override
    public Integer delete(Integer id) {
        return null;
    }

    @Transactional
    @Override
    public Integer deleteItems(Integer kot, Integer itemNo, Integer itemCode) {
        front_kot_bot_item_repository.deleteById(itemNo);
        front_kot_bot_tax_repository.deleteTax(itemNo);
        queryRepository.deleteDetails(itemNo);
        front_kot_bot_discount_repository.deleteDiscount(itemNo);

        try {
            front_kot_item_temp_custom.deleteItemTemp(kot, itemCode);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Integer posGuessNo = null;
            List<Front_kot_bot_item> items = front_kot_bot_item_repository.getAllItemNo(kot);
            List<Front_kot_bot_main> main = front_kot_bot_main_repository.getPosGuessNo(kot);
            for (Front_kot_bot_main no : main) {
                posGuessNo = no.getPos_Guest_no();
            }
            if (items.size() == 0) {
                front_kot_bot_main_repository.deleteById(kot);
                front_posGuest_repository.deleteById(posGuessNo);
                front_bill_split_repository.deleteSplit(kot);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 1;
    }

    @Override
    public void addTempData(TempDataDTO tempDataDTO) {
        TempData tempData = new TempData();
        TempData save = tempDataRepository.save(tempData);
    }

    @Override
    public Double getRateForPickMeAndUber() {
        double price = 0;
        try {
            ResultSet rateForPickMeAndUber = front_kot_item_temp_custom.getRateForPickMeAndUber();
            if (rateForPickMeAndUber.next()) {
                price = rateForPickMeAndUber.getDouble("fixedprice");
            }
            return price;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return price;
    }



}
