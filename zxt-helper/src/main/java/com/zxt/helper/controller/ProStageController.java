package com.zxt.helper.controller;

import com.zxt.helper.common.Biz.BaseController;
import com.zxt.helper.entity.ProStage;
import com.zxt.helper.service.ProStageService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author:TanXiao
 * @date:2023/3/30
 */
@RestController
@RequestMapping("/pro")
@Api(tags=" 项目阶段API ")
public class ProStageController extends BaseController<ProStageService, ProStage> {
}
