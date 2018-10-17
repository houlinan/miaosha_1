package cn.hgxsp.miaosha_1.config;

import cn.hgxsp.miaosha_1.Domain.User;
import cn.hgxsp.miaosha_1.redis.MiaoShaUserKey;
import cn.hgxsp.miaosha_1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * DESC：
 * CREATED BY ：@hou.linan
 * CREATED DATE ：2018/10/17
 * Time : 14:38
 */
@Service
public class UserArgumentResolver implements HandlerMethodArgumentResolver {

    @Autowired
    UserService userService ;
    

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        Class<?> parameterType = methodParameter.getParameterType();

        return parameterType == User.class;
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter,
                                  ModelAndViewContainer modelAndViewContainer,
                                  NativeWebRequest nativeWebRequest,
                                  WebDataBinderFactory webDataBinderFactory) throws Exception {

        HttpServletRequest request = nativeWebRequest.getNativeRequest(HttpServletRequest.class);
        HttpServletResponse response = nativeWebRequest.getNativeResponse(HttpServletResponse.class);
        String paramToken = request.getParameter( MiaoShaUserKey.COOKIE_NAME_TOKEN);
        String cookieToken = getCookie(request ,  MiaoShaUserKey.COOKIE_NAME_TOKEN) ;

        if(StringUtils.isEmpty(cookieToken) && StringUtils.isEmpty(paramToken)) return null ;

        String token = StringUtils.isEmpty(paramToken) ? cookieToken : paramToken ;

        User user = userService.getByToken(token, response);
        System.out.println(user);
        return user;

    }


    private String getCookie(HttpServletRequest request, String token){
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie : cookies){
            System.out.println(cookie.getName());
            if(cookie.getName().equals(token)) return cookie.getValue() ;
        }
        return null ;
    }
}
