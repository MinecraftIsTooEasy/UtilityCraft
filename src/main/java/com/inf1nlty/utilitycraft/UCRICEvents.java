package com.inf1nlty.utilitycraft;

import com.inf1nlty.utilitycraft.event.listener.UCArmorModelListener;
import com.inf1nlty.utilitycraft.init.UCRecipes;
import moddedmite.rustedironcore.api.event.Handlers;

public class UCRICEvents extends Handlers {

    public static void register() {
        ArmorModel.getListeners().removeIf(listener -> listener instanceof UCArmorModelListener);
        ArmorModel.getListeners().add(0, new UCArmorModelListener());
        Crafting.register(new UCRecipes());
    }
}
