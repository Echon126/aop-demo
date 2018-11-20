package com.wen.aop.example.explain;

/**
 * @author admin
 * @date 2018-11-20 16:07
 */
public class Readme {

    /**
     * SpringAOP AOP Aspect Oriented Programming 缩写，面向方向编程，AOP实际是GoF设计模式的延伸
     *
     * AOP 术语
     * 切面（Aspect）在spring AOP中，切面可以使用通用类或者普通类中以@Aspect注解来实现
     * 连接点(Joinpoint)在spring AOP中一个连接点代表一个方法的执行。
     * 通知（Advice） 在切面的某个特定的连接点（Joinpoint）上执行的动作。通知有各种类型，其中包括
     * 'around'、'before'、''after' 等通知。
     *
     * 许多AOP框架，包括spring，都是以拦截器做通知模型，并维护一个以连接点为中心的拦截链
     *
     * 切入点（Pointcut）：定义出一个或一组方法，当执行这些方法时可产生通知，Spring缺省使用AspectJ切入点语法。
     *
     *
     * 通知类型：
     * 前置通知（@Before）：在某连接点（join point）之前执行的通知，但这个通知不能阻止连接点前的执行（除非它抛出一个异常）
     * 返回后通知（@AfterReturning）：在某连接点（join point）正常完成后执行的通知：例如，一个方法没有抛出任何异常，正常返回
     * 抛出异常后通知（@AfterThrowing）：方法抛出异常退出时执行的通知
     * 后通知（@After）：当某连接点退出的时候执行的通知（不论是正常返回还是异常退出）
     * 环绕通知（@Around）：包围一个连接点（join point）的通知，如方法调用。这是最强大的一种通知类型，环绕通知可以在方法调用前后完成自定义的行为，
     * 它也会选择是否继续执行连接点或直接返回它们自己的返回值或抛出异常来结束执行
     *
     *
     *
        Spring AOP配置有两种风格：
         XML风格 = 采用声明形式实现Spring AOP
         AspectJ风格 = 采用注解形式实现Spring AOP



     */














}
