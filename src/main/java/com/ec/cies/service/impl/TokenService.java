package com.ec.cies.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.ec.cies.pojo.User;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService implements com.ec.cies.service.TokenService {
    @Override
    public String getToken(User user) {
        Date start = new Date();
        long currentTime = System.currentTimeMillis() + 60* 60 * 1000 * 24 * 7;//一小时有效时间
        Date end = new Date(currentTime);
        String token = "";

        token = JWT.create().withAudience(user.getUserId().toString()).withIssuedAt(start).withExpiresAt(end)
                .withClaim("userName",user.getUserName())
                .sign(Algorithm.HMAC256(user.getUserPwd()));
        return token;
    }
}
