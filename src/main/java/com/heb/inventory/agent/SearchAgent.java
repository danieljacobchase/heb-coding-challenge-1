package com.heb.inventory.agent;

import com.heb.inventory.model.Grocery;
import java.util.List;

public interface SearchAgent {

    List<Grocery> searchById(String id);
    List<Grocery> searchByDescription(String desc);
    List<Grocery> searchByShelfLife(String shelfLife);
    List<Grocery> searchByDepartment(String dept);
    List<Grocery> searchByPrice(String price);
    List<Grocery> searchByUnit(String unit);
    List<Grocery> searchByCost(String price);
    List<Grocery> searchCombinedMultiple(String searchStr);
    List<Grocery> searchCombined(String searchStr);
    List<Grocery> searchAll(String searchStr);
    List<Grocery> searchAllMultiple(String searchStr);
}
