package com.inventory.controllers;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.inventory.dao.DatabaseDao;
import com.inventory.dao.GroceryDao;

import com.inventory.model.Grocery;
import com.inventory.model.SearchRequest;
import com.inventory.agent.SearchAgent;

import java.util.List;
import java.util.Date;

import javax.annotation.Resource;

@Controller
@RequestMapping(value={"", "/", "search"})
public class SearchController {

	// inject via application.properties
	//@Value("${welcome.message:test}")
	//private String message = "Hello World";

    @Resource
    SearchAgent searchAgent;

	@RequestMapping(method = RequestMethod.GET)
	public String searchForm(Map<String, Object> model) {

		//DatabaseDao db = new DatabaseDao();
		//String results = db.getGroceries();

		/*String results = "";
		List<Grocery> groceryList = groceryDao.getAll();
		for(Grocery groc : groceryList){
			results += groc.getDescription() + " ";
		}*/

		SearchRequest sr = new SearchRequest();

		model.put("searchRequest", sr);
		model.put("message", "");

		//model.put("message", results);

		//model.put("message", this.message);
		return "search";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processSearch(
		@ModelAttribute("searchRequest") SearchRequest req,
		Map<String, Object> model) {

		// implement your own registration logic here...

		//DatabaseDao db = new DatabaseDao();
		//String results = db.getGroceries();

		// for testing purpose:
		//System.out.println("DB Dao: " + results);

		//List<Grocery> grocListDB = this.groceryDao.getAll();
        List<Grocery> grocListDB = this.searchAgent.getAllGroceries();

		model.put("grocList", grocListDB);

		return "search";
	}
}