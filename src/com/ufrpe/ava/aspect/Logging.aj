package com.ufrpe.ava.aspect;

/**
 * Created by paulomenezes on 17/11/15.
 */
public aspect Logging {

    pointcut logLogin():
            execution (* com.ufrpe.ava.controller.LoginController.*());

    after(): logLogin() {
        System.out.println("after");
    }

    before(): logLogin() {
        System.out.println("before");
    }
}
