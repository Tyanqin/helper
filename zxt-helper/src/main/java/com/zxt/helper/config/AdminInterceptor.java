package com.zxt.helper.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.zxt.helper.Annotation.PassToken;
import com.zxt.helper.Annotation.UserLoginToken;
import com.zxt.helper.common.exception.login.UserNotExistException;
import com.zxt.helper.common.exception.token.TokenInvalidException;
import com.zxt.helper.common.exception.token.TokenNotExistException;
import com.zxt.helper.common.utils.BaseAssert;
import com.zxt.helper.entity.User;
import com.zxt.helper.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author:TanXiao
 * @date:2023/3/20
 */
@Slf4j
@Configuration
public class AdminInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
        String token = request.getHeader("x-access-token");
        // 如果不是映射到方法直接通过
        if(!(object instanceof HandlerMethod)){
            return true;
        }
        HandlerMethod handlerMethod=(HandlerMethod)object;
        Method method=handlerMethod.getMethod();
        //检查是否有passtoken注释，有则跳过认证
        if (method.isAnnotationPresent(PassToken.class)) {
            PassToken passToken = method.getAnnotation(PassToken.class);
            if (passToken.required()) {
                return true;
            }
        }
        //检查有没有需要用户权限的注解
        if (method.isAnnotationPresent(UserLoginToken.class)) {
            UserLoginToken userLoginToken = method.getAnnotation(UserLoginToken.class);
            if (userLoginToken.required()) {
                // 执行认证
                BaseAssert.isNull(token, TokenNotExistException::new);
                // 获取 token 中的 user id
                String userId = null;
                try {
                    userId = JWT.decode(token).getAudience().get(0);
                    BaseAssert.isNull(userId, TokenInvalidException::new);
                } catch (JWTDecodeException j) {
                    BaseAssert.isNull("", TokenInvalidException::new);
                }
                User user = userService.selectOne(new User().setId(Integer.parseInt(userId)));
                BaseAssert.isNull(user.getId(), UserNotExistException::new);
                // 验证 token
                JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(user.getPassword())).build();
                try {
                    jwtVerifier.verify(token);
                } catch (JWTVerificationException e) {
                    BaseAssert.isNull("", TokenInvalidException::new);
                }
                return true;
            }
        }
        return true;
    }



    @Autowired
    private UserService userService;
}
