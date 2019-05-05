package com.qianfeng.User.Mapper;

import com.qianfeng.User.DTO.CheckUser;
import com.qianfeng.User.DTO.LoginResult;
import com.qianfeng.User.PO.TbUser;
import org.apache.ibatis.annotations.Param;

public interface IUserMapper {
    CheckUser checkLogin(@Param("userId") int userId);

    LoginResult login(@Param("username") String username,@Param("password") String password);

    TbUser queryUser(@Param("userId") int userId);

    void CashOut(@Param("userId") int userId);
}
