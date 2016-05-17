package pers.zr.magic.conf.server.module.config.dao.po;

import pers.zr.magic.dao.annotation.Column;
import pers.zr.magic.dao.annotation.Table;

/**
 * Created by zhurong on 2016-5-16.
 */
@Table(name = "mc_config_file_his")
public class HistFileConfigPo extends FileConfigPo {

    @Column(value = "file_content_last")
    private String fileLastContent;

    public String getFileLastContent() {
        return fileLastContent;
    }

    public void setFileLastContent(String fileLastContent) {
        this.fileLastContent = fileLastContent;
    }
}
