package com.qianfeng.User.Service.Impl;

import com.qianfeng.Price.PO.GetId;
import com.qianfeng.User.DTO.CheckUser;
import com.qianfeng.User.DTO.LoginResult;
import com.qianfeng.User.Mapper.IUserMapper;
import com.qianfeng.User.PO.TbUser;
import com.qianfeng.User.Service.IUserService;
import com.qianfeng.commons.DTO.Messages;
import com.qianfeng.order.PO.TbOrder;
import com.qianfeng.order.mapper.IOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserMapper mapper;

    @Override
    public Integer checkUser(int userId) {
        CheckUser user = mapper.checkLogin(userId);
        if (user == null){
            return -1;
        }else {
            return user.getUserId();
        }
    }

    @Override
    public LoginResult login(String username, String password,String key,HttpSession session) {

        LoginResult result = mapper.login(username, null);
        if (result == null){
            result = new LoginResult();
            result.setMsg("unknown");
        }else {
            result = mapper.login(username,password);
            if (result == null){
                result = new LoginResult();
                result.setMsg("failed");
            }
        }
        if (key!=null){
            Messages attribute = (Messages) session.getAttribute(key);
            if (attribute!=null){
                Integer ouserId = attribute.getUserId();
                if (ouserId!=null){
                    mapper.updateCart(result.getUserId(),ouserId);
                }
            }
        }
        return result;
    }

    @Override
    public TbUser queryUser(int userId) {
        return mapper.queryUser(userId);
    }

    @Override
    public void CashOut(int userId) {
        mapper.CashOut(userId);
    }

    @Override
    public String Register(String username, String password, String key, HttpSession session) {
        List<Integer> list = mapper.checkUserName(username);
        if (!list.isEmpty()){
            return "failed";
        }
        GetId getId = new GetId();
        if (username.contains("@")){
            getId.setUserEmail(username);
            getId.setUserPhone("");
        }else {
            getId.setUserPhone(username);
            getId.setUserEmail("");
        }
        getId.setPassword(password);
        getId.setJoinTime(new Timestamp(new Date().getTime()));
        mapper.addUser(getId);
        Messages attribute = (Messages) session.getAttribute(key);
        //得到新用户Id
        Integer NUserId = getId.getUserId();
        if (attribute == null){
            attribute = new Messages();
            attribute.setUserId(NUserId);
            key = UUID.randomUUID().toString().replace("-","").substring(0,10);
            session.setAttribute(key,attribute);
            return "ok-"+NUserId+"-"+key;
        }
        Integer OUserId = attribute.getUserId();
        if (OUserId == null){
            OUserId = NUserId;
        }
        mapper.updateCart(NUserId,OUserId);
        attribute.setUserId(NUserId);
        session.setAttribute(key,attribute);
        return "ok-"+NUserId+"-"+key;
    }
}
