package com.inf1nlty.utilitycraft.network;

import com.inf1nlty.utilitycraft.network.c2s.C2SNunchakuSpinPacket;
import moddedmite.rustedironcore.network.Network;

public final class UCNunchakuC2S {

    public static void sendSpinning(boolean spinning) {
        Network.sendToServer(new C2SNunchakuSpinPacket(spinning));
    }
}
