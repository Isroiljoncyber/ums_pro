package uz.example.rakhmatillo.ums_pro.models;

public class ServiceData {
    private String name;
    private String description;
    private String myTag;

    public String getMyTag() {
        return myTag;
    }

    public ServiceData(String name, String description, String myTag) {
        this.name = name;
        this.description = description;
        this.myTag = myTag;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

}
