package com.qianfeng.order.controller;

import com.qianfeng.Price.DTO.QueryChart;
import com.qianfeng.Price.VO.ReturnCart;
import com.qianfeng.Price.service.IPriceService;
import com.qianfeng.commons.DTO.Messages;
import com.qianfeng.commons.constant.URL;
import com.qianfeng.order.DTO.OrderIdList;
import com.qianfeng.order.DTO.ReceiveOrder;
import com.qianfeng.order.PO.TbChit;
import com.qianfeng.order.PO.TbOrder;
import com.qianfeng.order.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/Order")
public class OrderController {

    @Autowired
    private IOrderService service;
    @Autowired
    private IPriceService Pservice;

    @RequestMapping("/HelloOrder")
    @ResponseBody
    public List HelloOrder(){
        List list = new ArrayList();
        list.add(1);
        return list;
    }

    @RequestMapping("/OrderInfo/{userId}")
    @ResponseBody
    public List getOrderInfo(@PathVariable("userId") int userId){
        ArrayList list = new ArrayList();
        QueryChart chart = Pservice.queryCartNum(userId);
        List<ReturnCart> returnCarts = Pservice.queryCartInfo(userId);
        list.add(chart);
        list.add(returnCarts);
        return list;
    }

    @RequestMapping("/getOrder")
    public String getOrder(ReceiveOrder receiveOrder, String validate_code, HttpSession session,HttpServletRequest request){
        //获取ID
        int userId = receiveOrder.getUserId();
        //修改冻结金额
        QueryChart chart = Pservice.queryCartNum(userId);
        service.updateFrozenMoney(chart.getCart_total(),userId);
        //通过用户ID查询所有订单ID
        List<OrderIdList> orderIdLists = service.checkOrderIdList(userId);
        //将ReceiveOrder转化为TbOrder
        orderIdLists.forEach((d)->{
            //提交（修改）订单
            TbOrder tbOrder = new TbOrder(receiveOrder);
            tbOrder.setOrderId(d.getOrderId());
            service.updateOrder(tbOrder);
        });
        if("y".equals(receiveOrder.getIfbaoxian())){
            if(receiveOrder.getBaoxian_name()!=null&&receiveOrder.getBaoxian_name().length()>0&&
                    receiveOrder.getBaoxian_card_id()!=null&&receiveOrder.getBaoxian_card_id().length()>0){
                TbChit chit = new TbChit();
                chit.setUserId(userId);
                chit.setBaoxian_name(receiveOrder.getBaoxian_name());
                chit.setBaoxian_card_id(receiveOrder.getBaoxian_card_id());
                service.addBaodan(chit);
            }
        }
        Messages msg = (Messages) session.getAttribute(validate_code);
        msg.setOrderList(orderIdLists);
        session.setAttribute(validate_code,msg);
        return "redirect:"+ URL.getBaseURL(request)+"html/order-success.html";
    }

    @RequestMapping("/success/{key}")
    @ResponseBody
    public List toSuccessPage(@PathVariable("key") String key,HttpSession session){
        List list = new ArrayList();
        Messages msg = (Messages) session.getAttribute(key);
        //获取订单Id
        String orderIds = "";
        List<OrderIdList> orderList = msg.getOrderList();
        String AAA ="";
        for(OrderIdList o:orderList){
            orderIds += (AAA+o.getOrderId());
            AAA = ",";
        }
        list.add(orderIds);
        //获取交易方式
        TbOrder order = service.queryOrder(orderList.get(0).getOrderId());
        String model = order.getOrderModel();
        String text = "";
        switch (model){
            case "n":{
                text = "麦淘乐将对您的银行卡（"+order.getOrderInfo().split("-")[2]+"）创建付款，付款后可在银行交易记录中查看本交易";
                model = "官方担保交易";
            }break;
            case "y":{
                text = "麦淘乐将对您的支付宝账号（"+order.getOrderInfo().split("-")[1]+"）创建付款，付款后可在支付宝交易记录中查看本交易";
                model = "支付宝交易";
            }break;
            case "s":{
                text = "质检师会在指定时间到达指定地点跟您交易";
                model = "上门现金交易";
            }break;
        }
        list.add(model);
        list.add(text);
        return list;
    }
}
