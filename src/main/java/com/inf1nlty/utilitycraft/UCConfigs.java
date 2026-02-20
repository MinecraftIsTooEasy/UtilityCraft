package com.inf1nlty.utilitycraft;

import fi.dy.masa.malilib.config.ConfigTab;
import fi.dy.masa.malilib.config.SimpleConfigs;
import fi.dy.masa.malilib.config.options.ConfigBase;
import fi.dy.masa.malilib.config.options.ConfigBoolean;

import java.util.ArrayList;
import java.util.List;

public class UCConfigs extends SimpleConfigs {

    public static final ConfigBoolean saberAttackSound = new ConfigBoolean(
            "utilitycraft.saberAttackSound",
            false,
            "config.comment.utilitycraft.saberAttackSound"
    );

    public static final ConfigBoolean rapierAttackSound = new ConfigBoolean(
            "utilitycraft.rapierAttackSound",
            false,
            "utilitycraft.rapierAttackSound"
    );

    private static final UCConfigs Instance;

    public static final List<ConfigBase<?>> MiscSettings;
    public static final List<ConfigBase<?>> Total;
    public static final List<ConfigTab> tabs;

    public UCConfigs(String name, List<ConfigBase<?>> values) {
        super(name, null, values);
    }

    public List<ConfigTab> getConfigTabs() {
        return tabs;
    }

    public static UCConfigs getInstance() {
        return Instance;
    }

    static {
        Total = new ArrayList<>();
        tabs = new ArrayList<>();

        MiscSettings = List.of(
                rapierAttackSound,
                saberAttackSound
        );

        Total.addAll(MiscSettings);

        tabs.add(new ConfigTab("misc", MiscSettings));

        Instance = new UCConfigs("UtilityCraft", Total);
    }
}