package com.heb.inventory.dao;

import com.heb.inventory.model.Grocery;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

public class GroceryDaoImpl extends NamedParameterJdbcDaoSupport implements GroceryDao {

    private final String DESC_EQ = "lower(Description) like :desc";
    private final String DEPT_EQ = "lower(Department) like :dept";
    private final String ID_EQ = "ID = :id";
    private final String PRICE_EQ = "Price = :price";
    private final String COST_EQ = "Cost = :cost";
    private final String SHELF_LIFE_EQ = "lower(ShelfLife) like :shelfLife";
    private final String UNIT_EQ = "lower(Unit) like :unit";

    /**
     * Perform query based on product description.
     */
    @Override
    public List<Grocery> searchByDescription(String desc) {

        String sql = "select * from heb.Groceries where " + DESC_EQ;
        Map<String,Object> params = new HashMap<>();
        params.put("desc", "%" + desc.toLowerCase() + "%");

        return this.getNamedParameterJdbcTemplate().query(sql, params, BeanPropertyRowMapper.newInstance(Grocery.class));
    }

    /**
     * Perform query based on product department.
     */
    @Override
    public List<Grocery> searchByDepartment(String dept) {

        String sql = "select * from heb.Groceries where " + DEPT_EQ;
        Map<String,Object> params = new HashMap<>();
        params.put("dept", "%" + dept.toLowerCase() + "%");

        return this.getNamedParameterJdbcTemplate().query(sql, params, BeanPropertyRowMapper.newInstance(Grocery.class));
    }

    /**
     * Perform query based on product ID.
     */
    @Override
    public List<Grocery> searchById(Integer id) {

        String sql = "select * from heb.Groceries where " + ID_EQ;
        Map<String,Object> params = new HashMap<>();
        params.put("id", id);

        return this.getNamedParameterJdbcTemplate().query(sql, params, BeanPropertyRowMapper.newInstance(Grocery.class));
    }

    /**
     * Perform query based on product price.
     */
    @Override
    public List<Grocery> searchByPrice(Float price) {

        String sql = "select * from heb.Groceries where " + PRICE_EQ;
        Map<String,Object> params = new HashMap<>();
        params.put("price", price);

        return this.getNamedParameterJdbcTemplate().query(sql, params, BeanPropertyRowMapper.newInstance(Grocery.class));
    }

    /**
     * Perform query based on product cost.
     */
    @Override
    public List<Grocery> searchByCost(Float cost) {

        String sql = "select * from heb.Groceries where " + COST_EQ;
        Map<String,Object> params = new HashMap<>();
        params.put("cost", cost);

        return this.getNamedParameterJdbcTemplate().query(sql, params, BeanPropertyRowMapper.newInstance(Grocery.class));
    }

    /**
     * Perform query based on product shelf life.
     */
    @Override
    public List<Grocery> searchByShelfLife(String shelfLife) {

        String sql = "select * from heb.Groceries where " + SHELF_LIFE_EQ;
        Map<String,Object> params = new HashMap<>();
        params.put("shelfLife", "%" + shelfLife.toLowerCase() + "%");

        return this.getNamedParameterJdbcTemplate().query(sql, params, BeanPropertyRowMapper.newInstance(Grocery.class));
    }

    /**
     * Perform query based on product unit.
     */
    @Override
    public List<Grocery> searchByUnit(String unit) {

        String sql = "select * from heb.Groceries where " + UNIT_EQ;
        Map<String,Object> params = new HashMap<>();
        params.put("unit", "%" + unit.toLowerCase() + "%");

        return this.getNamedParameterJdbcTemplate().query(sql, params, BeanPropertyRowMapper.newInstance(Grocery.class));
    }

    /**
     * Perform query representing the union of all product fields.
     */
    @Override
    public List<Grocery> searchAll(String str){

        String sql = "select * from heb.Groceries where ";
        Map<String,Object> params = new HashMap<>();

        //description
        sql += DESC_EQ;
        params.put("desc", "%" + str.toLowerCase() + "%");

        //department
        sql += " OR ";
        sql += DEPT_EQ;
        params.put("dept", "%" + str.toLowerCase() + "%");

        //id
        Integer idParsed;
        try{
            idParsed = Integer.parseInt(str);
            sql += " OR ";
            sql += ID_EQ;
            params.put("id", idParsed);
        }
        catch(NumberFormatException nfe) {}

        //price
        Float priceParsed;
        try{
            priceParsed = Float.parseFloat(str);
            sql += " OR ";
            sql += PRICE_EQ;
            params.put("price", priceParsed);
        }
        catch(NumberFormatException nfe) {}

        //cost
        Float costParsed;
        try{
            costParsed = Float.parseFloat(str);
            sql += " OR ";
            sql += COST_EQ;
            params.put("cost", costParsed);
        }
        catch(NumberFormatException nfe) {}

        //shelfLife
        sql += " OR ";
        sql += SHELF_LIFE_EQ;
        params.put("shelfLife", "%" + str.toLowerCase() + "%");

        //unit
        sql += " OR ";
        sql += UNIT_EQ;
        params.put("unit", "%" + str.toLowerCase() + "%");

        return this.getNamedParameterJdbcTemplate().query(sql, params, BeanPropertyRowMapper.newInstance(Grocery.class));
    }
}