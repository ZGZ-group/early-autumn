package com.earlyautumn.ruaiter.interceptor;

import com.earlyautumn.ruaiter.common.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {

    private static Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String eaToken = request.getParameter(JwtUtil.TOKEN_KEY);
        String username = JwtUtil.getUsername(eaToken);
        //TODO JWT secret选择
        boolean loginCheck = JwtUtil.verify(eaToken, username, "");
        if (!loginCheck) {
            return false;
        }

        return true;
    }
}
