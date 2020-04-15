1.数据库
bmc 商家服务中心 Business manage center
attribute、business、category、checkin、hours

csc  评论服务中心 Comment service center
tip、review、photo



usc 用户服务中心 User service center
user、role、permission、role_permission、admin、admin_role、elite_years、friend

user,role,permission,role_permission,admin,admin_role,elite_years,friend





1.registration and discovery

eureka-server

/Users/evol/source/github/yelpcloud/yelp-eureka-server/target

```shell
#java -jar yelp-eureka-server-0.0.1-SNAPSHOT.jar --spring.profiles.active=peer1
#java -jar yelp-eureka-server-0.0.1-SNAPSHOT.jar --spring.profiles.active=peer2

```

http://localhost:8761
http://localhost:8762


2. api-server

bmc-server

/Users/evol/source/github/yelpcloud/yelp-server/yelp-bmc-server/target

```shell
#java -jar yelp-bmc-server-0.0.1-SNAPSHOT.jar --spring.profiles.active=peer1
#java -jar yelp-bmc-server-0.0.1-SNAPSHOT.jar --spring.profiles.active=peer2
```






3. consumer

web-manage

/Users/evol/source/github/yelpcloud/yelp-client/yelp-web-manage/target

```shell
#java -jar yelp-web-manage-0.0.1-SNAPSHOT.jar
```


2. provider

provider-usc

/Users/evol/source/github/yelpcloud/yelp-provider/yelp-provider-usc/target

```shell
#java -jar yelp-provider-usc-0.0.1-SNAPSHOT.jar --spring.profiles.active=peer1
#java -jar yelp-provider-usc-0.0.1-SNAPSHOT.jar --spring.profiles.active=peer2
```





