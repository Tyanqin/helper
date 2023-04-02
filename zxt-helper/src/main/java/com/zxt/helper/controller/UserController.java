package com.zxt.helper.controller;

import com.zxt.helper.Annotation.PassToken;
import com.zxt.helper.common.Biz.BaseController;
import com.zxt.helper.common.exception.login.UserNotExistException;
import com.zxt.helper.common.exception.login.UserPasswordException;
import com.zxt.helper.common.exception.param.ParamNullException;
import com.zxt.helper.common.msg.ObjectRestResponse;
import com.zxt.helper.common.utils.BaseAssert;
import com.zxt.helper.common.utils.RedisUtil;
import com.zxt.helper.common.utils.TokenDataSource;
import com.zxt.helper.common.utils.TokenEncryptUtils;
import com.zxt.helper.entity.User;
import com.zxt.helper.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:TanXiao
 * @date:2023/3/17
 */
@RestController
@RequestMapping("/user")
@Api(tags=" user  controller ")
public class UserController extends BaseController<UserService, User> {

    @PassToken
    @PostMapping("/reg")
    public ObjectRestResponse register(@RequestBody User user){
        Integer result = userService.register(user);
        return new ObjectRestResponse().data(result);
    }


    @PostMapping("/login")
    @ResponseBody
    @PassToken
    @ApiOperation(value = "根据用户名称与用户密码进行登录", notes = "请查看Models数据字典")
    public ObjectRestResponse login(@RequestBody  User user){
        BaseAssert.isNull(user.getUserName(), ParamNullException::new);
        BaseAssert.isNull(user.getPassword(), ParamNullException::new);
        //用户不存在
        User currentUser = userService.selectOne(new User().setUserName(user.getUserName()));
        BaseAssert.isNull(currentUser,UserNotExistException::new);
        //用户密码错误
        HashMap<String,Object> maps = userService.login(user.getUserName(),user.getPassword());
        BaseAssert.isEmpty(maps, UserPasswordException::new);
        return  new ObjectRestResponse().data(getStringObjectMap(maps));
    }

    @GetMapping("/list")
    @ResponseBody
    public ObjectRestResponse getUserAll(){
        return new ObjectRestResponse().data(userService.selectListAll());
    }


    private Map<String, Object> getStringObjectMap(Map<String,Object> map) {
        String token = TokenEncryptUtils.getToken(map);
        Map<String, Object> tokenMap = tokenDataSource.append("token", token).appendObject(map).build();
        redisUtil.hmset(String.valueOf(map.get("id")),tokenMap,60000);
        return tokenMap;
    }

    @Autowired
    private UserService userService;

    @Autowired
    private TokenDataSource tokenDataSource;

    @Autowired
    private RedisUtil redisUtil;


}
