package com.qianfeng.User.Service;

import com.qianfeng.User.PO.TbUser;
import com.qianfeng.User.DTO.LoginResult;

import javax.servlet.http.HttpSession;

public interface IUserService {
    Integer checkUser(int userId);
    LoginResult login(String username,String password,String key,HttpSession session);
    TbUser queryUser(int userId);
    void CashOut(int userId);
    String Register(String username, String password, String key, HttpSession session);
}
