package com.inf1nlty.utilitycraft;

import com.inf1nlty.utilitycraft.network.SteelChestNet;
import net.fabricmc.api.ModInitializer;
import net.xiaoyu233.fml.ModResourceManager;
import net.xiaoyu233.fml.reload.event.MITEEvents;

public class UtilityCraftMod implements ModInitializer {

    public static final String NAMESPACE = "utilitycraft";

    @Override
    public void onInitialize() {
        ModResourceManager.addResourcePackDomain(NAMESPACE);

        UCRICEvents.register();

        SteelChestNet.register("utilitycraft");

        MITEEvents.MITE_EVENT_BUS.register(new UCFMLEvents());
    }
}