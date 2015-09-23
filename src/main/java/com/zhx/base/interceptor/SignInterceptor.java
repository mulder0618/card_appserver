package com.zhx.base.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Created by mulder on 2015/6/11.
 */
public class SignInterceptor implements HandlerInterceptor {

    private Logger log = Logger.getLogger(String.valueOf(SignInterceptor.class));

    public SignInterceptor() {
        // TODO Auto-generated constructor stub
    }

    private String mappingURL;//利用正则映射到需要拦截的路径

    public void setMappingURL(String mappingURL) {
        this.mappingURL = mappingURL;
    }


    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler)
            throws Exception
    {
        StringBuffer paramBuffer = new StringBuffer();
        Map paramMap =  request.getParameterMap();
        Iterator<Map.Entry<String, String[]>> entries = paramMap.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<String, String[]> entry = entries.next();
            paramBuffer.append(entry.getKey());
            paramBuffer.append("=");
            for (String val : entry.getValue() ) {
                paramBuffer.append(val);
            }
            paramBuffer.append("&");
        }
        System.out.println(paramBuffer.toString().substring(0,paramBuffer.length()-1));
        return true;
    }

    //在业务处理器处理请求执行完成后,生成视图之前执行的动作
    public void postHandle(
            HttpServletRequest request,
            HttpServletResponse response, Object handler,
            ModelAndView modelAndView)
            throws Exception
    {

    }

    /**
     * 在DispatcherServlet完全处理完请求后被调用
     * <p/>
     * 当有拦截器抛出异常时,会从当前拦截器往回执行所有的拦截器的afterCompletion()
     */
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        // TODO Auto-generated method stub
    }

}
