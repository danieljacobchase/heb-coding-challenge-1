package com.inventory.dao;

import com.inventory.model.Grocery;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

public class GroceryDaoImpl extends NamedParameterJdbcDaoSupport implements GroceryDao {

    @Override
    public List<Grocery> searchByDescription(String desc) {

        String sql = "select * from heb.Groceries where lower(Description) like :desc";
        Map<String,Object> params = new HashMap<>();
        params.put("desc", "%" + desc.toLowerCase() + "%");

        return this.getNamedParameterJdbcTemplate().query(sql, params, BeanPropertyRowMapper.newInstance(Grocery.class));
    }

    @Override
    public List<Grocery> searchByDepartment(String dept) {

        String sql = "select * from heb.Groceries where lower(Department) like :dept";
        Map<String,Object> params = new HashMap<>();
        params.put("dept", "%" + dept.toLowerCase() + "%");

        return this.getNamedParameterJdbcTemplate().query(sql, params, BeanPropertyRowMapper.newInstance(Grocery.class));
    }

    @Override
    public List<Grocery> searchById(Integer id) {

        String sql = "select * from heb.Groceries where ID = :id";
        Map<String,Object> params = new HashMap<>();
        params.put("id", id);

        return this.getNamedParameterJdbcTemplate().query(sql, params, BeanPropertyRowMapper.newInstance(Grocery.class));
    }

    @Override
    public List<Grocery> searchByPrice(Float price) {

        String sql = "select * from heb.Groceries where Price = :price";
        Map<String,Object> params = new HashMap<>();
        params.put("price", price);

        return this.getNamedParameterJdbcTemplate().query(sql, params, BeanPropertyRowMapper.newInstance(Grocery.class));
    }

    @Override
    public List<Grocery> searchByCost(Float cost) {

        String sql = "select * from heb.Groceries where Cost = :cost";
        Map<String,Object> params = new HashMap<>();
        params.put("cost", cost);

        return this.getNamedParameterJdbcTemplate().query(sql, params, BeanPropertyRowMapper.newInstance(Grocery.class));
    }

    @Override
    public List<Grocery> searchByShelfLife(String shelfLife) {

        String sql = "select * from heb.Groceries where lower(ShelfLife) like :shelfLife";
        Map<String,Object> params = new HashMap<>();
        params.put("shelfLife", "%" + shelfLife.toLowerCase() + "%");

        return this.getNamedParameterJdbcTemplate().query(sql, params, BeanPropertyRowMapper.newInstance(Grocery.class));
    }

    @Override
    public List<Grocery> searchByUnit(String unit) {

        String sql = "select * from heb.Groceries where lower(Unit) like :unit";
        Map<String,Object> params = new HashMap<>();
        params.put("unit", "%" + unit.toLowerCase() + "%");

        return this.getNamedParameterJdbcTemplate().query(sql, params, BeanPropertyRowMapper.newInstance(Grocery.class));
    }
}