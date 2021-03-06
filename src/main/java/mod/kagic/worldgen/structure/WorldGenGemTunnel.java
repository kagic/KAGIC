package mod.kagic.worldgen.structure;

import java.util.Random;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenGemTunnel extends WorldGenerator {
	private double gemHeight = 3;
	private double gemWidth = 3;
	private int length = 7;
	private int north = 0;
	private int east = 0;

	public WorldGenGemTunnel(double height, double width, int north, int east, int length) {
		this.gemHeight = height;
		this.gemWidth = width;
		this.length = length;
		this.north = north;
		this.east = east;
	}

	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position) {
		if (this.north != 0 && this.east != 0) {
			if (rand.nextBoolean()) {
				this.north = 0;
			} else {
				this.east = 0;
			}
		}
		if (this.north > 0) {
			for (float yad = 0; yad < this.gemHeight; ++yad) {
				for (float num = position.getZ(); num >= position.getZ() - this.length; --num) {
					if (this.gemWidth == 3) {
						worldIn.destroyBlock(new BlockPos(position.getX() - 1, yad + position.getY(), num), false);
						worldIn.destroyBlock(new BlockPos(position.getX(), yad + position.getY(), num), false);
						worldIn.destroyBlock(new BlockPos(position.getX() + 1, yad + position.getY(), num), false);
					}
					if (this.gemWidth == 2) {
						worldIn.destroyBlock(new BlockPos(position.getX() - 1, yad + position.getY(), num), false);
						worldIn.destroyBlock(new BlockPos(position.getX(), yad + position.getY(), num), false);
					}
					if (this.gemWidth == 1) {
						worldIn.destroyBlock(new BlockPos(position.getX(), yad + position.getY(), num), false);
					}
				}
			}
		}
		if (this.north < 0) {
			for (float yad = 0; yad < this.gemHeight; ++yad) {
				for (float num = position.getZ(); num <= position.getZ() + this.length; ++num) {
					if (this.gemWidth == 3) {
						worldIn.destroyBlock(new BlockPos(position.getX() - 1, yad + position.getY(), num), false);
						worldIn.destroyBlock(new BlockPos(position.getX(), yad + position.getY(), num), false);
						worldIn.destroyBlock(new BlockPos(position.getX() + 1, yad + position.getY(), num), false);
					}
					if (this.gemWidth == 2) {
						worldIn.destroyBlock(new BlockPos(position.getX() - 1, yad + position.getY(), num), false);
						worldIn.destroyBlock(new BlockPos(position.getX(), yad + position.getY(), num), false);
					}
					if (this.gemWidth == 1) {
						worldIn.destroyBlock(new BlockPos(position.getX(), yad + position.getY(), num), false);
					}
				}
			}
		}
		if (this.east < 0) {
			for (float yad = 0; yad < this.gemHeight; ++yad) {
				for (float num = position.getX(); num >= position.getX() - this.length; --num) {
					if (this.gemWidth == 3) {
						worldIn.destroyBlock(new BlockPos(num, yad + position.getY(), position.getZ() - 1), false);
						worldIn.destroyBlock(new BlockPos(num, yad + position.getY(), position.getZ()), false);
						worldIn.destroyBlock(new BlockPos(num, yad + position.getY(), position.getZ() + 1), false);
					}
					if (this.gemWidth == 2) {
						worldIn.destroyBlock(new BlockPos(num, yad + position.getY(), position.getZ() - 1), false);
						worldIn.destroyBlock(new BlockPos(num, yad + position.getY(), position.getZ()), false);
					}
					if (this.gemWidth == 1) {
						worldIn.destroyBlock(new BlockPos(num, yad + position.getY(), position.getZ()), false);
					}
				}
			}
		}
		if (this.east > 0) {
			for (float yad = 0; yad < this.gemHeight; ++yad) {
				for (float num = position.getX(); num <= position.getX() + this.length; ++num) {
					if (this.gemWidth == 3) {
						worldIn.destroyBlock(new BlockPos(num, yad + position.getY(), position.getZ() - 1), false);
						worldIn.destroyBlock(new BlockPos(num, yad + position.getY(), position.getZ()), false);
						worldIn.destroyBlock(new BlockPos(num, yad + position.getY(), position.getZ() + 1), false);
					}
					if (this.gemWidth == 2) {
						worldIn.destroyBlock(new BlockPos(num, yad + position.getY(), position.getZ() - 1), false);
						worldIn.destroyBlock(new BlockPos(num, yad + position.getY(), position.getZ()), false);
					}
					if (this.gemWidth == 1) {
						worldIn.destroyBlock(new BlockPos(num, yad + position.getY(), position.getZ()), false);
					}
				}
			}
		}
		return true;
	}
}
