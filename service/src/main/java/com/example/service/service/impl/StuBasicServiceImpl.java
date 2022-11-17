package com.example.service.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.service.entity.StuBasic;
import com.example.service.mapper.StuBasicMapper;
import com.example.service.service.StuBasicService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Wrapper;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author testjava
 * @since 2022-10-24
 */
@Service
public class StuBasicServiceImpl extends ServiceImpl<StuBasicMapper, StuBasic> implements StuBasicService {

//    @Autowired
//    private StuBasicMapper stuBasicMapper;

    @Override
    public List<StuBasic> getAll() {
        QueryWrapper<StuBasic> wrapper = new QueryWrapper<>();
        List<StuBasic> stuBasicList = baseMapper.selectList(wrapper);
        return stuBasicList;
    }
}
