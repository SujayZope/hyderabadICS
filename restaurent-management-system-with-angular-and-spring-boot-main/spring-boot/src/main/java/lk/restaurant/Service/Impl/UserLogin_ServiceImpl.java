package lk.restaurant.Service.Impl;

import lk.restaurant.Builder.DtoBulder;
import lk.restaurant.DTO.UserLoginDTO;
import lk.restaurant.Model.UserLogin;
import lk.restaurant.Repository.UserLogin_Repository;
import lk.restaurant.Service.UserLogin_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@Transactional
public class UserLogin_ServiceImpl implements UserLogin_Service {

    @Autowired
    DtoBulder dtoBulder;

    @Autowired
    UserLogin_Repository userLogin_repository;


    @Override
    public Integer add(UserLoginDTO userLoginDTO) {
        return null;
    }

    @Override
    public Integer update(UserLoginDTO userLoginDTO) {
        return null;
    }

    @Override
    public List<UserLoginDTO> searchLike(Integer userId, String username, String pwd) {
        return null;
    }

    @Override
    public List<UserLoginDTO> get(Integer id) {
        return null;
    }

    @Override
    public Integer delete(Integer id) {
        return null;
    }


    @Override
    public UserLogin findByUsernameAndPw_code(String username, String pwcode){
        UserLogin userLogin=userLogin_repository.findByUserNameAndPwCordAndIsshow(username,pwcode,1);
        return userLogin;
    }

}
