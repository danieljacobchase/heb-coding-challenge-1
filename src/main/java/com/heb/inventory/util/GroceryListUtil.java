package com.heb.inventory.util;

import com.heb.inventory.model.Grocery;
import java.util.List;

public class GroceryListUtil {

    public static void sortById(List<Grocery> grocList) {
        grocList.sort((o1, o2) -> (o1.getId().compareTo(o2.getId())));
    }

    public static void sortByCost(List<Grocery> grocList) {
        grocList.sort((o1, o2) -> (o1.getCost().compareTo(o2.getCost())));
    }

    public static void sortByPrice(List<Grocery> grocList) {
        grocList.sort((o1, o2) -> (o1.getPrice().compareTo(o2.getPrice())));
    }

    public static void sortByLastSold(List<Grocery> grocList) {
        grocList.sort((o1, o2) -> (o1.getLastSold().compareTo(o2.getLastSold())));
    }
}
