package com.example.service.service;

import com.example.service.entity.StuBasic;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author testjava
 * @since 2022-10-24
 */
public interface StuBasicService extends IService<StuBasic> {

   List<StuBasic> getAll();
}
