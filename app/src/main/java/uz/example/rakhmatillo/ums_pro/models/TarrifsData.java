package uz.example.rakhmatillo.ums_pro.models;

public class TarrifsData {
    int iconRes;
    String tarrifName;
    String tarrifDescription;
    String myTag;



    public String getMyTag() {
        return myTag;
    }

    public int getIconRes() {
        return iconRes;
    }

    public String getTarrifName() {
        return tarrifName;
    }

    public String getTarrifDescription() {
        return tarrifDescription;
    }

    public TarrifsData(int iconRes, String tarrifName, String tarrifDescription, String myTag) {

        this.iconRes = iconRes;
        this.tarrifName = tarrifName;
        this.tarrifDescription = tarrifDescription;
        this.myTag=myTag;
    }
}
