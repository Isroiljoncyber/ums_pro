package uz.example.rakhmatillo.ums_pro.models;

import java.io.Serializable;

public class MyDataBonus extends BaseData implements Serializable{
    private String name;
    private String cost;
    private String bonus;
    private String myTag;

    public String getMyTag() {
        return myTag;
    }

    public void setMyTag(String myTag) {
        this.myTag = myTag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getBonus() {
        return bonus;
    }

    public void setBonus(String bonus) {
        this.bonus = bonus;
    }

    public MyDataBonus(String name, String cost, String bonus, String myTag) {
        this.name = name;
        this.cost = cost;
        this.bonus = bonus;
        this.myTag = myTag;
    }

    @Override
    public int getType() {
        return TYPE_BONUS;
    }
}