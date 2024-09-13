package lk.restaurant.Repository.Custom.Impl;

import lk.restaurant.DBConnection.InventoryStatement;
import lk.restaurant.DBConnection.PosStatement;
import lk.restaurant.Repository.Custom.InventoryCustom;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;

@Repository
public class InventoryRepositoryImpl implements InventoryCustom {

    // This Method Select And All Update In One Method Update Inventory Database SubStore
    @Override
    public Integer selectCurrentId(Integer itemNo,Integer qty) {

    try{
        System.out.println("================================================================================");
        System.out.println("Item No  : "+itemNo + "  QTY :   "+qty);
        ResultSet result1 = PosStatement.executeQuery("SELECT SubItemCode,SUM(ItemQuantity) AS qnt,Department FROM m_group_family,m_item,m_item_cost WHERE m_item.family_gno=m_group_family.F_no AND m_item_cost.mainItemCode=m_item.item_code AND item_code='"+itemNo+"' and SubItemCode!='0' GROUP BY SubItemCode");
        if (result1.next()) {
                String sub=result1.getString("SubItemCode");
                Double q=Double.parseDouble(result1.getString("qnt"));

            System.out.println("Sub Item Code  : "+sub);
            System.out.println("QTYSIZE : " +q);

            ResultSet resultSet = InventoryStatement.executeQuery("SELECT SubIn_No,bal_qty FROM substore_in_d WHERE ite_No='"+sub+"' ORDER BY SubIn_No DESC LIMIT 1");
//            ResultSet resultSet = InventoryStatement.executeQuery("Select bal_QTY from substore_in_d where ite_No='" + sub + "' limit 1");
            double val=0;
            int subIn_no=0;
            if (resultSet.next()) {
                subIn_no=resultSet.getInt(1);
                val=resultSet.getDouble(2);
            }
            System.out.println("Total Value : " +val);

            System.out.println("QTY * q = "+ qty*q);

            double last= val - (qty*q);
            System.out.println("Final Value : "+last);

            int i = InventoryStatement.executeUpdate("UPDATE substore_in_d SET bal_qty ='" + last + "' WHERE ite_No = '" + sub + "' and SubIn_No='"+subIn_no+"' ");
            System.out.println("Update Final : "+i);
            }

    }catch (Exception e){
        System.out.println(e);
    }
        return null;
    }
}