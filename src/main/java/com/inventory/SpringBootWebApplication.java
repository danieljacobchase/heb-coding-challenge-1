package com.inventory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootWebApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringBootWebApplication.class);
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SpringBootWebApplication.class, args);



		/*ApplicationContext ac = new ClassPathXmlApplicationContext("context.xml", com.inventory.SpringBootWebApplication.class);
		DataSource dataSource = (DataSource) ac.getBean("dataSource");

		GroceryDao customerDao = (GroceryDao)ac.getBean("groceryDao");

		List<Grocery> groceryList = customerDao.getAll();
		for(Grocery groc : groceryList){
			System.out.println(groc.toString());
		}*/
	}

}