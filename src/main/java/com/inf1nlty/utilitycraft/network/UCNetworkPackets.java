package com.inf1nlty.utilitycraft.network;

import com.inf1nlty.utilitycraft.network.c2s.C2SNunchakuSpinPacket;
import com.inf1nlty.utilitycraft.network.s2c.S2CNunchakuSpinPacket;
import moddedmite.rustedironcore.network.PacketReader;

public final class UCNetworkPackets {

    public static void init() {
        PacketReader.registerServerPacketReader(C2SNunchakuSpinPacket.CHANNEL, C2SNunchakuSpinPacket::new);
        PacketReader.registerClientPacketReader(S2CNunchakuSpinPacket.CHANNEL, S2CNunchakuSpinPacket::new);
    }
}
