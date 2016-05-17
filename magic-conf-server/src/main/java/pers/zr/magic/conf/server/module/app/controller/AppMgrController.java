package pers.zr.magic.conf.server.module.app.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pers.zr.magic.conf.common.response.CommonDataResponse;
import pers.zr.magic.conf.common.response.CommonResponse;
import pers.zr.magic.conf.common.response.CommonResponseCode;
import pers.zr.magic.conf.server.module.app.dao.po.AppPo;
import pers.zr.magic.conf.server.module.app.service.IAppMgrService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhurong on 2016-4-27.
 */
@RestController
@RequestMapping("/app")
public class AppMgrController {

    private final Logger log = LogManager.getLogger(AppMgrController.class);

    @Autowired
    private IAppMgrService appMgrService;

    @RequestMapping(value = "/list")
    public CommonDataResponse<List<AppPo>> test() {

        Long start = System.currentTimeMillis();
        CommonDataResponse<List<AppPo>> response = new CommonDataResponse<>();
        try{
            response.setData(appMgrService.getAppList());
            response.setCode(CommonResponseCode.SUCCESS);
            log.info("test api call success");
        }catch (Exception e) {
            response.setCode(CommonResponseCode.SERVER_ERROR);
            response.setMessage("Failed to get app list: service internal error!");
            log.error("Fail to get app list", e);
        }
        long end = System.currentTimeMillis();
        log.info("costs " + (end-start) + " ms");
        return  response;
    }


    @RequestMapping(value = "create")
    public CommonResponse createApp() {
        AppPo appPo = new AppPo();
        appPo.setAppCode("hdb-qrf");
        appPo.setAppName("二维码发分");
        appPo.setGroupId(1000L);
        appMgrService.createApp(appPo);
        return CommonResponse.buildSuccessResponse();
    }


}
