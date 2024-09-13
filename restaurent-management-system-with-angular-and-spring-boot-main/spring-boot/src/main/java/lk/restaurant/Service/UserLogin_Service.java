package lk.restaurant.Service;

import lk.restaurant.DTO.UserLoginDTO;
import lk.restaurant.Model.UserLogin;
import lk.restaurant.Service.Commen.CRUDServise;

public interface UserLogin_Service extends CRUDServise<UserLoginDTO> {

    UserLogin findByUsernameAndPw_code(String username, String pwcode);

}
