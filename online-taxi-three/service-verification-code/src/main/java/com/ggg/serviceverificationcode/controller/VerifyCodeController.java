package com.ggg.serviceverificationcode.controller;

import com.ggg.internalcommon.dto.ResponseResult;
import com.ggg.serviceverificationcode.service.VerifyCodeService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @Author: ggg
 * @create: 2021/5/30 19:34
 */
@RestController
@RequestMapping("/verify-code")
public class VerifyCodeController {

    @Autowired
    VerifyCodeService verifyCodeService;

    @GetMapping("/generate/{identity}/{phoneNumber}")
    public ResponseResult generate(@PathVariable("identity") int identity, @PathVariable("phoneNumber") String phoneNumber){

        return verifyCodeService.generate(identity, phoneNumber);
    }
}
