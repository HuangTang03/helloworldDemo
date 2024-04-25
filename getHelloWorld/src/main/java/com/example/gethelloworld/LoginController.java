package com.example.gethelloworld;

import com.example.gethelloworld.util.SpringSecurityUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;


@RestController
@RequestMapping("/api/auth")
public class LoginController {
    @RequestMapping("login")
    public Object login(@RequestParam String username, @RequestParam String password){
        String dbusername="dGVzdA==";   //test base64加密
        String dbpassword="MTIzNDU2";   //123456 base64加密
        String encodedName = Base64.getEncoder().encodeToString(username.getBytes());
        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        List<String> authorities=new ArrayList<>();

        // 判断是否登陆
        if(SpringSecurityUtil.isLogin()){
            System.out.println("已经验证，无需重复验证");
        }else{
            if(encodedName.equals(dbusername)&&encodedPassword.equals(dbpassword)) {
                authorities.add("YourController:YourMethod");
                SpringSecurityUtil.login(username,password,authorities);
            }else {
                return "验证失败，请检查账号密码";
            }
        }
        return "验证成功";
    }
}
