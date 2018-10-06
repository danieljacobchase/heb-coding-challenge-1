package com.heb.inventory.model;

import java.util.Date;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

public class Grocery {

    private Integer id;
    private String description;
    private Date lastSold;
    private String shelfLife;
    private String department;
    private Float price;
    private String unit;
    private Integer xFor;
    private Float cost;

    public Integer getId(){return this.id;}
    public void setId(Integer id){this.id = id;}

    public String getDescription(){return this.description;}
    public void setDescription(String description){this.description = description;}

    public Date getLastSold(){return this.lastSold;}
    public void setLastSold(Date lastSold){this.lastSold = lastSold;}

    public String getLastSoldDayOnly(){
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(this.lastSold);
    }

    public String getShelfLife(){return this.shelfLife;}
    public void setShelfLife(String shelfLife){this.shelfLife = shelfLife;}

    public String getDepartment(){return this.department;}
    public void setDepartment(String department){this.department = department;}

    public Float getPrice(){return this.price;}
    public void setPrice(Float price){this.price = price;}

    public String getPriceFormatted(){
        DecimalFormat df = new DecimalFormat("0.00");
        return "$" + df.format(this.price);
    }

    public String getUnit(){return this.unit;}
    public void setUnit(String unit){this.unit = unit;}

    public Integer getXFor(){return this.xFor;}
    public void setXFor(Integer xFor){this.xFor = xFor;}

    public Float getCost(){return this.cost;}
    public void setCost(Float cost){this.cost = cost;}

    public String getCostFormatted(){
        DecimalFormat df = new DecimalFormat("0.00");
        return "$" + df.format(this.cost);
    }

    @Override
    public String toString(){
        final StringBuilder sb = new StringBuilder();
        sb.append("Grocery");
        sb.append("{id=").append(this.id);
        sb.append(", description='").append(this.description).append('\'');
        sb.append(", lastSold=").append(this.getLastSoldDayOnly());
        sb.append(", shelfLife='").append(this.shelfLife).append('\'');
        sb.append(", department='").append(this.department).append('\'');
        sb.append(", price=").append(this.price);
        sb.append(", unit='").append(this.unit).append('\'');
        sb.append(", xFor=").append(this.xFor);
        sb.append(", cost=").append(this.cost);
        sb.append('}');
        return sb.toString();
    }

    public Boolean fullEquals(Grocery groc){
        Boolean ret = true;
        ret &= this.id == groc.id;
        ret &= this.description.compareTo(groc.description) == 0;
        ret &= this.lastSold == groc.lastSold;
        ret &= this.shelfLife.compareTo(groc.shelfLife) == 0;
        ret &= this.department.compareTo(groc.department) == 0;
        ret &= this.price == groc.price;
        ret &= this.unit.compareTo(groc.unit) == 0;
        ret &= this.xFor.compareTo(groc.xFor) == 0;
        ret &= this.cost == groc.cost;
        return ret;
    }

    @Override
    public boolean equals(Object groc){
        return this.id.intValue() == ((Grocery)groc).getId().intValue();
    }

    @Override
    public int hashCode(){
        return this.id;
    }
}
