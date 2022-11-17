package com.example.service.service;

import com.example.service.entity.StuContact;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author testjava
 * @since 2022-10-26
 */
public interface StuContactService extends IService<StuContact> {
        List<StuContact> getAll();

}
