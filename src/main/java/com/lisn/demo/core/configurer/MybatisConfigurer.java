package com.lisn.demo.core.configurer;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

import javax.sql.DataSource;

/**
 * @Configuration表示该文件是一个配置文件
 * @Bean表示该方法是一个传统xml配置文件中的<Bean id=""></Bean>
 * 其中factory.setTypeAliasesPackage("com.example.demo.model")表示项目中model的存储路径；
 * factory.setMapperLocations(resolver.getResources("classpath:mapper/*.xml"));表示mapper.xml存储路径；
 * mapperScannerConfigurer.setBasePackage("com.example.demo.dao");表示dao层的存储路径
 */

//@Configuration
//public class MybatisConfigurer {
//
//    @Bean
//    public SqlSessionFactory sqlSessionFactoryBean(DataSource dataSource) throws Exception {
//        SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
//        factory.setDataSource(dataSource);
//        factory.setTypeAliasesPackage("com.lisn.demo.model");
//        // 添加XML目录
//        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//        factory.setMapperLocations(resolver.getResources("classpath:mapper/*.xml"));
//        return factory.getObject();
//    }
//
//    @Bean
//    public MapperScannerConfigurer mapperScannerConfigurer() {
//        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
//        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactoryBean");
//        mapperScannerConfigurer.setBasePackage("com.lisn.demo.dao");
//        return mapperScannerConfigurer;
//    }
//}
