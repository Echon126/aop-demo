package com.wen.aop.example.aop;

import com.wen.aop.example.annotation.SystemControllerLog;
import com.wen.aop.example.annotation.SystemServiceLog;
import com.wen.aop.example.entity.SystemLogStrategy;
import com.wen.aop.example.utils.JsonUtil;
import com.wen.aop.example.utils.ThreadUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * @author admin
 * @date 2018-11-20 15:14
 */
@Aspect
public class SystemLogAspect {
    private static final Logger LOG = LoggerFactory.getLogger(SystemLogAspect.class);

    /**
     * 业务逻辑方法切入点
     */
    @Pointcut("execution(* com.wen.aop.example.controller..*(..))")
    public void pointcut() {

    }

    @Around("pointcut()")
    public Object doInvoke(ProceedingJoinPoint pjp) {
        long start = System.currentTimeMillis();

        Object result = null;

        try {
            result = pjp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            LOG.error(throwable.getMessage(), throwable);
            throw new RuntimeException(throwable);
        } finally {
            long end = System.currentTimeMillis();
            long elapsedTime = end - start;

            printLog(pjp, result, elapsedTime);

        }

        return result;
    }

    /**
     * 打印日志
     * @param pjp   连接点
     * @param result    方法调用返回结果
     * @param elapsedTime   方法调用花费时间
     */
    private void printLog(ProceedingJoinPoint pjp, Object result, long elapsedTime) {
        SystemLogStrategy strategy = getFocus(pjp);

        if (null != strategy) {
            strategy.setThreadId(ThreadUtil.getThreadId());
            strategy.setResult(JsonUtil.toJSONString(result));
            strategy.setElapsedTime(elapsedTime);
            if (strategy.isAsync()) {
                new Thread(()->LOG.info(strategy.format(), strategy.args())).start();
            }else {
                LOG.info(strategy.format(), strategy.args());
            }
        }
    }

    /**
     * 获取注解
     */
    private SystemLogStrategy getFocus(ProceedingJoinPoint pjp) {
        Signature signature = pjp.getSignature();
        String className = signature.getDeclaringTypeName();
        String methodName = signature.getName();
        Object[] args = pjp.getArgs();
        String targetClassName = pjp.getTarget().getClass().getName();
        try {
            Class<?> clazz = Class.forName(targetClassName);
            Method[] methods = clazz.getMethods();
            for (Method method : methods) {
                if (methodName.equals(method.getName())) {
                    if (args.length == method.getParameterCount()) {

                        SystemLogStrategy strategy = new SystemLogStrategy();
                        strategy.setClassName(className);
                        strategy.setMethodName(methodName);

                        SystemControllerLog systemControllerLog = method.getAnnotation(SystemControllerLog.class);
                        if (null != systemControllerLog) {
                            strategy.setArguments(JsonUtil.toJSONString(args));
                            strategy.setDescription(systemControllerLog.description());
                            strategy.setAsync(systemControllerLog.async());
                            strategy.setLocation("SystemControllerLog");
                            return strategy;
                        }
                        SystemServiceLog systemServiceLog = method.getAnnotation(SystemServiceLog.class);
                        if (null != systemServiceLog) {
                            strategy.setArguments(JsonUtil.toJSONString(args));
                            strategy.setDescription(systemServiceLog.description());
                            strategy.setAsync(systemServiceLog.async());
                            strategy.setLocation("SystemServiceLog");
                            return strategy;
                        }

                        return null;
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            LOG.error(e.getMessage(), e);
        }
        return null;
    }


    /**
     * TODO SpringAOP注解分析
     * @Pointcut 方法切入点
     * @Before 前置通知
     * @AfterReturning 后置通知
     *
     */
}
