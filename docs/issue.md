1. Gson 版本问题 YelpEurekaServerApplication 启动失败

https://blog.csdn.net/qq_35387940/article/details/89098208

Error starting ApplicationContext. To display the conditions report re-run your application with 'debug' enabled.
2019-05-23 11:48:57.213 ERROR 34018 --- [           main] o.s.b.d.LoggingFailureAnalysisReporter   : 

***************************
APPLICATION FAILED TO START
***************************

Description:

An attempt was made to call the method com.google.gson.GsonBuilder.setLenient()Lcom/google/gson/GsonBuilder; but it does not exist. Its class, com.google.gson.GsonBuilder, is available from the following locations:

    jar:file:/Users/evol/.m2/repository/com/google/code/gson/gson/2.1/gson-2.1.jar!/com/google/gson/GsonBuilder.class

It was loaded from the following location:

    file:/Users/evol/.m2/repository/com/google/code/gson/gson/2.1/gson-2.1.jar


Action:

Correct the classpath of your application so that it contains a single, compatible version of com.google.gson.GsonBuilder