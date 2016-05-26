package com.agyl.recyclergus.models;
/**
 * Created by rouguiatoudiallo on 16-05-23.
 */

public class DrawerListViewData {
    private int iconId;
    private String name;

    public DrawerListViewData(int iconId, String name) {
        this.iconId = iconId;
        this.name = name;
    }

    public int getIconId() {
        return iconId;
    }

    public String getName() {
        return name;
    }
}
