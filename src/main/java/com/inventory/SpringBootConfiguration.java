package com.inventory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import com.inventory.dao.GroceryDao;

@Configuration
public class SpringBootConfiguration {

    @Bean
    public BasicDataSource dataSource() {
        BasicDataSource bds = new BasicDataSource();
        //bds.setDriverClassName("org.hsqldb.jdbcDriver");
        bds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        bds.setUrl("jdbc:mysql://danthroposrds.czlsymlnerqj.us-east-2.rds.amazonaws.com:3306");
        bds.setUsername("danthropos");
        bds.setPassword("8tYXahmvN1oJ");
        return bds;
    }

    @Bean
    public GroceryDao groceryDao() {
        GroceryDao gd = new GroceryDao();
        gd.setDataSource(this.dataSource());
        return gd;
    }
}
