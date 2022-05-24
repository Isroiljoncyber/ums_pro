package uz.example.rakhmatillo.ums_pro.models;

import java.io.Serializable;

public abstract class BaseData implements Serializable {
    public static final int TYPE_BONUS=0;
    public static final int TYPE_DATA=1;
    public static final int TYPE_STRING=2;
    public static final int TYPE_BUTTON=3;
    public abstract int getType();
}
