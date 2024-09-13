package lk.restaurant.Repository;

import lk.restaurant.Model.UserLogin;
import lk.restaurant.Repository.Custom.UserLogin_Custom;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface UserLogin_Repository extends JpaRepository<UserLogin,Long>, UserLogin_Custom {

    UserLogin findByUserNameAndPwCordAndIsshow(String username, String password,int isshow);


}
