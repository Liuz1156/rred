package com.example.service.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.service.entity.StuContact;
import com.example.service.mapper.StuContactMapper;
import com.example.service.service.StuContactService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author testjava
 * @since 2022-10-26
 */
@Service
public class StuContactServiceImpl extends ServiceImpl<StuContactMapper, StuContact> implements StuContactService {

    @Override
    public List<StuContact> getAll() {
        QueryWrapper<StuContact> wrapper=new QueryWrapper<>();
        List<StuContact> stuContactList = baseMapper.selectList(wrapper);
        return stuContactList;
    }
}
