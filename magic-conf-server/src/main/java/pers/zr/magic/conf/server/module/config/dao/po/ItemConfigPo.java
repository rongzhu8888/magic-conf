package pers.zr.magic.conf.server.module.config.dao.po;

import pers.zr.magic.dao.annotation.Column;
import pers.zr.magic.dao.annotation.Table;

/**
 * Created by zhurong on 2016-5-16.
 */
@Table(name = "mc_config_item")
public class ItemConfigPo extends ConfigCommon {

    @Column(value = "item_key")
    private String itemKey;

    @Column(value = "item_value")
    private String itemValue;

    public String getItemKey() {
        return itemKey;
    }

    public void setItemKey(String itemKey) {
        this.itemKey = itemKey;
    }

    public String getItemValue() {
        return itemValue;
    }

    public void setItemValue(String itemValue) {
        this.itemValue = itemValue;
    }
}
