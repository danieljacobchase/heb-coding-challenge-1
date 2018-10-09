package com.heb.inventory.dao;

import com.heb.inventory.model.Grocery;
import java.util.List;

public interface GroceryDao {

    List<Grocery> searchByDescription(String desc);
    List<Grocery> searchByDepartment(String dept);
    List<Grocery> searchById(Integer id);
    List<Grocery> searchByPrice(Float price);
    List<Grocery> searchByCost(Float cost);
    List<Grocery> searchByShelfLife(String shelfLife);
    List<Grocery> searchByUnit(String unit);
    List<Grocery> searchAll(String str);
}
