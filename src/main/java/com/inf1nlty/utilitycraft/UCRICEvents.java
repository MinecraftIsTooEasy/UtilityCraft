package com.inf1nlty.utilitycraft;

import com.inf1nlty.utilitycraft.init.UCRecipes;
import moddedmite.rustedironcore.api.event.Handlers;

public class UCRICEvents extends Handlers {

    public static void register() {
        Crafting.register(new UCRecipes());
    }
}