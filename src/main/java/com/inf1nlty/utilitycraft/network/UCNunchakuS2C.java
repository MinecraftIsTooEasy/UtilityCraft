package com.inf1nlty.utilitycraft.network;

import com.inf1nlty.utilitycraft.network.s2c.S2CNunchakuSpinPacket;
import moddedmite.rustedironcore.network.Network;
import net.minecraft.ServerPlayer;

public final class UCNunchakuS2C {

    public static void broadcastSpinning(ServerPlayer player, boolean spinning) {
        Network.sendToAllPlayers(new S2CNunchakuSpinPacket(player.entityId, spinning));
    }
}
