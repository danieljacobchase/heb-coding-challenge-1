package com.heb.inventory;

import com.heb.inventory.dao.GroceryDao;
import com.heb.inventory.dao.GroceryDaoImpl;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;

@Configuration
public class SpringBootConfiguration {

    @Value("${db.driver}")
    private String driver;

    @Value("${db.url}")
    private String url;

    @Value("${db.port}")
    private String port;

    @Value("${db.username}")
    private String username;

    @Value("${db.password}")
    private String password;

    @Bean
    public BasicDataSource dataSource() {
        BasicDataSource bds = new BasicDataSource();
        bds.setDriverClassName(this.driver);
        bds.setUrl(this.url + ":" + this.port);
        bds.setUsername(this.username);
        bds.setPassword(this.password);
        return bds;
    }

    @Bean
    public GroceryDao groceryDao() {
        GroceryDaoImpl gd = new GroceryDaoImpl();
        gd.setDataSource(this.dataSource());
        return gd;
    }
}
