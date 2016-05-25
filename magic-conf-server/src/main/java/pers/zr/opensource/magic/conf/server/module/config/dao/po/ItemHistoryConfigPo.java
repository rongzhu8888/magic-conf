package pers.zr.opensource.magic.conf.server.module.config.dao.po;

import pers.zr.opensource.magic.dao.annotation.Column;
import pers.zr.opensource.magic.dao.annotation.Key;
import pers.zr.opensource.magic.dao.annotation.Table;

/**
 * Created by zhurong on 2016-5-16.
 */

@Table(name = "mc_config_item_his")
public class ItemHistoryConfigPo extends ConfigCommon {

    @Key(column = "config_id")
    private Long configId;

    @Column(value = "item_key")
    private String itemKey;

    @Column(value = "item_value")
    private String itemValue;

    @Column(value = "item_value_last")
    private String itemLastValue;

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

    public String getItemLastValue() {
        return itemLastValue;
    }

    public void setItemLastValue(String itemLastValue) {
        this.itemLastValue = itemLastValue;
    }
}
