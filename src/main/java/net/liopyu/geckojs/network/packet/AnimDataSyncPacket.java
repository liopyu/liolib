package net.liopyu.geckojs.network.packet;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;
import net.liopyu.geckojs.animatable.SingletonGeoAnimatable;
import net.liopyu.geckojs.constant.DataTickets;
import net.liopyu.geckojs.core.animatable.GeoAnimatable;
import net.liopyu.geckojs.network.GeckoLibNetwork;
import net.liopyu.geckojs.network.SerializableDataTicket;
import net.liopyu.geckojs.util.ClientUtils;

import java.util.function.Supplier;

/**
 * Packet for syncing user-definable animation data for {@link SingletonGeoAnimatable} instances
 */
public class AnimDataSyncPacket<D> {
	private final String syncableId;
	private final long instanceId;
	private final SerializableDataTicket<D> dataTicket;
	private final D data;

	public AnimDataSyncPacket(String syncableId, long instanceId, SerializableDataTicket<D> dataTicket, D data) {
		this.syncableId = syncableId;
		this.instanceId = instanceId;
		this.dataTicket = dataTicket;
		this.data = data;
	}

	public void encode(FriendlyByteBuf buffer) {
		buffer.writeUtf(this.syncableId);
		buffer.writeVarLong(this.instanceId);
		buffer.writeUtf(this.dataTicket.id());
		this.dataTicket.encode(this.data, buffer);
	}

	public static <D> AnimDataSyncPacket<D> decode(FriendlyByteBuf buffer) {
		String syncableId = buffer.readUtf();
		long instanceId = buffer.readVarLong();
		SerializableDataTicket<D> dataTicket = (SerializableDataTicket<D>)DataTickets.byName(buffer.readUtf());
		D data = dataTicket.decode(buffer);

		return new AnimDataSyncPacket<>(syncableId, instanceId, dataTicket, data);
	}

	public void receivePacket(Supplier<NetworkEvent.Context> context) {
		NetworkEvent.Context handler = context.get();

		handler.enqueueWork(() -> {
			GeoAnimatable animatable = GeckoLibNetwork.getSyncedAnimatable(this.syncableId);

			if (animatable instanceof SingletonGeoAnimatable singleton)
				singleton.setAnimData(ClientUtils.getClientPlayer(), this.instanceId, this.dataTicket, this.data);
		});

		handler.setPacketHandled(true);
	}
}
