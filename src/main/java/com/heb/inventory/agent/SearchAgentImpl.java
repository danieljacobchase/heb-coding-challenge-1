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

    @Override
    public List<Grocery> searchById(String id){
        try{
            Integer intId = Integer.parseInt(id);
            return this.groceryDao.searchById(intId);
        } catch(NumberFormatException nfe){
            return new ArrayList<Grocery>();
        }
    }

    @Override
    public List<Grocery> searchByDescription(String desc){
        return this.groceryDao.searchByDescription(desc);
    }

    @Override
    public List<Grocery> searchByShelfLife(String shelfLife){
        return this.groceryDao.searchByShelfLife(shelfLife);
    }

    @Override
    public List<Grocery> searchByDepartment(String dept){
        return this.groceryDao.searchByDepartment(dept);
    }

    @Override
    public List<Grocery> searchByPrice(String price){
        try{
            String cleanPrice = price.replaceAll("[^\\d.]+", "");
            Float cleanPriceFlt = Float.parseFloat(cleanPrice);

            DecimalFormat df = new DecimalFormat("#.00");
            String formattedPrice = df.format(cleanPriceFlt);

            Float fltPrice = Float.parseFloat(formattedPrice);

            return this.groceryDao.searchByPrice(fltPrice);
        } catch(NumberFormatException nfe){
            return new ArrayList<Grocery>();
        } catch(IllegalArgumentException iae){
            return new ArrayList<Grocery>();
        }
    }

    @Override
    public List<Grocery> searchByUnit(String unit){
        return this.groceryDao.searchByUnit(unit);
    }

    @Override
    public List<Grocery> searchByCost(String price){
        Float priceFlt = this.sanitizeMoneyString(price);
        if(priceFlt == null) return new ArrayList<Grocery>();
        else return this.groceryDao.searchByCost(priceFlt);
    }

    @Override
    public List<Grocery> searchCombinedMultiple(String searchStr){
        String[] strList = searchStr.replaceAll("( )+", " ").split(" ");
        List<Grocery> outList = new ArrayList<>();
        for(String str : strList){
            this.combineUnique(outList, this.searchCombined(str));
        }
        return outList;
    }

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

    private void combineUnique(List<Grocery> dstList, List<Grocery> addList){
        for(Grocery add : addList){
            if(!dstList.contains(add)) dstList.add(add);
        }
    }

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
