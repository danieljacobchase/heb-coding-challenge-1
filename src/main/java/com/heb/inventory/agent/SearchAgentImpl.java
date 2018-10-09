package com.heb.inventory.agent;

import com.heb.inventory.dao.GroceryDao;
import com.heb.inventory.model.Grocery;
import java.util.ArrayList;
import java.text.DecimalFormat;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;

@Component
public class SearchAgentImpl implements SearchAgent {

    @Resource
    GroceryDao groceryDao;

    /**
     * Parse input string to Integer and request DAO search on ID if appropriate.
     */
    @Override
    public List<Grocery> searchById(String id){
        try{
            Integer intId = Integer.parseInt(id);
            return this.groceryDao.searchById(intId);
        } catch(NumberFormatException nfe){
            return new ArrayList<>();
        }
    }

    /**
     * Request DAO search on description.
     */
    @Override
    public List<Grocery> searchByDescription(String desc){
        return this.groceryDao.searchByDescription(desc);
    }

    /**
     * Request DAO search on shelf life.
     */
    @Override
    public List<Grocery> searchByShelfLife(String shelfLife){
        return this.groceryDao.searchByShelfLife(shelfLife);
    }

    /**
     * Request DAO search on department.
     */
    @Override
    public List<Grocery> searchByDepartment(String dept){
        return this.groceryDao.searchByDepartment(dept);
    }

    /**
     * Parse input string to currency Float and request DAO search on price if appropriate.
     */
    @Override
    public List<Grocery> searchByPrice(String price){
        Float priceFlt = this.sanitizeMoneyString(price);
        if(priceFlt == null) return new ArrayList<>();
        else return this.groceryDao.searchByCost(priceFlt);
    }

    /**
     * Request DAO search on unit.
     */
    @Override
    public List<Grocery> searchByUnit(String unit){
        return this.groceryDao.searchByUnit(unit);
    }

    /**
     * Parse input string to currency Float and request DAO search on cost if appropriate.
     */
    @Override
    public List<Grocery> searchByCost(String cost){
        Float costFlt = this.sanitizeMoneyString(cost);
        if(costFlt == null) return new ArrayList<>();
        else return this.groceryDao.searchByCost(costFlt);
    }

    /**
     * Performs search on each field and concatenates results.
     */
    @Override
    public List<Grocery> searchCombined(String searchStr){
        List<Grocery> outList = new ArrayList<>();
        this.combineUnique(outList, this.searchById(searchStr));
        this.combineUnique(outList, this.searchByDescription(searchStr));
        this.combineUnique(outList, this.searchByShelfLife(searchStr));
        this.combineUnique(outList, this.searchByDepartment(searchStr));
        this.combineUnique(outList, this.searchByPrice(searchStr));
        this.combineUnique(outList, this.searchByUnit(searchStr));
        this.combineUnique(outList, this.searchByCost(searchStr));

        return outList;
    }

    /**
     * Accept space-separated terms and perform a combined search on each term, concatenating the results.
     */
    @Override
    public List<Grocery> searchCombinedMultiple(String searchStr){
        String[] strList = searchStr.replaceAll("( )+", " ").split(" ");
        List<Grocery> outList = new ArrayList<>();
        for(String str : strList){
            this.combineUnique(outList, this.searchCombined(str));
        }
        return outList;
    }

    /**
     * Request DAO search against all fields.
     */
    @Override
    public List<Grocery> searchAll(String searchStr){
        return this.groceryDao.searchAll(searchStr);
    }

    /**
     * Accept space-separated terms and request DAO search against all fields for each term, concatenating the results.
     */
    @Override
    public List<Grocery> searchAllMultiple(String searchStr){
        String[] strList = searchStr.replaceAll("( )+", " ").split(" ");
        List<Grocery> outList = new ArrayList<>();
        for(String str : strList){
            this.combineUnique(outList, this.searchAll(str));
        }
        return outList;
    }

    /**
     * Combine unique elements into single List.
     */
    private void combineUnique(List<Grocery> dstList, List<Grocery> addList){
        for(Grocery add : addList){
            if(!dstList.contains(add)) dstList.add(add);
        }
    }

    /**
     * Converts currency string to appropriate Float format, returning null if input cannot be parsed.
     */
    private Float sanitizeMoneyString(String moneyString){
        try{
            String cleanPrice = moneyString.replaceAll("[^\\d.]+", "");
            Float cleanPriceFlt = Float.parseFloat(cleanPrice);

            DecimalFormat df = new DecimalFormat("#.00");
            String formattedPrice = df.format(cleanPriceFlt);

            return Float.parseFloat(formattedPrice);
        } catch(NumberFormatException nfe){
            return null;
        } catch(IllegalArgumentException iae){
            return null;
        }
    }
}
