package com.optus.optusuidemo;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.graphics.Color;

/**
 * Created by nick on 16/8/8.
 */

public class UserData extends BaseObservable {
    private String itemPanleText;
    private int btnColor;

    public UserData() {
        this.itemPanleText = "";
        this.btnColor = Color.RED;
    }

    @Bindable
    public String getItemPanleText() {
        return itemPanleText;
    }

    public void setItemPanleText(String itemPanleText) {
        this.itemPanleText = itemPanleText;
        notifyPropertyChanged(BR.itemPanleText);
    }

    @Bindable
    public int getBtnColor() {
        return btnColor;
    }

    public void setBtnColor(int btnColor) {
        this.btnColor = btnColor;
        notifyPropertyChanged(BR.btnColor);
    }
}
