package net.sebastian.tutorialmod.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Colors;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Position;
import net.minecraft.world.World;
import net.sebastian.tutorialmod.item.ModItems;
import net.sebastian.tutorialmod.util.InventoryUtil;
import net.sebastian.tutorialmod.util.ModTags;
import org.jetbrains.annotations.Nullable;

import javax.swing.text.Style;
import java.util.List;

public class MetalDetectorItem extends Item {
    public MetalDetectorItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if(!context.getWorld().isClient()){
            BlockPos positonClicked=context.getBlockPos();
            PlayerEntity player = context.getPlayer();
            boolean foundBlock = false;

            for(int i =0;i<= positonClicked.getY() + 64;i++) {
                BlockState state = context.getWorld().getBlockState(positonClicked.down(i));

                if(isValuableBlock(state)) {
                    outputValuableCoordinates(positonClicked.down(i),player,state.getBlock());
                    foundBlock = true;

                    if(InventoryUtil.hasPlayerStackInInventory(player, ModItems.DATA_TABLET)){
                        addNbtDataToDataTablet(player, positonClicked.down(i), state.getBlock());
                    }

                    break;
                }
            }
            if(!foundBlock){
                player.sendMessage(Text.literal("No Valuables Found!"));
            }
        }

        context.getStack().damage(1,context.getPlayer(), playerEntity -> playerEntity.sendToolBreakStatus(playerEntity.getActiveHand()));

        return ActionResult.SUCCESS;
    }

    private void addNbtDataToDataTablet(PlayerEntity player, BlockPos blockPos, Block block) {
        ItemStack dataTabletStack = player.getInventory().getStack(InventoryUtil.getFirstInventoryIndex(player, ModItems.DATA_TABLET));

        NbtCompound nbtData = new NbtCompound();
        nbtData.putString("tutorialmod.last_valuable_found", "Found "+block.asItem().getName().getString()
                + " at "+"("+blockPos.getX()+","+blockPos.getY()+","+blockPos.getZ() + ")");

        dataTabletStack.setNbt(nbtData);
    }

    private void outputValuableCoordinates(BlockPos blockPos, PlayerEntity player, Block block) {
        player.sendMessage(Text.literal("Found "+block.asItem().getName().getString()
                + " at "+"("+blockPos.getX()+","+blockPos.getY()+","+blockPos.getZ() + ")"), false);
    }

    private boolean isValuableBlock(BlockState state) {
        return state.isIn(ModTags.Blocks.METAL_DETECTOR_DETECTABLE_BLOCKS);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip.tutorialmod.metal_detector.tooltip"));
        super.appendTooltip(stack, world, tooltip, context);
    }
}
