package com.wen.aop.example.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 定义切面类
 *
 * @author admin
 * @date 2018-11-21 11:00
 */
@Aspect
@Component
public class AopTestController {
    private static final Logger logger = LoggerFactory.getLogger(AopTestController.class);

    /**
     * 顶一个切点
     */
    @Pointcut(value = "execution(public String test(..)))")
    public void cutOffPoint() {
    }

    /**
     * 在切入点开始处切入内容
     *
     * @Before里的值就是切入点所注解的方法名 场景：
     * 如果要扩展一些代码，在不需要动源代码的基础之上就可以进行拓展。
     */
    @Before("cutOffPoint()")
    public void beforeTest() {
        logger.info("前置通知----执行test之前执行");
    }

    /**
     * 后置通知
     * 和前置通知相反，在切入点之后执行
     */
    @After("cutOffPoint()")
    public void doAfter() {
        logger.info("后置通知-----执行test之后执行");
    }


    ThreadLocal<Long> startTime = new ThreadLocal<>();

    /**
     * 实现了包括了前置和后置通知
     * 使用环绕通知时，proceed方法必须调用，否则拦截到的方法不会再执行了
     * 环绕通知=前置+目标方法执行+后置通知，proceed方法就是用于启动目标方法执行的
     * <p>
     * 场景：
     * 环绕通知可以项目全局异常处理
     * 日志记录
     * 用来做数据全局缓存
     * 全局的事务处理等
     *
     * @param pjp
     * @return
     */
    @Around("cutOffPoint()")
    public Object doAround(ProceedingJoinPoint pjp) {
        startTime.set(System.currentTimeMillis());
        logger.info("环绕通知-----开始执行环绕通知");
        Object object;
        try {
            object = pjp.proceed();
            logger.info("环绕通知----执行返回值： " + object);
            logger.info("环绕通知"+pjp.getSignature().getName() + "方法执行耗时" + (System.currentTimeMillis() - startTime.get()));
        } catch (Throwable throwable) {
            object = throwable.toString();
        }
        return object;
    }

    /**
     * 执行完环绕可以做这个
     * 切点返回结果之后执行，也就是前置后置换环绕执行了，才执行这个
     * <p>
     * 场景：
     * 订单支付完成之后就执行二次的结果验证，重要的参数的二次校验，防止在方法执行中的时候参数被修改等。
     *
     * @param result
     * @throws Throwable
     */
    @AfterReturning(returning = "result", pointcut = "cutOffPoint()")
    public void doAfterReturning(Object result) throws Throwable {
        logger.info("前置后置环绕都执行完了在执行");
    }


    @AfterThrowing(throwing = "e", pointcut = "cutOffPoint()")
    public void doAfterReturnThrowing(Throwable e) {
        logger.info("切入点执行报错的时候执行");
        logger.info("错误信息" + e.getMessage());
    }


}














