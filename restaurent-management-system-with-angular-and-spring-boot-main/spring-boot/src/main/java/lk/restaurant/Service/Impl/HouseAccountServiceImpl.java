package lk.restaurant.Service.Impl;

import lk.restaurant.DTO.ManagersDTO;
import lk.restaurant.Model.House_Account;
import lk.restaurant.Repository.Custom.Impl.HouseAccountRepositoryImpl;
import lk.restaurant.Repository.HouseAccountRepository;
import lk.restaurant.Service.HouseAccountService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HouseAccountServiceImpl implements HouseAccountService {

    HouseAccountRepository houseAccountRepository=new HouseAccountRepositoryImpl();

    @Override
    public ArrayList<ManagersDTO> getAll() throws Exception {
        ArrayList<ManagersDTO> getResult=new ArrayList<>();
        List<House_Account> result=houseAccountRepository.getAll();
        for(House_Account account:result){
            getResult.add(new ManagersDTO(account.getH_account_id(),account.getAccount_number(),account.getEmployee_name()));
        }
        return getResult;
    }
}
