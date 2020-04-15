//package com.evol.utils;
//
//import java.io.InputStream;
//import java.util.ArrayList;
//import java.util.List;
//import org.mybatis.generator.api.MyBatisGenerator;
//import org.mybatis.generator.config.Configuration;
//import org.mybatis.generator.config.xml.ConfigurationParser;
//import org.mybatis.generator.internal.DefaultShellCallback;
//
///**
// * https://juejin.im/post/5c42baa2f265da6163025517
// * https://github.com/flowstone/simon-mybatis-generator/blob/master/pom.xml
// */
//public class MybatisGenerator {
//
//    public static void main(String[] args) throws Exception{
//        //警告信息集合
//        List<String> warnings = new ArrayList<>();
//        //当生成的代码重复时，覆盖原代码
//        boolean repeatIsOverwirte = true;
//        //读取生成器的配置文件
//        InputStream resourceAsStream = MybatisGenerator.class.getResourceAsStream("/mybatis-generator.xml");
//
//        //创建配置解析器
//        ConfigurationParser configurationParser = new ConfigurationParser(warnings);
//        //解析配置文件
//        Configuration configuration = configurationParser.parseConfiguration(resourceAsStream);
//        resourceAsStream.close();
//        DefaultShellCallback defaultShellCallback = new DefaultShellCallback(repeatIsOverwirte);
//        //创建生成器对象
//        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(configuration, defaultShellCallback, warnings);
//        //执行生成代码
//        myBatisGenerator.generate(null);
//
//        //输出警告信息
//        for (String warning : warnings){
//            System.out.println(warning);
//        }
//
//
//    }
//}
