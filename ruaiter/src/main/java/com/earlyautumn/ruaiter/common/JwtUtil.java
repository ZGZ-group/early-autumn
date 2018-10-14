package com.earlyautumn.ruaiter.common;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.earlyautumn.ruaiter.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.util.Date;

public class JwtUtil {

    public static final String TOKEN_KEY = "ea_token";

    private static Logger logger = LoggerFactory.getLogger(JwtUtil.class);
    // 过期时间10分钟
    private static final long EXPIRE_TIME = 10 * 60 * 1000;
    private static final String USER_KEY = "username";


    /**
     * 校验token是否正确
     *
     * @param token  密钥
     * @param secret 用户的密码
     * @return 是否正确
     */
    public static boolean verify(String token, String username, String secret) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withClaim(USER_KEY, username)
                    .build();
            DecodedJWT jwt = verifier.verify(token);
            return Boolean.TRUE;
        } catch (Exception exception) {
            logger.warn("用户名'{}'校验失败", username);
            return Boolean.FALSE;
        }
    }

    /**
     * 获得token中的信息无需secret解密也能获得
     *
     * @return token中包含的用户名
     */
    public static String getUsername(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim(USER_KEY).asString();
        } catch (JWTDecodeException e) {
            return StringUtils.EMPTY;
        }
    }

    /**
     * 生成签名,10min后过期
     *
     * @param username 用户名
     * @param secret   用户的密码
     * @return 加密的token
     */
    public static String sign(String username, String secret) {
        //TODO secret加密选择
        try {
            Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            Algorithm algorithm = Algorithm.HMAC256(secret);
            // 附带username信息
            return JWT.create()
                    .withClaim(USER_KEY, username)
                    .withExpiresAt(date)
                    .sign(algorithm);
        } catch (UnsupportedEncodingException e) {
            logger.warn("用户名'{}'生成签名失败", username);
            return StringUtils.EMPTY;
        }
    }

}
