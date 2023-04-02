package com.zxt.helper.controller;

import com.zxt.helper.common.Biz.BaseController;
import com.zxt.helper.entity.User;
import com.zxt.helper.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author:TanXiao
 * @date:2023/3/17
 */
@RestController
@RequestMapping("/dept")
@Api(tags=" dept  controller ")
public class DeptController extends BaseController<UserService, User> {


}
