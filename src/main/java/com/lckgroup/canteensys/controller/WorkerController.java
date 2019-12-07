package com.lckgroup.canteensys.controller;

import com.lckgroup.canteensys.service.OrdersService;
import com.lckgroup.canteensys.util.ControllerUtil;
import com.lckgroup.canteensys.vo.ResponseVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/worker")
@Api(tags = {"食堂工作人员操作"})
public class WorkerController {
    public static final Logger logger= LoggerFactory.getLogger(WorkerController.class);

    @Autowired
    private OrdersService ordersService;

    @ApiOperation(value = "查询订单",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "cusId", value = "顾客id", required = true)
    })
    @GetMapping("/checkOrder/{cusId}")
    public ResponseVO checkCustomerOrder(@PathVariable String cusId){
        return ControllerUtil.getDataResult(ordersService.findOrdersByCusId(cusId));
    }
}
