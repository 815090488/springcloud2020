package com.yangluyao.springcloud.service.impl;

import com.yangluyao.springcloud.dao.OrderDao;
import com.yangluyao.springcloud.domain.Order;
import com.yangluyao.springcloud.service.AccountService;
import com.yangluyao.springcloud.service.OrderService;
import com.yangluyao.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;

/**
 * 创建订单-> 调用库存服务器扣减库存->调用账户服务扣减账户余额->修改订单状态
 *
 * 下订单->减库存->减余额->该状态
 * @author 81509
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;
    @Resource
    private AccountService accountService;
    @Resource
    private StorageService storageService;

    @Override
    @GlobalTransactional(name = "fsp-create-order",rollbackFor = Exception.class)
    public void create(Order order) {
        log.info("--------->开始新建订单");
        //1 新建订单
        orderDao.create(order);


        //2 扣减库存
        log.info("------------->订单微服务开始调用库存,做扣减Count");
        storageService.decrease(order.getProductId(), order.getCount());
        log.info("------------->订单微服务开始调用库存,做扣减end");


        //3 扣减账户
        log.info("------------->订单微服务开始调用账户,做扣减Money");
        accountService.decrease(order.getUserId(), order.getMoney());
        log.info("------------->订单微服务开始调用账户,做扣减end");


        //4 修改订单状态
        log.info("------------->修改订单状态开始");
        orderDao.update(order.getUserId(),0);
        log.info("------------->修改订单状态结束");

        log.info("------------->下订单结束了");
    }
}
