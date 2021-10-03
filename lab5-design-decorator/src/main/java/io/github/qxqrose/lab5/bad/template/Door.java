package io.github.qxqrose.lab5.bad.template;

import io.github.qxqrose.lab5.bad.template.impl.AppOpenDoor;
import io.github.qxqrose.lab5.bad.template.impl.FaceOpenDoor;
import io.github.qxqrose.lab5.bad.template.impl.FingerprintOpenDoor;
import io.github.qxqrose.lab5.bad.template.impl.VoiceOpenDoor;

/**
 * @author: qiu
 * 2021/8/5
 */
public class Door {

    public static void main(String[] args) {
        // 构造开门信息
        Verification verification = new Verification("1", "123", "fingerprint");

        AbstractOpenDoor openDoor = null;
        switch (verification.getType()) {
            case "app":
                openDoor = new AppOpenDoor();
                break;
            case "fingerprint":
                openDoor = new FingerprintOpenDoor();
                break;
            case "face":
                openDoor = new FaceOpenDoor();
                break;
            case "voice":
                openDoor = new VoiceOpenDoor();
                break;
        }

        openDoor.open(verification);
    }
}
