package com.github.Hudic.web.index.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录过滤器
 */
@Component
public class InterceptorConfig implements HandlerInterceptor {

    private static Logger logger = LoggerFactory.getLogger(InterceptorConfig.class);

    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object o) throws Exception {
        System.out.println("进来了preHandle");
        final String noTokenStr = "未登录";
        resp.setContentType("text/html;charset=UTF-8");
//
//        //获取token，如果在缓存中可以获取到，说明该用户已登录
//        String tokenCode = req.getHeader(SysConstants.TOKEN);
//        if(Tools.checkEmpty(tokenCode))
//        {
//            tokenCode = req.getParameter(SysConstants.TOKEN);
//        }
//
//        if(Tools.checkEmpty(tokenCode)) {
//            logger.warn(req.getRequestURI() + ":");
//            resp.getWriter().print(noTokenStr);
//            return false;
//        }
//
//        try {
//            String userCode = (String) CacheUtil.getCache(CacheCodeEnum.INNERWEB.getValue()).get(tokenCode);
//            if (!Tools.checkEmpty(userCode)){
//                //续期
//                long CACHE_OVER_TIME = 30;//等保要求：30分钟
//                CacheUtil.getCache(CacheCodeEnum.INNERWEB.getValue()).expire(userCode, CACHE_OVER_TIME);
//                CacheUtil.getCache(CacheCodeEnum.INNERWEB.getValue()).expire(tokenCode, CACHE_OVER_TIME);
//                CacheUtil.getCache(CacheCodeEnum.INNERWEB.getValue()).expire(tokenCode + SysConstants.TOKEN_LOGIN_USERID_SUFFIX, CACHE_OVER_TIME);
//                CacheUtil.getCache(CacheCodeEnum.INNERWEB.getValue()).expire(tokenCode + SysConstants.TOKEN_LOGIN_USERNAME_SUFFIX, CACHE_OVER_TIME);
//                CacheUtil.getCache(CacheCodeEnum.INNERWEB.getValue()).expire(tokenCode + SysConstants.TOKEN_LOGIN_USER_SUFFIX, CACHE_OVER_TIME);
//
//                return true;
//            }
//            else{
//                logger.warn(req.getRequestURI() + ":缓存中缺少userCode,token:" + tokenCode);
//                resp.getWriter().print(noTokenStr);
//                return false;
//            }
//        } catch (Exception e) {
//            logger.error(e.getMessage(),e);
//            return false;
//        }
        System.out.println("**************jinlaile1");
//        resp.getWriter().print(noTokenStr);
//        return false;
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

    public static void main(String[] args) throws InterruptedException {
    }

}
