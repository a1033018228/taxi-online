package com.ggg.internalcommon.dto.serviceverificationcode;

import lombok.Data;

//泛型类用来接Verificationcode的返回值
@Data
public class VerifyCodeResponse {
	
	private String code;
}