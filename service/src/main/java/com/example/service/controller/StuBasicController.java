package com.example.service.controller;


import com.example.red.commonutils.R;
import com.example.service.entity.StuBasic;
import com.example.service.service.StuBasicService;
import com.example.service.service.impl.StuBasicServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author testjava
 * @since 2022-10-24
 */
@CrossOrigin
@RestController
@RequestMapping("/service/stuBasic")
public class StuBasicController {

    @Autowired
    private StuBasicService stuBasicService;

    @ApiOperation(value = "获取全部")
    @CrossOrigin
    @PostMapping("/getAll")
    public R getAll(){
        List<StuBasic> stuBasicList = stuBasicService.getAll();
        return  R.ok().data("stuBasicList", stuBasicList).message("success");
    }
}

