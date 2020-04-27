package com.yangluyao.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.yangluyao.springcloud.entities.CommonResult;

/**
 * @author YLY
 * @ClassName CustomerBlockHandler
 * @Date 2020/4/22
 * @Version 1.0.1
 */
public class CustomerBlockHandler {
    public static CommonResult handlerException(BlockException exception){
     return new CommonResult(4444,"按客户自定义exception-------1");
    }
    public static CommonResult handlerException2(BlockException exception){
        return new CommonResult(4444,"按客户自定义exception-------2");
    }
}
