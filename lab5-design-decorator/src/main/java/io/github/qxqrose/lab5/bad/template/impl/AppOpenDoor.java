package io.github.qxqrose.lab5.bad.template.impl;

import io.github.qxqrose.lab5.bad.template.AbstractOpenDoor;
import io.github.qxqrose.lab5.bad.template.Verification;

/**
 * @author: qiu
 * 2021/8/5
 */
public class AppOpenDoor extends AbstractOpenDoor {

    @Override
    protected boolean isValidVerification(Verification verification) {
        System.out.println("在app内验证开门信息");
        return true;
    }
}
