package com.mw.service;

/**
 * 用户服务层
 */
public interface IUserService {

    /**
     * 校验用户是否有权限传输数据
     * @param username
     * @param password
     * @return
     */
    boolean isAuth(String username,String password);
}
