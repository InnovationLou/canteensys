package com.lckgroup.canteensys.controller;

import com.lckgroup.canteensys.util.ControllerUtil;
import com.lckgroup.canteensys.util.constant.RespCode;
import com.lckgroup.canteensys.vo.ResponseVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/user")
@Api(tags = {"顾客登录接口"})
@CrossOrigin
public class UserController {
    Logger logger= LoggerFactory.getLogger(UserController.class);

    @ApiOperation(value = "用户登录接口", notes = "使用其他接口前必须先登录", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "201702971", required = true, paramType = "query"),
            @ApiImplicitParam(name = "password", value = "123456", required = true, paramType = "query"),
    })
    @PostMapping("/login")
    public ResponseVO login(String username,String password){
        Subject subject= SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken(username,password);
        try {
            subject.login(token);
            return ControllerUtil.getSuccessResultBySelf("登录成功");
        }   catch (Exception e) {
            logger.error(e.toString());
            return ControllerUtil.getFalseResultMsgBySelf(RespCode.MSG_UNKNOWN_ERROR);
        }
    }
}
