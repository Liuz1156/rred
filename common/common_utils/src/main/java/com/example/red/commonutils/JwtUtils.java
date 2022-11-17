package com.example.red.commonutils;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import org.springframework.util.StringUtils;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;



/**
 * @author helen
 * @since 2019/10/16
 */
public class JwtUtils {

    //常量
    /** token 过期时间: 1天 */
    public static final int calendarField = Calendar.DATE;
    public static final int calendarInterval = 1;
    public static final String SING = "Zhh1156379."; //秘钥

    //生成token字符串的方法
    public static String getToken(Map<String, String> map) {
        try {
            Date iatDate = new Date();
            // expire time
            Calendar nowTime = Calendar.getInstance();
            nowTime.add(calendarField, calendarInterval);
            Date expiresDate = nowTime.getTime();

            Map<String, Object> header = new HashMap<>(2);
            header.put("Type", "Jwt");
            header.put("alg", "HS256");

            //System.out.println(map.get("phoneNumber"));
            String token = JWT.create()
                    .withHeader(header)
                    .withClaim("iss", "Service") // payload
                    .withClaim("aud", "APP")
                    .withClaim("phoneNumber", null == map.get("phoneNumber") ? null : map.get("phoneNumber"))
                    .withClaim("password", null == map.get("password") ? null : map.get("password"))
                    .withIssuedAt(iatDate) // sign time
                    .withExpiresAt(expiresDate) // expire time
                    .sign(Algorithm.HMAC256(SING)); // signature
            System.out.println(token);
            return token;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * 解密Token
     *
     * @param token
     * @return
     * @throws Exception
     */
    public static Map<String, Claim> verifyToken(String token) {
        DecodedJWT jwt = null;
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SING)).build();
            jwt = verifier.verify(token);
        } catch (Exception e) {
            // e.printStackTrace();
            // token 校验失败, 抛出Token验证非法异常
        }
        return jwt.getClaims();
    }

    /**
     * 获取token的信息方法
     */
    public static DecodedJWT getTokenInfo(String token){
        //DecodedJWT verify = JWT.require(Algorithm.HMAC256(SING)).build().verify(token);
        DecodedJWT verify = JWT.decode(token);
        return verify;
    }


    /**
     * 根据Token获取user_id
     *
     * @param token
     * @return user_id
     */

    public static String getUserPhoneNumber(String token) throws Exception{
        DecodedJWT verify = JWT.decode(token);
        Claim user_phoneNumber_claim = verify.getClaim("phoneNumber");
        //System.out.println("get userPhoneNumber " + user_phoneNumber_claim.asString());
        if (null == user_phoneNumber_claim || StringUtils.isEmpty(user_phoneNumber_claim.asString())) {
            return null;
        }
        //System.out.println("get userPhoneNumber " +user_phoneNumber_claim.asString());
        return user_phoneNumber_claim.asString();
    }



}
