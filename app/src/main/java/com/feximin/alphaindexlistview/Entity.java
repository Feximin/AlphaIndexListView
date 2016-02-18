package com.feximin.alphaindexlistview;

/**
 * Created by Neo on 16/2/18.
 */
public class Entity implements AlphaIndexAble {

    private String name;

    public Entity(String name) {
        this.name = name;
    }

    @Override
    public String getAlpha() {
        return Tool.convertFirstAlpha(name);
    }

    @Override
    public String getAbbr() {
        return Tool.getAbbr(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
