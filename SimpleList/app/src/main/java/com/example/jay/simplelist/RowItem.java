package com.example.jay.simplelist;

/**
 * Created by jay on 9/24/16.
 */
public class RowItem {

    private int ImageId;
    private String carModelString;

    public RowItem(int imageId,String carModelString)
    {
        this.ImageId=imageId;
        this.carModelString=carModelString;
    }

    public int getImageId()
    {
        return ImageId;
    }

    public String getCarModelString()
    {
        return carModelString;
    }

}
