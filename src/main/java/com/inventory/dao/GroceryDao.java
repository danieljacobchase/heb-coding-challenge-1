package com.inventory.dao;

import com.inventory.model.Grocery;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.object.SqlQuery;
import javax.sql.DataSource;

import java.sql.Types;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class GroceryDao extends JdbcDaoSupport {

    private SelectGroceryById selectGroceryById;

    private static class SelectGroceryById extends SqlQuery {

        SelectGroceryById(DataSource ds) {
            super(ds, "select * from t_customer where id=?");
            declareParameter(new SqlParameter(Types.INTEGER));
        }

        protected RowMapper newRowMapper(Object[] parameters, Map context) {
            return BeanPropertyRowMapper.newInstance(Grocery.class);
        }
    }

    @Override
    protected void initDao() throws Exception {
        this.selectGroceryById = new SelectGroceryById(getDataSource());
    }

    @SuppressWarnings({"unchecked"})
    public List<Grocery> getAll() {
        return getJdbcTemplate().query("select * from heb.Groceries", BeanPropertyRowMapper.newInstance(Grocery.class));
    }

    public Grocery getById(long id) {
        return (Grocery)this.selectGroceryById.findObject(id);
    }
}