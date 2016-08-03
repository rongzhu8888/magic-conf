package pers.zr.opensource.magic.conf.server.web.controller;

/**
 * Created by zhurong on 2016-5-24.
 */

import com.google.common.collect.Lists;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import pers.zr.opensource.magic.conf.common.response.CommonDataResponse;
import pers.zr.opensource.magic.conf.common.response.CommonResponse;
import pers.zr.opensource.magic.conf.common.response.CommonResponseCode;
import pers.zr.opensource.magic.conf.server.module.profile.ProfileDuplicateException;
import pers.zr.opensource.magic.conf.server.module.profile.ProfileNotExistException;
import pers.zr.opensource.magic.conf.server.module.profile.dao.po.ProfilePo;
import pers.zr.opensource.magic.conf.server.module.profile.service.IProfileMgrService;
import pers.zr.opensource.magic.conf.server.utils.ParamValidator;
import pers.zr.opensource.magic.conf.server.web.vo.req.ProfileReqVo;
import pers.zr.opensource.magic.conf.server.web.vo.res.ProfileResVo;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/admin")
public class ProfileMgrController {

    @Autowired
    private IProfileMgrService profileMgrService;

    private final Log log = LogFactory.getLog(ProfileMgrController.class);

    @RequestMapping(value = "/profiles", method = RequestMethod.POST)
    public CommonResponse createProfile(@NotNull @RequestBody ProfileReqVo profileReqVo) {
        CommonResponse response = ParamValidator.validate(profileReqVo);
        if(response != null) {
            return response;
        }
        try{

            ProfilePo profilePo = profileReqVo.convert2Po();
            profileMgrService.createProfile(profilePo);
            response = CommonResponse.buildSuccessResponse();

        }catch (ProfileDuplicateException e) {
            log.info("Failed to create profile", e); //业务异常输出info级别的异常
            response = CommonResponse.buildErrorResponse(e.getCode(), "Failed to create profile, caused by " + e.getMessage());
        } catch (Exception e) {
            log.error("Failed to create profile", e); //程序内部错误输出error级别异常
            response = CommonResponse.buildErrorResponse(CommonResponseCode.SERVER_ERROR, "Failed to create profile, caused by internal service error!");
        }
        return response;
    }

    @RequestMapping(value = "/profiles", method = RequestMethod.PUT)
    public CommonResponse editProfile(@NotNull @RequestBody ProfileReqVo profileReqVo) {
        //validate parameters
        CommonResponse response = ParamValidator.validate(profileReqVo);
        if(response != null) {
            return response;
        }
        try{
            ProfilePo profilePo = profileReqVo.convert2Po();
            profileMgrService.editProfile(profilePo);
            response = CommonResponse.buildSuccessResponse();

        }catch (ProfileNotExistException e) {
            log.info("Failed to edit profile", e); //业务异常输出info级别的异常
            response = CommonResponse.buildErrorResponse(e.getCode(), "Failed to edit profile, caused by " + e.getMessage());
        } catch (Exception e) {
            log.error("Failed to edit profile", e); //程序内部错误输出error级别异常
            response = CommonResponse.buildErrorResponse(CommonResponseCode.SERVER_ERROR, "Failed to edit profile, caused by internal service error!");
        }
        return response;
    }


    @RequestMapping(value = "/profiles/{profileId}", method = RequestMethod.DELETE)
    public CommonResponse deleteProfile(@NotNull @PathVariable String profileId) {
        //validate parameters
        CommonResponse response = ParamValidator.validate(profileId);
        if(response != null) {
            return response;
        }
        try{

            profileMgrService.deleteProfile(profileId);
            response = CommonResponse.buildSuccessResponse();
        }catch (ProfileNotExistException e) {
            log.info("Failed to delete profile", e); //业务异常输出info级别的异常
            response = CommonResponse.buildErrorResponse(e.getCode(), "Failed to delete profile, caused by " + e.getMessage());
        } catch (Exception e) {
            log.error("Failed to delete profile", e); //程序内部错误输出error级别异常
            response = CommonResponse.buildErrorResponse(CommonResponseCode.SERVER_ERROR, "Failed to delete profile, caused by internal service error!");
        }
        return response;
    }

    @RequestMapping(value = "/profiles", method = RequestMethod.GET)
    public CommonDataResponse<List<ProfileResVo>> getProfileList() {
        CommonDataResponse<List<ProfileResVo>> response;
        try{
            List<ProfilePo> profilePoList = profileMgrService.getProfileList();
            List<ProfileResVo> profileResVoList = Lists.newArrayList();
            if(!CollectionUtils.isEmpty(profilePoList)) {
                profileResVoList.addAll(profilePoList.stream().map(this::convert2Vo).collect(Collectors.toList()));
            }
            response = CommonDataResponse.buildSuccessResponse(profileResVoList);
        }catch (Exception e) {
            log.error("Failed to get profile list", e);//程序内部错误输出error级别异常
            response = CommonDataResponse.buildErrorResponse(CommonResponseCode.SERVER_ERROR, "Failed to get profile list, caused by service internal error!");
        }
        return response;
    }

    @RequestMapping(value = "/profiles/{profileId}", method = RequestMethod.GET)
    public CommonDataResponse<ProfileResVo> getProfile(@NotNull @PathVariable String profileId) {
        CommonResponse validateRes = ParamValidator.validate(profileId);
        if(validateRes != null) {
            return CommonDataResponse.buildErrorResponse(validateRes.getCode(), validateRes.getMessage());
        }

        try{
            ProfilePo profilePo = profileMgrService.getProfile(profileId);
            return CommonDataResponse.buildSuccessResponse(convert2Vo(profilePo));
        }catch (Exception e) {
            log.error("Failed to get profile list", e);//程序内部错误输出error级别异常
            return CommonDataResponse.buildErrorResponse(CommonResponseCode.SERVER_ERROR, "Failed to get profile, caused by service internal error!");
        }
    }


    private ProfileResVo convert2Vo(ProfilePo profilePo) {
        ProfileResVo vo = null;
        if(null != profilePo) {
            vo = new ProfileResVo();
            vo.setProfileId(profilePo.getProfileId());
            vo.setProfileName(profilePo.getProfileName());
            vo.setCreateTime(profilePo.getCreateTime());
            vo.setUpdateTime(profilePo.getUpdateTime());
        }
        return vo;
    }

}
