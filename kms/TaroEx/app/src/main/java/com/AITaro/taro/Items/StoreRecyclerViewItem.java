package com.AITaro.taro.Items;

import com.AITaro.taro.Adapter.StoreSettingAdapter;

public class StoreRecyclerViewItem {
    private int StoreImage;
    private String StoreText;

    public StoreRecyclerViewItem(int resImage, String resText){
        StoreImage = resImage;
        StoreText = resText;
    }

    public int getStoreImage() {
        return this.StoreImage;
    }

    public void setStoreImage(int storeImage) {
        this.StoreImage = storeImage;
    }

    public String getStoreText() {
        return this.StoreText;
    }

    public void setStoreText(String storeText) {
        this.StoreText = storeText;
    }
}
