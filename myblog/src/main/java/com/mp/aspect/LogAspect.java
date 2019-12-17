package com.mp.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.security.auth.message.callback.PrivateKeyCallback;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Aspect
@Component //开启组件扫描 springboot可以通过注解找到这一个对象
public class LogAspect {

    //logger日志记录器
    private final Logger logger= LoggerFactory.getLogger(this.getClass());

    //一个切面          能横切web文件夹下面所有控制器的请求
    @Pointcut("execution(* com.mp.web.*.*(..))")
    public void log(){ }

    @Before("log()")  //在切面之前执行
    public void doBefore(JoinPoint joinPoint){ //joinPoint可以获得类名
        ServletRequestAttributes attributes= (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=attributes.getRequest();
        String url=request.getRequestURL().toString();
        String ip=request.getRemoteAddr();
        String classMethod=joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName();
        Object[] args=joinPoint.getArgs();
        RequestLog requestLog=new RequestLog(url,ip,classMethod,args);
        logger.info("******before*******");
        logger.info("RequestLog:{}",requestLog);
    }

    @After("log()")  //在切面之后执行
    public void doAfter(){
        logger.info("******doAfter*******");
    }

    @AfterReturning(returning = "result",pointcut = "log()")
    public void doAfterReturn(Object result){
        logger.info("Result : {}",result);
    }

    private class RequestLog{
        private String url;
        private String ip;
        private String classMeyhod;
        private Object[] args;

        public RequestLog(String url, String ip, String classMeyhod, Object[] args) {
            this.url = url;
            this.ip = ip;
            this.classMeyhod = classMeyhod;
            this.args = args;
        }

        @Override
        public String toString() {
            return "RequestLog{" +
                    "url='" + url + '\'' +
                    ", ip='" + ip + '\'' +
                    ", classMeyhod='" + classMeyhod + '\'' +
                    ", args=" + Arrays.toString(args) +
                    '}';
        }
    }
}
