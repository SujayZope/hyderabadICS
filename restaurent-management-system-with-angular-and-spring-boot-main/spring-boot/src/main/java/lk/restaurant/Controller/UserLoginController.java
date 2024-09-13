package lk.restaurant.Controller;

import lk.restaurant.DTO.Commen.MainDTO;
import lk.restaurant.DTO.UserLoginDTO;
import lk.restaurant.Model.UserLogin;
import lk.restaurant.Service.UserLogin_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api")
public class UserLoginController {

    @Autowired
    private UserLogin_Service userLogin_service;

    @GetMapping(value = "/test")
    public boolean test(){
        return true;
    }

    @PostMapping(value = "/login")
    public MainDTO userLog(@RequestBody UserLoginDTO userLoginDTO) {

        int status = 200;
        String message = "Success";
        UserLogin userLogin = null;
        System.out.println("Login Running..........");

        try{
            userLogin = userLogin_service.findByUsernameAndPw_code(userLoginDTO.getUserName(), userLoginDTO.getPwCord());
            return new MainDTO(userLogin.getUser_Id(),userLogin.getUser_type(), message, status);
        }catch (Exception e){
            message="User Name or password invalid";
            status=400;

            return new MainDTO(0,0,message,status);
        }

    }
}
