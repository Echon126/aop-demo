### Spring AOP 学习分析

####OOP与AOP的区别
 OOP中模块化的单元是类，AOP中，模块化的核心单元是面
 
 基于两种形式的不同代理通过调用getClass() API，就会得到如下的结果：
 For JDK proxy, output is:    com.sun.proxy.$Proxy12
 for CGlib proxy,output is:    class salesdepart.service.app.SalesDepartEmployee$$EnhancerBySpring CGLIB $ $ 397e3c56


Spring AOP的实现原理




##### 跨域
对于浏览器的同源策略，不受限制的外域资源加载情况有以下几种:
script
link
img
video
object embed applet
font-face 有的浏览器允许, 有的禁止
frame

##### 
当数据是引用类型时，用static和final修饰表示这是只占据一块不能改变的内存空间。
有一条约定成俗的规定是使用stati和final修饰的变量即编译期常量应该用全部大写字母表示