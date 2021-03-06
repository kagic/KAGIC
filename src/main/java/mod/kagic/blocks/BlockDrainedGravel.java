package mod.kagic.blocks;

import mod.kagic.init.ModBlocks;
import mod.kagic.init.ModCreativeTabs;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockDrainedGravel extends BlockFalling {
	
	public BlockDrainedGravel(String unlocalizedName) {
		super(ModBlocks.DRAINED);
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(ModCreativeTabs.CREATIVE_TAB_OTHER);
		this.setResistance(1);
		this.setHardness(40);
		this.setHarvestLevel("shovel", 1);
		this.setSoundType(SoundType.GROUND);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getDustColor(IBlockState state) {
		return 4797768;
	}
}
