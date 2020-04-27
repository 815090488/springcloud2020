package com.yangluyao.springcloud.service.impl;

import com.yangluyao.springcloud.dao.StorageDao;
import com.yangluyao.springcloud.service.StorageService;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;

@Service
public class StorageServiceImpl implements StorageService {

    @Resource
    private StorageDao storageDao;

    @Override
    public void decrease(Long productId, Integer count) {
        storageDao.decrease(productId, count);
    }

}
