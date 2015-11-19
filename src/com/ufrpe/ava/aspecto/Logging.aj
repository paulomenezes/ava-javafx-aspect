package com.ufrpe.ava.aspecto;

/**
 * Created by paulomenezes on 17/11/15.
 */
public aspect Logging {

    pointcut logLogin():
            execution (* Login.*());

    after(): logLogin() {
        System.out.println("after");
    }

    before(): logLogin() {
        System.out.println("before");
    }
}
