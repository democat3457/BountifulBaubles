package cursedflames.bountifulbaubles.wormhole;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;

public class CommandWormhole extends CommandBase {
	private static final String USAGE = "bountifulbaubles.commands.wormhole.usage";
	
	@Override
	public String getName() {
		return "wormhole";
	}

	@Override
	public String getUsage(ICommandSender sender) {
		return USAGE;
	}
	
	@Override
	public int getRequiredPermissionLevel() {
		return 0;
	}
	
	@Override
	public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
		// have to do this because minecraft special cases non-op commands
		// and other commands need op, even if they have permission level 0
		// TODO probably want to actually check if it's a player instead of always returning true
		return true;
	}
	

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		EntityPlayer target = getCommandSenderAsPlayer(sender);
		if (args.length < 1) {
			throw new WrongUsageException(USAGE);
		}
		if (!args[0].equals("acc") && !args[0].equals("deny")) {
			throw new WrongUsageException(USAGE);
		}
		boolean accept = args[0].equals("acc");
		String origin = args.length > 1 ? args[1] : null;
		// TODO use args as a list of players to accept or reject, instead of just one player?
//		BountifulBaubles.logger.info("attempting tele accept/reject");
		TeleportRequest.acceptReject(target, accept, origin);
	}
}
