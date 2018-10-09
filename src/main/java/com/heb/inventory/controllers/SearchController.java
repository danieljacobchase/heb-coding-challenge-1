package com.heb.inventory.controllers;

import com.heb.inventory.util.GroceryListUtil;
import com.heb.inventory.model.Grocery;
import com.heb.inventory.model.SearchRequest;
import com.heb.inventory.agent.SearchAgent;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value={"", "/", "search"})
public class SearchController {

    @Resource
    SearchAgent searchAgent;

    /**
     * Inintialize search form with blank search request.
     */
	@RequestMapping(method = RequestMethod.GET)
	public String searchForm(Map<String, Object> model) {

		SearchRequest sr = new SearchRequest();
		model.put("searchRequest", sr);

		return "search";
	}

    /**
     * Process search request and populate table with results.
     */
	@RequestMapping(method = RequestMethod.POST)
	public String processSearch(
		@ModelAttribute("searchRequest") SearchRequest req,
		Map<String, Object> model) {

		List<Grocery> grocListDB = this.searchAgent.searchAllMultiple(req.getSearchText());
		GroceryListUtil.sortById(grocListDB);
		model.put("grocList", grocListDB);

		return "search";
	}
}