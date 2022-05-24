package uz.example.rakhmatillo.ums_pro.models;

public class ButtonData extends BaseData {
    private String text;
    private String myTag;

    public ButtonData(String text, String myTag) {
        this.text = text;
        this.myTag = myTag;
    }

    public String getMyTag() {
        return myTag;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


    @Override
    public int getType() {
        return TYPE_BUTTON;
    }
}
