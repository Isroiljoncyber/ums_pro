package uz.example.rakhmatillo.ums_pro.models;

public class StringData extends BaseData {
    private String text;

    public StringData(String text, String myTag) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public int getType() {
        return TYPE_STRING;
    }
}
