package net.sebastian.tutorialmod.item.custom;

import net.minecraft.block.Block;
import net.minecraft.item.MiningToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.TagKey;
import net.sebastian.tutorialmod.util.ModTags;

public class PaxelItem extends MiningToolItem {

    public PaxelItem(float attackDamage, float attackSpeed, ToolMaterial material, Settings settings) {
        super(attackDamage, attackSpeed, material, ModTags.Blocks.PAXEL_MINABLE, settings);
    }
}
