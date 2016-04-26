package com.stiforr.swnmod.blocks;

import net.minecraft.block.Block;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

public class ItemBlockMeta extends ItemBlock {

    public ItemBlockMeta(Block block){
        super(block);
        if (!(block instanceof IMetaBlockName)){
            throw new IllegalArgumentException(String.format("The given Block %s is not an instance of ISpecialBlockName!", block.getUnlocalizedName()));
        }
        this.setMaxStackSize(64);
        this.setHasSubtypes(true);
    }

    public int getMetadata(int damage){
        return damage;
    }

	@Override
	public String getItemStackDisplayName(ItemStack stack)
	{
		return String.format("%s %s", StatCollector.translateToLocal("color." + EnumType.values()[stack.getMetadata()]), StatCollector.translateToLocal("tile.stonebrick.name"));
	}
}
