package com.qianfeng.User.Service;

import com.qianfeng.User.PO.TbUser;
import com.qianfeng.User.DTO.LoginResult;

public interface IUserService {
    Integer checkUser(int userId);
    LoginResult login(String username,String password);
    TbUser queryUser(int userId);
    void CashOut(int userId);
}
