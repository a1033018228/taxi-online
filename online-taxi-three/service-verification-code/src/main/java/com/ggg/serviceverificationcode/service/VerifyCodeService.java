package com.ggg.serviceverificationcode.service;

import com.ggg.internalcommon.dto.ResponseResult;
import com.ggg.internalcommon.dto.serviceverificationcode.VerifyCodeResponse;
import com.ggg.serviceverificationcode.controller.VerifyCodeController;

/**
 * @description:
 * @Author: ggg
 * @create: 2021/5/30 23:34
 */
public interface VerifyCodeService {

    public ResponseResult<VerifyCodeResponse> generate(int identity, String phoneNumber);


}
