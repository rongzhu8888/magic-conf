package pers.zr.opensource.magic.conf.server.web.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pers.zr.opensource.magic.conf.common.response.CommonDataResponse;
import pers.zr.opensource.magic.conf.common.response.CommonResponseCode;
import pers.zr.opensource.magic.conf.server.module.menu.service.IMenuService;
import pers.zr.opensource.magic.conf.server.module.menu.service.MenuItem;

import java.util.List;

/**
 * Created by zhurong on 2016-4-27.
 */

@RestController
@RequestMapping("/admin")
public class MenuController {

    @Autowired
    private IMenuService menuService;

    private Logger log = LogManager.getLogger(MenuController.class);

    //顶部应用菜单

    @RequestMapping(value = "/menus", method = RequestMethod.GET)
    public CommonDataResponse<List<MenuItem>> getMenus() {

        CommonDataResponse<List<MenuItem>> response = null;
        try{
            response = CommonDataResponse.buildSuccessResponse(menuService.getMenus());
        } catch (Exception e) {
            log.error("Failed to get menus", e); //程序内部错误输出error级别异常
            response = CommonDataResponse.buildErrorResponse(CommonResponseCode.SERVER_ERROR, "Failed to get menus, caused by internal service error!");
        }

        return response;
    }



}
