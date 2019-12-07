package com.lckgroup.canteensys.controller;

import com.lckgroup.canteensys.entity.Customer;
import com.lckgroup.canteensys.entity.Dish;
import com.lckgroup.canteensys.entity.Orders;
import com.lckgroup.canteensys.service.CustomerService;
import com.lckgroup.canteensys.service.OrdersService;
import com.lckgroup.canteensys.util.ControllerUtil;
import com.lckgroup.canteensys.util.constant.RespCode;
import com.lckgroup.canteensys.vo.ResponseVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//解决ajax跨域问题
@CrossOrigin
@RequestMapping("/customer")
@Api(tags ={"顾客操作"})
public class CustomerController {

    public static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private CustomerService customerService;

    @Autowired
    private OrdersService ordersService;

    @ApiOperation(value = "通过卡号获得顾客", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "cusId", value = "卡号", required = true)
    })
    @GetMapping("/{cusId}")
    public ResponseVO findByCusId(@PathVariable String cusId){
        Customer customer = customerService.findByCusId(cusId);
        if(customer==null){
            return ControllerUtil.getFalseResultMsgBySelf(RespCode.MSG_NOT_FOUND_DATA);
        }
        customer.setCusPwd("");
        return ControllerUtil.getDataResult(customer);
    }

    @ApiOperation(value = "创建新顾客",httpMethod = "POST" )
    @PostMapping("/create")
    public ResponseVO createCustomer(Customer customer){
        return ControllerUtil.getSuccessResultBySelf(customerService.createCustomer(customer));
    }

    @ApiOperation(value = "查看所有顾客信息",httpMethod = "GET")
    @GetMapping("/allCustomer")
    public ResponseVO findAllCustomer(){
        List<Customer> cusList = customerService.findAllCustomer();
        if(cusList.isEmpty()){
            return ControllerUtil.getFalseResultMsgBySelf(RespCode.MSG_NOT_FOUND_DATA);
        }
        for(Customer customer:cusList){
            customer.setCusPwd("");
        }
        return ControllerUtil.getDataResult(cusList);
    }

    @ApiOperation(value = "顾客查看当日出售所有菜品",httpMethod = "GET")
    @GetMapping("/allDish")
    public ResponseVO findAllDish(){
        List<Dish> dishList = customerService.findAllDish();
        if(dishList.isEmpty()){
            return ControllerUtil.getFalseResultMsgBySelf(RespCode.MSG_NOT_FOUND_DATA);
        }
        return ControllerUtil.getDataResult(dishList);
    }

    @ApiOperation(value = "通过卡号查看订单",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "cusId", value = "卡号", required = true)
    })
    @GetMapping("/customerOrder/{cusId}")
    public ResponseVO findAll(@PathVariable String cusId){
        List<Orders> ordersList = ordersService.findOrdersByCusId(cusId);
        if(ordersList.isEmpty()){
            return ControllerUtil.getFalseResultMsgBySelf(RespCode.MSG_NOT_FOUND_DATA);
        }
        return ControllerUtil.getDataResult(ordersList);
    }
}
