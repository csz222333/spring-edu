package com.onlie.edu.Service.Impl;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.onlie.edu.Dao.User;
import com.onlie.edu.Mapper.UmsAdminMapper;
import com.onlie.edu.Service.Interfaces.UmsAdminService;
import com.onlie.edu.Utils.BaseResponseData.ResponseData;
import com.onlie.edu.Utils.jwt.PassWorldUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * <p>
 * 后台用户表 服务实现类
 * </p>
 *
 * @author csz
 * @since 2021-11-23
 */
@Slf4j
@Service
public class UmsAdminServiceImpl extends ServiceImpl<UmsAdminMapper, User> implements UmsAdminService {


    @Override
    public ResponseData findUserByUsername(User user) {
        User user1 = baseMapper.selectById(user.getId());
        return ResponseData.success(200,"请求成功",user1);
    }

    @Override
    public ResponseData registerUser(User user) {

        save(user);

        return ResponseData.success();
    }

    @Override
    public ResponseData loginUser(User user) {

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        //对比手机号码，从Mysql数据库得到用户对象
        queryWrapper.lambda().
                eq(User::getPhone,user.getPhone());

        User user1 = baseMapper.selectOne(queryWrapper);

        //判断密码是否相等
        if(user1.getPassword().equals(PassWorldUtils.cryContext(user.getPassword()))){
            //返回token
            JSONObject json = JSONUtil.parseObj(user1, false);
            String s = json.toStringPretty();
            String token = PassWorldUtils.cryContext(s);
            HashMap map = new HashMap<>();
            map.put("token",token);
            map.put("data",user1);
            return ResponseData.success(200,"请求成功",map);
        }


        return ResponseData.error("请求失败");
    }

    @Override
    public ResponseData updataUser(User user) {

        baseMapper.updateById(user);

        return ResponseData.success();
    }


}
