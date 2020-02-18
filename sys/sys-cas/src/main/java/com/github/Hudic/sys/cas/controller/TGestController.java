package com.github.Hudic.sys.cas.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hudic © eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJhdXRoMCJ9.c0qzhjz09J4upu0VA3Vp0iDUqgckPFhQB71nFpq7FGQ
 * Created by Jiangcq at 2019/9/13 14:35
 */
@RestController
@RequestMapping("/test")
public class TGestController {
    @RequestMapping("/test1")
    public String test() {
        return "test.";
    }

    @PostMapping("/login")
    public String login(String username, String password) {
        return "登陆成功";
    }

    public static void main(String[] args){
        String str = "jiangchangqinqw123456";
        Algorithm algorithm = Algorithm.HMAC256(str);
        String token = JWT.create().withClaim("username", "admin").withClaim("password", "123123").withIssuer("auth0")
                .sign(algorithm);
        System.out.println(token);
        DecodedJWT decodedJWT = JWT.decode(token);
        System.out.println(decodedJWT.getHeader());
        System.out.println(decodedJWT.getPayload());
        System.out.println(decodedJWT.getSignature());
        System.out.println(decodedJWT.getToken());
        System.out.println(decodedJWT.getClaim("username").asString());
        System.out.println(decodedJWT.getClaim("password").asString());
    }
}
