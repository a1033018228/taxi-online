package com.ggg.serviceverificationcode.service.impl;

import com.ggg.internalcommon.constant.CommonStatusEnum;
import com.ggg.internalcommon.dto.ResponseResult;
import com.ggg.internalcommon.dto.serviceverificationcode.VerifyCodeResponse;
import com.ggg.serviceverificationcode.service.VerifyCodeService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @Author: ggg
 * @create: 2021/5/30 23:44
 */
@Service
public class VerifyCodeServiceImpl implements VerifyCodeService {


    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    @Override
    public ResponseResult<VerifyCodeResponse> generate(int identity, String phoneNumber) {

        //校验，三挡验证。乌云，安全检测。业务方控制不能无限发短信。
        //redis1分钟发了3次，限制5分钟不能发。1小时发了10次，24小时不能发
        String code = String.valueOf((int)((Math.random() * 9 + 1) * Math.pow(10, 5)));
        VerifyCodeResponse data = new VerifyCodeResponse();
        data.setCode(code);
        return ResponseResult.success(data);
    }

    /*//校验验证码
    //用户传进来的验证码和redis中的验证码一致，校验通过，否则不过。
    @Override
    public ResponseResult verify(int identity,String phoneNumber,String code){
        //三档验证
        //生成redis key
        String keyPre = generateKeyPreByIdentity(identity);
        String key = keyPre + phoneNumber;
        BoundValueOperations<String, String> codeRedis = redisTemplate.boundValueOps(key);
        String redisCode = codeRedis.get();

        if(StringUtils.isNotBlank(code)
                && StringUtils.isNotBlank(redisCode)
                && code.trim().equals(redisCode.trim())) {

            return ResponseResult.success("");
        }else {
            return ResponseResult.fail(CommonStatusEnum.VERIFY_CODE_ERROR.getCode(), CommonStatusEnum.VERIFY_CODE_ERROR.getValue());
        }

    }*/
    public static void main(String[] args) {
        String code = String.valueOf((int)((Math.random() * 9 + 1) * Math.pow(10, 5)));
        System.out.println(code);
    }
}
