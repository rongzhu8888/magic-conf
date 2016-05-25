package pers.zr.opensource.magic.conf.server.module.menu.service;

import pers.zr.opensource.magic.conf.server.constants.MenuItemType;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zhurong on 2016-5-25.
 */
public class MenuItem implements Serializable {

    private String id;

    private String label;

    private List<MenuItem> children;

    private MenuItemType type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<MenuItem> getChildren() {
        return children;
    }

    public void setChildren(List<MenuItem> children) {
        this.children = children;
    }

    public MenuItemType getType() {
        return type;
    }

    public void setType(MenuItemType type) {
        this.type = type;
    }
}
