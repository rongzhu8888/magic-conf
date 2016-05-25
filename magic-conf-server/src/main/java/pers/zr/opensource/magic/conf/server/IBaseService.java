package pers.zr.opensource.magic.conf.server;

import java.util.List;

/**
 * Created by zhurong on 2016-5-25.
 */
public interface IBaseService<ENTITY> {

    public List<ENTITY> getEntityList();


}
