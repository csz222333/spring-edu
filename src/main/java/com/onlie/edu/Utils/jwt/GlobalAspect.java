package com.onlie.edu.Utils.jwt;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author csz
 * @Date 2022/9/22 16:38
 */
public class GlobalAspect extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader("jwt-token");
        String s = PassWorldUtils.decrypContext(token);
        JSONObject entries = JSONUtil.parseObj(s);
        //判断密码是否存在
        String password = entries.getStr("password");
        if(StrUtil.isNotEmpty(password)){
            //存在则放行
            filterChain.doFilter(request,response);
        }
    }
}
