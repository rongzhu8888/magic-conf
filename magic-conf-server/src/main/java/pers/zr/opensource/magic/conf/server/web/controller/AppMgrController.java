package pers.zr.opensource.magic.conf.server.web.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pers.zr.opensource.magic.conf.common.response.CommonDataResponse;
import pers.zr.opensource.magic.conf.common.response.CommonResponse;
import pers.zr.opensource.magic.conf.common.response.CommonResponseCode;
import pers.zr.opensource.magic.conf.server.module.AppVersionDuplicateException;
import pers.zr.opensource.magic.conf.server.module.app.AppDuplicateException;
import pers.zr.opensource.magic.conf.server.module.app.AppNotExistException;
import pers.zr.opensource.magic.conf.server.module.app.service.IAppMgrService;
import pers.zr.opensource.magic.conf.server.utils.ParamValidator;
import pers.zr.opensource.magic.conf.server.web.vo.req.AppReqVo;
import pers.zr.opensource.magic.conf.server.web.vo.req.AppVersionReqVo;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by zhurong on 2016-4-27.
 */
@RestController
@RequestMapping("/admin")
public class AppMgrController {

    private final Log log = LogFactory.getLog(AppMgrController.class);

    @Autowired
    private IAppMgrService appMgrService;


    @RequestMapping(value = "/apps", method = RequestMethod.POST)
    public CommonResponse createApp(@RequestBody @NotNull AppReqVo appReqVo) {
        CommonResponse response = ParamValidator.validate(appReqVo);
        if(null != response) {
            return response;
        }

        try{
            appMgrService.createApp(appReqVo.convert2Po());
            response = CommonResponse.buildSuccessResponse();

        } catch (AppDuplicateException e) {
            log.info("Failed to create app", e); //业务异常输出info级别的异常
            response = CommonResponse.buildErrorResponse(e.getCode(), "Failed to create app, caused by " + e.getMessage());
        } catch (Exception e) {
            log.error("Failed to create app", e); //程序内部错误输出error级别异常
            response = CommonResponse.buildErrorResponse(CommonResponseCode.SERVER_ERROR, "Failed to create app, caused by internal service error!");
        }
        return response;
    }

    @RequestMapping(value = "/apps", method = RequestMethod.PUT)
    public CommonResponse editApp(@RequestBody @NotNull AppReqVo appReqVo) {
        CommonResponse response = ParamValidator.validate(appReqVo);
        if(null != response) {
            return response;
        }

        try{
            appMgrService.editApp(appReqVo.convert2Po());
            response = CommonResponse.buildSuccessResponse();

        } catch (AppNotExistException e) {
            log.info("Failed to edit app", e); //业务异常输出info级别的异常
            response = CommonResponse.buildErrorResponse(e.getCode(), "Failed to edit app, caused by " + e.getMessage());
        } catch (Exception e) {
            log.error("Failed to edit app", e); //程序内部错误输出error级别异常
            response = CommonResponse.buildErrorResponse(CommonResponseCode.SERVER_ERROR, "Failed to edit app, caused by internal service error!");
        }
        return response;
    }

    @RequestMapping(value = "/apps/{appId}", method = RequestMethod.DELETE)
    public CommonResponse deleteApp(@PathVariable @NotNull @NotEmpty String appId) {
        CommonResponse response = ParamValidator.validate(appId);
        if(null != response) {
            return response;
        }

        try{
            appMgrService.deleteApp(appId);
            response = CommonResponse.buildSuccessResponse();

        } catch (AppNotExistException e) {
            log.info("Failed to delete app", e); //业务异常输出info级别的异常
            response = CommonResponse.buildErrorResponse(e.getCode(), "Failed to delete app, caused by " + e.getMessage());
        } catch (Exception e) {
            log.error("Failed to delete app", e); //程序内部错误输出error级别异常
            response = CommonResponse.buildErrorResponse(CommonResponseCode.SERVER_ERROR, "Failed to delete app, caused by internal service error!");
        }
        return response;
    }

    @RequestMapping(value = "/apps/{appId}/versions", method = RequestMethod.GET)
    public CommonDataResponse<List> getAppVersions(@PathVariable @NotNull @NotEmpty String appId) {
        CommonDataResponse<List> response = null;

        CommonResponse validateResult = ParamValidator.validate(appId);
        if(null != validateResult) {
            response = CommonDataResponse.buildErrorResponse(validateResult.getCode(), validateResult.getMessage());
            return response;
        }
        try{
            List<String> versionList = appMgrService.getAppVersions(appId);
            response = CommonDataResponse.buildSuccessResponse(versionList);

        } catch (AppNotExistException e) {
            log.info("Failed to get versions of app", e); //业务异常输出info级别的异常
            response = CommonDataResponse.buildErrorResponse(e.getCode(), "Failed to get versions of app, caused by " + e.getMessage());
        } catch (Exception e) {
            log.error("Failed to get versions of app", e); //程序内部错误输出error级别异常
            response = CommonDataResponse.buildErrorResponse(CommonResponseCode.SERVER_ERROR, "Failed to get versions of app, caused by internal service error!");
        }
        return response;
    }

    @RequestMapping(value = "/apps/versions", method = RequestMethod.POST)
    public CommonResponse createAppVersion(@RequestBody @NotNull AppVersionReqVo appVersionReqVo) {
        //validate parameter
        CommonResponse response = ParamValidator.validate(appVersionReqVo);
        if(null != response) {
            return response;
        }
        try{
            appMgrService.createAppVersion(appVersionReqVo.convert2Po());
            response = CommonResponse.buildSuccessResponse();

        } catch (AppVersionDuplicateException e) {
            log.info("Failed to create version of app", e); //业务异常输出info级别的异常
            response = CommonResponse.buildErrorResponse(e.getCode(), "Failed to create version of app, caused by " + e.getMessage());
        } catch (Exception e) {
            log.error("Failed to create version of app", e); //程序内部错误输出error级别异常
            response = CommonResponse.buildErrorResponse(CommonResponseCode.SERVER_ERROR, "Failed to create version of app, caused by internal service error!");
        }
        return response;
    }

}
