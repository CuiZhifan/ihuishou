package com.qianfeng.User.Controller;

import com.qianfeng.User.DTO.LoginResult;
import com.qianfeng.User.DTO.UserLoginInfo;
import com.qianfeng.User.PO.TbUser;
import com.qianfeng.User.Service.IUserService;
import com.qianfeng.commons.DTO.Messages;
import com.qianfeng.commons.constant.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService service;

    @RequestMapping("/checkUser")
    @ResponseBody
    public List checkUser(String key, HttpSession session){
        List result = new ArrayList();
        if(key == null){
            result.add(0);
        }else {
            Messages attribute = (Messages) session.getAttribute(key);
            if(attribute == null){
                result.add(0);
            }else {
                Integer userId = attribute.getUserId();
                if (userId == null){
                    result.add(0);
                }else {
                    Integer checkUser = service.checkUser(userId);
                    if (checkUser<0){
                        result.add(0);
                    }else {
                        result.add(1);
                    }
                }
            }
        }
        return result;
    }

    @RequestMapping("/login")
    @ResponseBody
    public List userLogin(UserLoginInfo info,HttpSession session){
        LoginResult login = service.login(info.getUserName(), info.getUserPassword());
        if("null".equals(info.getSettle())&&login.getMsg()==null){
            login.setMsg("null");
        }else if(login.getMsg()==null){
            login.setMsg("settle");
        }
        Messages messages = new Messages();
        messages.setUserId(login.getUserId());
        String key =  UUID.randomUUID().toString().replace("-","").substring(0,10);
        session.setAttribute(key,messages);
        List a = new ArrayList();
        a.add(login.getMsg());
        a.add(key);
        a.add(login.getUserId());
        return a;
    }

    @RequestMapping("userInfo/{userId}")
    @ResponseBody
    public TbUser userInfo(@PathVariable("userId") int userId){
        TbUser user = service.queryUser(userId);
        return user;
    }

    @RequestMapping("/CashOut/{userId}")
    public String CashOutMoney(@PathVariable("userId") int userId){
        service.CashOut(userId);
        return "redirect:"+ URL.baseURL+"html/member.html";
    }
}
