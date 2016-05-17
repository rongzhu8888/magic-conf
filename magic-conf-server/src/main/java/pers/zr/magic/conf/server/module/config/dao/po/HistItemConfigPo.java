package pers.zr.magic.conf.server.module.config.dao.po;

import pers.zr.magic.dao.annotation.Column;
import pers.zr.magic.dao.annotation.Table;

/**
 * Created by zhurong on 2016-5-16.
 */

@Table(name = "mc_config_item_his")
public class HistItemConfigPo extends ItemConfigPo {

    @Column(value = "item_value_last")
    private String itemLastValue;

    public String getItemLastValue() {
        return itemLastValue;
    }

    public void setItemLastValue(String itemLastValue) {
        this.itemLastValue = itemLastValue;
    }
}
