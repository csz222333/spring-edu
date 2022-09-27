package com.onlie.edu.Service.Interfaces;


import com.baomidou.mybatisplus.extension.service.IService;
import com.onlie.edu.Dao.User;
import com.onlie.edu.Utils.BaseResponseData.ResponseData;


/**
 * <p>
 * 后台用户表 服务类
 * </p>
 *
 * @author csz
 * @since 2021-11-23
 */
public interface UmsAdminService extends IService<User> {

    /**
     * 查询用户
     *
     * @return
     */
    ResponseData findUserByUsername(User user);

    /**
     *  用户注册
     * @param user
     * @return
     */
    ResponseData registerUser(User user);

    ResponseData loginUser(User user);

    ResponseData updataUser(User user);

}
