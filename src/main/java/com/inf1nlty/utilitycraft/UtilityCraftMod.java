package com.inf1nlty.utilitycraft;

import net.fabricmc.api.ModInitializer;
import net.xiaoyu233.fml.ModResourceManager;
import net.xiaoyu233.fml.reload.event.MITEEvents;

public class UtilityCraftMod implements ModInitializer {

    public static final String NAMESPACE = "utilitycraft";

    @Override
    public void onInitialize() {
        ModResourceManager.addResourcePackDomain(NAMESPACE);
        MITEEvents.MITE_EVENT_BUS.register(new UtilityCraftEventListener());
    }
}