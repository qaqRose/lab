package io.github.qxqrose.lab5.bad.template;

public abstract class AbstractOpenDoor {

    /**
     * 开门
     * @param verification
     */
    final public void open(Verification verification) {
        if(isValidVerification(verification)) {
            // 调用api开门
            _open(verification.getDoorId());
        } else {
            //
            System.out.println("验证失败，无法开门");
        }
    }

    /**
     * 验证开门信息
     * @param verification
     * @return
     */
    protected abstract boolean isValidVerification(Verification verification);

    /**
     * 实际开门
     * @param doorId
     */
    private void _open(String doorId) {
        System.out.println(doorId + "门打开成功");
    }
}
