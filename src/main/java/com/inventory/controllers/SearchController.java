package com.inventory.controllers;

import com.inventory.model.Grocery;
import com.inventory.model.SearchRequest;
import com.inventory.agent.SearchAgent;
import com.inventory.util.GroceryListUtil;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

import javax.annotation.Resource;

@Controller
@RequestMapping(value={"", "/", "search"})
public class SearchController {

    @Resource
    SearchAgent searchAgent;

	@RequestMapping(method = RequestMethod.GET)
	public String searchForm(Map<String, Object> model) {

		SearchRequest sr = new SearchRequest();
		model.put("searchRequest", sr);

		return "search";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processSearch(
		@ModelAttribute("searchRequest") SearchRequest req,
		Map<String, Object> model) {

		List<Grocery> grocListDB = this.searchAgent.searchCombinedMultiple(req.getSearchText());
		GroceryListUtil.sortById(grocListDB);
		model.put("grocList", grocListDB);

		return "search";
	}
}