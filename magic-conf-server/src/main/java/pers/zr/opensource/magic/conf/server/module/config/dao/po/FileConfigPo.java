package pers.zr.opensource.magic.conf.server.module.config.dao.po;

import pers.zr.opensource.magic.dao.annotation.Column;
import pers.zr.opensource.magic.dao.annotation.Key;
import pers.zr.opensource.magic.dao.annotation.Table;

/**
 * Created by zhurong on 2016-5-16.
 */
@Table(name = "mc_config_file")
public class FileConfigPo extends ConfigCommon {

    @Key(column = "config_id", autoIncrement = true)
    private Long configId;

    @Column(value = "file_name")
    private String fileName;

    @Column(value = "file_content")
    private String fileContent;

    public Long getConfigId() {
        return configId;
    }

    public void setConfigId(Long configId) {
        this.configId = configId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileContent() {
        return fileContent;
    }

    public void setFileContent(String fileContent) {
        this.fileContent = fileContent;
    }
}
