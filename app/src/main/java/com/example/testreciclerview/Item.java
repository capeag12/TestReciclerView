package com.example.testreciclerview;

import android.graphics.drawable.Drawable;
//La clase Item será como un 'componente', el cual contendrá el recyclerView. Le especificaremos información como texto o imagen
public class Item {
    private Drawable imageSRC;
    private String name;


    public Item(Drawable imageSRC, String name) {
        this.imageSRC = imageSRC;
        this.name = name;

    }

    public Drawable getImageSRC() {
        return imageSRC;
    }

    public void setImageSRC(Drawable imageSRC) {
        this.imageSRC = imageSRC;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
