package com.qianfeng.User.Service.Impl;

import com.qianfeng.User.DTO.CheckUser;
import com.qianfeng.User.DTO.LoginResult;
import com.qianfeng.User.Mapper.IUserMapper;
import com.qianfeng.User.PO.TbUser;
import com.qianfeng.User.Service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public LoginResult login(String username, String password) {
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
}
