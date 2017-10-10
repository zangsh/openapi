package com.mw.service.impl;

import com.mw.service.IUserService;
import com.mw.util.MD5Util;
import com.mw.util.PropertiesUtil;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService{

    public boolean isAuth(String username, String password) {
        PropertiesUtil propertiesUtil = new PropertiesUtil();
        String uname = propertiesUtil.get("username");
        String passwd = propertiesUtil.get("password");
        //对用户账号进行 MD5 + SALT 加密
       /* String md5Username = MD5Util.generate(username);
        String md5Password = MD5Util.generate(password);

        if (uname.equals(md5Username) && passwd.equals(md5Password)){
            return Boolean.TRUE;
        }else{
            return Boolean.FALSE;
        }*/
        if (MD5Util.verify(username,uname) && MD5Util.verify(password,passwd)){
            return Boolean.TRUE;
        }else {
            return Boolean.FALSE;
        }

    }
}
