package com.example.ankit.recyclerviewwithsearchview;

/**
 * Created by ankit on 17/9/17.
 */

public class Hero  {

    private String name;
    private int image_id;

    public Hero(String name,int image_id){
        this.setName(name);
        this.setImage_id(image_id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage_id() {
        return image_id;
    }

    public void setImage_id(int image_id) {
        this.image_id = image_id;
    }
}
