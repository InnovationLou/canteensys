package com.lckgroup.canteensys.controller;

import com.lckgroup.canteensys.entity.Customer;
import com.lckgroup.canteensys.entity.Dish;
import com.lckgroup.canteensys.entity.Orders;
import com.lckgroup.canteensys.service.DishService;
import com.lckgroup.canteensys.service.OrdersService;
import com.lckgroup.canteensys.service.WorkerService;
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
@CrossOrigin
@RequestMapping("/worker")
@Api(tags = {"食堂工作人员操作"})
public class WorkerController {
    public static final Logger logger= LoggerFactory.getLogger(WorkerController.class);

    @Autowired
    private OrdersService ordersService;
    @Autowired
    private DishService dishService;

    @ApiOperation(value = "管理人员查看当日所有在售菜品",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sellingWeekDay", value = "sellingWeekDay", required = true)
    })
    @GetMapping("/Dish/findTodayDish")
    public ResponseVO findTodayDish(Integer sellingWeekDay){
        List<Dish> dishList = dishService.findTodayDish(sellingWeekDay);
        if(dishList.isEmpty()){
            return ControllerUtil.getFalseResultMsgBySelf(RespCode.MSG_NOT_FOUND_DATA);
        }
        return ControllerUtil.getDataResult(dishList);
    }

    @ApiOperation(value = "管理人员查看所有菜品(在售与不在售)",httpMethod = "GET")
    @GetMapping("/Dish/findDish")
    public ResponseVO findDish(){
        List<Dish> dishList = dishService.findDish();
        if(dishList.isEmpty()){
            return ControllerUtil.getFalseResultMsgBySelf(RespCode.MSG_NOT_FOUND_DATA);
        }
        return ControllerUtil.getDataResult(dishList);
    }

    @ApiOperation(value = "创建新菜",httpMethod = "POST" )
    @PostMapping("/createDish")
    public ResponseVO createDish(Dish dish){
        return ControllerUtil.getSuccessResultBySelf(workerService.CreateDish(dish));
    }

    @Autowired
    private  WorkerService workerService;

    @ApiOperation(value = "通过dishId下架菜",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "dishId", value = "dishId", required = true)
    })
    @GetMapping("/Dish/downDish/{dishId}")
    public @ResponseBody
    ResponseVO<Object> downDish(@PathVariable Long dishId) {
        Dish dish = workerService.findByDishId(dishId);
        if (dish == null) {
            return ControllerUtil.getFalseResultMsgBySelf(RespCode.MSG_NOT_FOUND_DATA);
        } else {
            dish.setSelling(false);
            return ControllerUtil.getDataResult(workerService.reviseDish(dish));
        }
    }

    @ApiOperation(value = "通过dishId上架菜",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "dishId", value = "dishId", required = true),
    })
    @GetMapping("/Dish/{dishId}")
    public @ResponseBody
    ResponseVO<Object> upDish(@PathVariable Long dishId) {
        Dish dish = workerService.findByDishId(dishId);
        if (dish == null) {
            return ControllerUtil.getFalseResultMsgBySelf(RespCode.MSG_NOT_FOUND_DATA);
        } else {
            dish.setSelling(true);
            return ControllerUtil.getDataResult(workerService.reviseDish(dish));
        }
    }

    @ApiOperation(value = "修改某个菜的供应量来加菜",httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "dishId", value = "菜的id", required = true),
            @ApiImplicitParam(name = "remainNum", value = "加菜数量", required = true)
    })
    @PostMapping(path = "/Dish/reviseDishNum")
    public @ResponseBody
    ResponseVO<Object> reviseDishNum(@PathVariable Long dishId,@PathVariable Integer remainNum) {
        Dish dish = workerService.findByDishId(dishId);
        if (dish == null) {
            return ControllerUtil.getFalseResultMsgBySelf(RespCode.MSG_NOT_FOUND_DATA);
        } else {
            dish.setRemainNum(remainNum);
            return ControllerUtil.getDataResult(workerService.reviseDish(dish));
        }
    }



    @ApiOperation(value = "修改某个菜的数据",httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "dishId", value = "菜的id", required = true),
            @ApiImplicitParam(name = "disIntro", value = "介绍"),
            @ApiImplicitParam(name = "dishName", value = "菜名"),
            @ApiImplicitParam(name = "dishPic", value = "图片"),
            @ApiImplicitParam(name = "dishPrice", value = "价格"),
            @ApiImplicitParam(name = "dishType", value = "种类"),
            @ApiImplicitParam(name = "isSelling", value = "是否在售"),
            @ApiImplicitParam(name = "remainNum", value = "剩余量"),
            @ApiImplicitParam(name = "soldNum", value = "销售量"),
            @ApiImplicitParam(name = "starRate", value = "评价星级")
    })
    @PostMapping(path = "/reviseDish")
    public @ResponseBody
    ResponseVO<Object> reviseDish(Long dishId,String dishIntro,String dishName,String dishPic,Float dishPrice,Integer dishWindow,
    Boolean isSelling,Integer remainNum,Integer sellWeekDay
    ) {
        Dish dish = workerService.findByDishId(dishId);
        if (dish == null) {
            return ControllerUtil.getFalseResultMsgBySelf(RespCode.MSG_NOT_FOUND_DATA);
        } else {
            dish.setRemainNum(remainNum);
            dish.setDishIntro(dishIntro);
            dish.setDishName(dishName);
            dish.setDishPic(dishPic);
            dish.setDishPrice(dishPrice);
            dish.setDishWindow(dishWindow);
            dish.setSelling(isSelling);
            dish.setRemainNum(remainNum);
            dish.setSellWeekDay(sellWeekDay);
            return ControllerUtil.getDataResult(workerService.reviseDish(dish));
        }
    }




    @ApiOperation(value = "通过顾客id查询订单",httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "cusId", value = "顾客id", required = true)
    })
    @GetMapping("/checkOrder/{cusId}")
    public ResponseVO checkCustomerOrder(@PathVariable String cusId){
        return ControllerUtil.getDataResult(ordersService.findOrdersByCusId(cusId));
    }


    @ApiOperation(value = "查找被投诉的订单", httpMethod = "GET")
    @GetMapping("/workerOrder/customerOrder")
    public ResponseVO findByIsDone(){
        List<Orders> ordersList = workerService.findByIsDoneTrue();
        if(ordersList.isEmpty()){
            return ControllerUtil.getFalseResultMsgBySelf(RespCode.MSG_NOT_FOUND_DATA);
        }
        return ControllerUtil.getDataResult(ordersList);
    }



    @ApiOperation(value = "修改订单准备就绪状态",httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "cusId", value = "顾客id", required = true)
    })
    @PostMapping(path = "/workerOrder/reviseOrdersReady")
    public @ResponseBody
    ResponseVO<Object> reviseOrdersReady(@RequestParam("cusId") String cusId) {
        List<Orders> ordersList = ordersService.findOrdersByCusId(cusId);
        if(ordersList.isEmpty()){
            return ControllerUtil.getFalseResultMsgBySelf(RespCode.MSG_NOT_FOUND_DATA);
        }else{
            for(Orders orders:ordersList){
                orders.setReady(true);
                workerService.reviseOrders(orders);
            }
        }
        return ControllerUtil.getDataResult(ordersList);
        }

    @ApiOperation(value = "修改订单支付状态",httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "orderId", value = "订单id", required = true)
    })
    @PostMapping(path = "/workerOrder/reviseOrdersPaid")
    public @ResponseBody
    ResponseVO<Object> reviseOrdersPaid(String orderId) {
        List<Orders> ordersList = ordersService.findOrdersByCusId(orderId);
        if(ordersList.isEmpty()){
            return ControllerUtil.getFalseResultMsgBySelf(RespCode.MSG_NOT_FOUND_DATA);
        }else{
            for(Orders orders:ordersList){
                orders.setPaid(true);
                workerService.reviseOrders(orders);
            }
        }
        return ControllerUtil.getDataResult(ordersList);
    }



    }



