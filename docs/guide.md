# 系列文章教程


## 跟我学Spring Cloud（Finchley版）【周立的博客】
http://www.itmuch.com/spring-cloud/finchley-1/

## Springcloud Finchley官方中文文档
[Spring Cloud Finchley.RELEASE中文参考手册](files/Spring Cloud Finchley.RELEASE中文参考手册.pdf)


## springboot2新版springcloud微服务全家桶实战

https://www.jianshu.com/p/fc1152474502

SpringCloud-Eureka服务注册与发现组件
https://www.jianshu.com/p/89f372f54614

SpringBoot框架集成token实现登录校验功能(APP)

https://blog.csdn.net/qq_37345604/article/details/89377105

基于SpringBoot和Redis实现Token权限认证

https://blog.csdn.net/zxd1435513775/article/details/86555130

SpringBoot整合Redis

https://segmentfault.com/a/1190000020939248?utm_source=tag-newest

## Spring Cloud Alibaba Nacos Config

https://juejin.im/post/5d5c0706518825587a097928

遇到的问题：
1. Springboot拦截器无法注入redisTemplate操作工具类问题

https://bigjun2017.github.io/2019/05/14/hou-duan/fen-bu-shi-kuang-jia/springboot-lan-jie-qi-wu-fa-zhu-ru-redistemplate-cao-zuo-gong-ju-lei-wen-ti/

https://blog.csdn.net/zxl646801924/article/details/99544463

解决方案：
最终调试发现，由于拦截器加载的时间点在springcontext之前，所以在拦截器中注入自然为null ；

知道拦截器执行在bean实例化前执行的，那么我们就让拦截器执行的时候实例化拦截器Bean，在拦截器配置类里面先实例化拦截器，然后再获取；


SpringBoot整合Elasticsearch

https://segmentfault.com/a/1190000018625101

    