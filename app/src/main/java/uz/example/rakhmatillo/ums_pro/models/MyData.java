package uz.example.rakhmatillo.ums_pro.models;

public class MyData extends BaseData{
    private String name;
    private String cost;


    public String getMyTag() {
        return myTag;
    }

    private String myTag;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getCost() {
        return cost;
    }

    public MyData(String name, String cost, String myTag) {

        this.name = name;
        this.cost = cost;
        this.myTag = myTag;
    }

    @Override
    public int getType() {
        return TYPE_DATA;
    }
}
