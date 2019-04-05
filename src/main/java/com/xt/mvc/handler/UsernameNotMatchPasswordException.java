package com.xt.mvc.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author xt
 * @create 2019/4/5 12:18
 * @Desc
 */
@ResponseStatus(code = HttpStatus.FORBIDDEN, reason = "用户名密码不匹配")
public class UsernameNotMatchPasswordException extends RuntimeException {

}
