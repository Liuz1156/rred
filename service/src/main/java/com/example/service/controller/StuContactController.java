package com.example.service.controller;


import com.example.red.commonutils.R;
import com.example.service.entity.StuBasic;
import com.example.service.entity.StuContact;
import com.example.service.service.StuContactService;
import com.example.service.service.impl.StuContactServiceImpl;
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
 * @since 2022-10-26
 */
@RestController
@RequestMapping("/service/stuContact")
public class StuContactController {
    
    @Autowired
    private StuContactService service;

    @ApiOperation(value = "获取全部")
    @CrossOrigin
    @PostMapping("/getAll")
    public R getAll(){
        List<StuContact> stuContacts = service.getAll();
        return  R.ok().data("stuContactList", stuContacts).message("success");
    }
}

