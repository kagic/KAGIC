package mod.kagic.util.injector;

import java.util.List;

import mod.kagic.blocks.BlockGemDrill;
import mod.kagic.blocks.BlockIncubator;
import mod.kagic.blocks.BlockInjector;
import mod.kagic.init.ModBlocks;
import mod.kagic.init.ModConfigs;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;

public class Injector {
	public static void onGemDrillPlacement(World worldIn, BlockPos pos) {
		if (worldIn.getBlockState(pos.up()).getBlock() instanceof BlockInjector) {
			if (worldIn.getBlockState(pos.up(2)).getBlock() instanceof BlockIncubator) {
				if (worldIn.getBlockState(pos.up()).getBlock() == ModBlocks.INJECTOR) {
					Injector.tellNearbyPlayers(worldIn, pos, "place_gem_base", true);
				} else {
					Injector.tellNearbyPlayers(worldIn, pos, "place_redstone", true);
				}
			} else {
				Injector.tellNearbyPlayers(worldIn, pos, "place_incubator", true);
			}
		} else {
			Injector.tellNearbyPlayers(worldIn, pos, "place_injector_above", true);
		}
	}
	public static void onInjectorPlacement(World worldIn, BlockPos pos) {
		if (worldIn.getBlockState(pos.up()).getBlock() instanceof BlockIncubator) {
			if (worldIn.getBlockState(pos.down()).getBlock() instanceof BlockGemDrill) {
				if (worldIn.getBlockState(pos).getBlock() == ModBlocks.INJECTOR) {
					Injector.tellNearbyPlayers(worldIn, pos, "place_gem_base", true);
				} else {
					Injector.tellNearbyPlayers(worldIn, pos, "place_redstone", true);
				}
			} else {
				Injector.tellNearbyPlayers(worldIn, pos, "place_gem_drill", true);
			}
		} else {
			Injector.tellNearbyPlayers(worldIn, pos, "place_incubator", true);
		}
	}
	public static void onIncubatorPlacement(World worldIn, BlockPos pos) {
		if (worldIn.getBlockState(pos.down()).getBlock() instanceof BlockInjector) {
			if (worldIn.getBlockState(pos.down(2)).getBlock() instanceof BlockGemDrill) {
				if (worldIn.getBlockState(pos.down()).getBlock() == ModBlocks.INJECTOR) {
					Injector.tellNearbyPlayers(worldIn, pos, "place_gem_base", true);
				} else {
					Injector.tellNearbyPlayers(worldIn, pos, "place_redstone", true);
				}
			} else {
				Injector.tellNearbyPlayers(worldIn, pos, "place_gem_drill", true);
			}
		} else {
			Injector.tellNearbyPlayers(worldIn, pos, "place_injector_below", true);
		}
	}
	public static void onGemBasePlacement(World worldIn, BlockPos pos) {
		if (worldIn.getBlockState(pos.down()).getBlock() instanceof BlockGemDrill) {
			if (worldIn.getBlockState(pos.up()).getBlock() instanceof BlockIncubator) {
				Injector.tellNearbyPlayers(worldIn, pos, "place_redstone", true);
			} else {
				Injector.tellNearbyPlayers(worldIn, pos, "place_incubator", true);
			}
		} else {
			Injector.tellNearbyPlayers(worldIn, pos, "place_gem_drill", true);
		}
	}
	public static void tellNearbyPlayers(World worldIn, BlockPos pos, String key, boolean status, Object... params) {
		if (ModConfigs.instructInjectors) {
			List<EntityPlayer> list = worldIn.<EntityPlayer>getEntitiesWithinAABB(EntityPlayer.class, new AxisAlignedBB(pos).grow(8.0, 4.0, 8.0));
			for (EntityPlayer player : list) {
				if (status) {
					player.sendStatusMessage(new TextComponentTranslation("command.kagic." + key, params), true);
				} else {
					player.sendMessage(new TextComponentTranslation("command.kagic." + key, params));
				}
			}
		}
	}
	public static void tellNearbyPlayers(World worldIn, BlockPos pos, String key, boolean status) {
		Injector.tellNearbyPlayers(worldIn, pos, key, status, status);
	}

	public static void awardNearbyPlayers(World worldIn, BlockPos pos) {
		/*
		 * List<EntityPlayer> list =
		 * worldIn.<EntityPlayer>getEntitiesWithinAABB(
		 * EntityPlayer.class, new
		 * AxisAlignedBB(pos).expand(8.0, 4.0, 8.0)); for
		 * (EntityPlayer player : list) {
		 * player.addStat(ModAchievements.KINDERGARTENER); }
		 */
	}

	public static boolean isInjectorBlock(Block block) {
		return block == ModBlocks.GEM_DRILL || block == ModBlocks.INJECTOR || block == ModBlocks.EQUIPPED_INJECTOR || block == ModBlocks.ANALOG_INJECTOR || block == ModBlocks.EQUIPPED_ANALOG_INJECTOR || block == ModBlocks.INCUBATOR;
	}
}
