package com.platform.chaotic.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author YanJiaJun
 * @version 1.0
 * @date 2024/4/22 21:26:24
 */
public class JwtUtil {

    /**
     * token secret
     */
    private static final String SECRET = "^&*(#$_+";

    /**
     * Default expire times
     */
    private static final Long DEFAULT_EXPIRATION = 30 * 60 * 1000L;

    /**
     * Generate User Token
     *
     * @param username username
     * @return token
     */
    public static String generateToken(String username) {
        Map<String, Object> headers = new HashMap<String, Object>(2);
        headers.put("typ", "JWT");
        headers.put("alg", "HS256");
        return JWT.create().withHeader(headers).withClaim("username", username)
                .withExpiresAt(new Date(System.currentTimeMillis() + DEFAULT_EXPIRATION))
                .sign(Algorithm.HMAC256(SECRET));
    }

    /**
     * Check User token is effective
     *
     * @param token token
     * @return Check the results
     */
    public static boolean verify(String token) {
        DecodedJWT verify = JWT.require(Algorithm.HMAC256(SECRET)).build().verify(token);
        String username = verify.getClaim("username").asString();
        if (new Date().getTime() - verify.getExpiresAt().getTime() > DEFAULT_EXPIRATION) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

}
