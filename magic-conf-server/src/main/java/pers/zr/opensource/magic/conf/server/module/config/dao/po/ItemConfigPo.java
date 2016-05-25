package pers.zr.opensource.magic.conf.server.module.config.dao.po;

import pers.zr.opensource.magic.dao.annotation.Column;
import pers.zr.opensource.magic.dao.annotation.Key;
import pers.zr.opensource.magic.dao.annotation.Table;

/**
 * Created by zhurong on 2016-5-16.
 */
@Table(name = "mc_config_item")
public class ItemConfigPo extends ConfigCommon {

    @Key(column = "config_id", autoIncrement = true)
    private Long configId;

    @Column(value = "item_key")
    private String itemKey;

    @Column(value = "item_value")
    private String itemValue;

    public Long getConfigId() {
        return configId;
    }

    public void setConfigId(Long configId) {
        this.configId = configId;
    }

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
