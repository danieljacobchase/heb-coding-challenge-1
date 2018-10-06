package com.inventory.agent;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import com.inventory.dao.GroceryDao;
import com.inventory.model.Grocery;
import java.util.List;

@Component
public class SearchAgent {

    @Resource
    GroceryDao groceryDao;

    public List<Grocery> getAllGroceries(){
        return this.groceryDao.getAll();
    }

}
