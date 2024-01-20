package net.sebastian.tutorialmod.item.custom;

import com.google.common.collect.ImmutableMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.sebastian.tutorialmod.item.ModArmorMaterials;

import java.util.Map;

public class ModArmorItem extends ArmorItem {

    private static final Map<ArmorMaterial, StatusEffectInstance> MATERIAL_TO_EFFECT_MAP =
            new ImmutableMap.Builder<ArmorMaterial, StatusEffectInstance>()
                    .put(ModArmorMaterials.RUBY, new StatusEffectInstance(StatusEffects.ABSORPTION,400,1)).build();
    public ModArmorItem(ArmorMaterial material, Type type, Settings settings) {
        super(material, type, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if(!world.isClient()&&entity instanceof PlayerEntity player){
            if (hasFullSuitOfArmor(player)) {
                evaluateArmorEffects(player);
            }
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }

    private void evaluateArmorEffects(PlayerEntity player) {
        for(Map.Entry<ArmorMaterial, StatusEffectInstance> entry: MATERIAL_TO_EFFECT_MAP.entrySet()){
            ArmorMaterial mapArmorMaterial = entry.getKey();
            StatusEffectInstance mapStatusEffectInstance = entry.getValue();

            if(hasCorrectArmorOn(mapArmorMaterial, player)){
                addStatusEffectForMaterial(player, mapStatusEffectInstance);
                break;
            }
        }
    }

    private void addStatusEffectForMaterial(PlayerEntity player, StatusEffectInstance mapStatusEffectInstance) {
        boolean hasPlayerEffectAlready = player.hasStatusEffect(mapStatusEffectInstance.getEffectType());

        if (!hasPlayerEffectAlready) {
            player.addStatusEffect(new StatusEffectInstance(mapStatusEffectInstance.getEffectType(),
                    mapStatusEffectInstance.getDuration(), mapStatusEffectInstance.getAmplifier()));
        }
    }

    private boolean hasCorrectArmorOn(ArmorMaterial mapArmorMaterial, PlayerEntity player) {
        for(ItemStack armorStack: player.getArmorItems()){
            if (!(armorStack.getItem() instanceof ArmorItem)){
                return false;
            }
        }
        ArmorItem boots = ((ArmorItem) player.getInventory().getArmorStack(0).getItem());
        ArmorItem leggings = ((ArmorItem) player.getInventory().getArmorStack(1).getItem());
        ArmorItem chestplate = ((ArmorItem) player.getInventory().getArmorStack(2).getItem());
        ArmorItem helmet = ((ArmorItem) player.getInventory().getArmorStack(3).getItem());

        return helmet.getMaterial() == mapArmorMaterial && chestplate.getMaterial()==mapArmorMaterial &&
                leggings.getMaterial()==mapArmorMaterial&&boots.getMaterial()==mapArmorMaterial;
    }

    private boolean hasFullSuitOfArmor(PlayerEntity player) {
        ItemStack boots = player.getInventory().getArmorStack(0);
        ItemStack leggings = player.getInventory().getArmorStack(1);
        ItemStack chestplate = player.getInventory().getArmorStack(2);
        ItemStack helmet = player.getInventory().getArmorStack(3);

        return !boots.isEmpty() && !leggings.isEmpty() && !chestplate.isEmpty() && !helmet.isEmpty();
    }
}
