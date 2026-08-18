package com.inf1nlty.utilitycraft.item.nunchaku;

public interface INunchakuSpinState {

    boolean utilitycraft$isNunchakuSpinning();

    void utilitycraft$setNunchakuSpinning(boolean spinning);

    static INunchakuSpinState as(Object entity) {
        return entity instanceof INunchakuSpinState spinState ? spinState : null;
    }
}
