package com.inventory.model;

import java.util.Date;

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

    public String getShelfLife(){return this.shelfLife;}
    public void setShelfLife(String shelfLife){this.shelfLife = shelfLife;}

    public String getDepartment(){return this.department;}
    public void setDepartment(String department){this.department = department;}

    public Float getPrice(){return this.price;}
    public void setPrice(Float price){this.price = price;}

    public String getUnit(){return this.unit;}
    public void setUnit(String unit){this.unit = unit;}

    public Integer getXFor(){return this.xFor;}
    public void setXFor(Integer xFor){this.xFor = xFor;}

    public Float getCost(){return this.cost;}
    public void setCost(Float cost){this.cost = cost;}

    @Override
    public String toString(){
        final StringBuilder sb = new StringBuilder();
        sb.append("Grocery");
        sb.append("{id=").append(this.id);
        sb.append(", description='").append(this.description).append('\'');
        sb.append(", lastSold=").append(this.lastSold);
        sb.append(", shelfLife='").append(this.shelfLife).append('\'');
        sb.append(", department='").append(this.department).append('\'');
        sb.append(", price=").append(this.price);
        sb.append(", unit='").append(this.unit).append('\'');
        sb.append(", xFor=").append(this.xFor);
        sb.append(", cost=").append(this.cost);
        sb.append('}');
        return sb.toString();
    }
}
