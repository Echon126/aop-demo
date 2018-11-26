### Spring AOP 学习分析

####OOP与AOP的区别
 OOP中模块化的单元是类，AOP中，模块化的核心单元是面
 
 基于两种形式的不同代理通过调用getClass() API，就会得到如下的结果：
 For JDK proxy, output is:    com.sun.proxy.$Proxy12
 for CGlib proxy,output is:    class salesdepart.service.app.SalesDepartEmployee$$EnhancerBySpring CGLIB $ $ 397e3c56


Spring AOP的实现原理