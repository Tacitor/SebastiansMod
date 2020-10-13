/*
 * Tacitor
 * Sep 26, 2020
 * Registers Blocks and Items
 */
package com.tacitor.sebastiansmod.util;

import com.tacitor.sebastiansmod.SebastiansMod;
import com.tacitor.sebastiansmod.armor.ModArmorMaterial;
import com.tacitor.sebastiansmod.blocks.BlockItemBase;
import com.tacitor.sebastiansmod.items.ItemBase;
import com.tacitor.sebastiansmod.blocks.OnyxBlock;
import com.tacitor.sebastiansmod.blocks.SebastainiumBlock;
import com.tacitor.sebastiansmod.blocks.SebastainiumOre;
import com.tacitor.sebastiansmod.blocks.SebastianBlock;
import com.tacitor.sebastiansmod.items.SebFood;
import com.tacitor.sebastiansmod.tools.ModItemTier;
import com.tacitor.sebastiansmod.tools.MultiPickaxeItem;
import net.minecraft.block.Block;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.HoeItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;

/**
 *
 * @author Tacitor
 */
public class RegistryHandler {
    
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, SebastiansMod.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, SebastiansMod.MOD_ID);
    
    public static void init() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
    
    // Items
    public static final RegistryObject<SebFood> SEBASTIAN = ITEMS.register("sebastian", SebFood::new);
    public static final RegistryObject<Item> AMBER = ITEMS.register("amber", ItemBase::new);
    public static final RegistryObject<Item> SEBASTIANIUM_INGOT = ITEMS.register("sebastianium_ingot", ItemBase::new);
    public static final RegistryObject<Item> UNREFINED_SEBASTAINIUM = ITEMS.register("unrefined_sebastainium", ItemBase::new);
    public static final RegistryObject<Item> RAW_SEBASTAINIUM = ITEMS.register("raw_sebastainium", ItemBase::new);
    
    //Tools
    public static final RegistryObject<SwordItem> SEBASTIAN_SWORD = ITEMS.register("sebastian_sword", () ->
            new SwordItem(ModItemTier.SEBASTIAN, 8, -2.4f, new Item.Properties().group(SebastiansMod.MODTAB)));
    public static final RegistryObject<PickaxeItem> SEBASTIAN_PICKAXE = ITEMS.register("sebastian_pickaxe", () ->
            new PickaxeItem(ModItemTier.SEBASTIAN, 6, -2.8f, new Item.Properties().group(SebastiansMod.MODTAB)));
    public static final RegistryObject<AxeItem> SEBASTIAN_AXE = ITEMS.register("sebastian_axe", () ->
            new AxeItem(ModItemTier.SEBASTIAN, 10, -3f, new Item.Properties().group(SebastiansMod.MODTAB)));
    public static final RegistryObject<ShovelItem> SEBASTIAN_SHOVEL = ITEMS.register("sebastian_shovel", () ->
            new ShovelItem(ModItemTier.SEBASTIAN, 6.5f, -3f, new Item.Properties().group(SebastiansMod.MODTAB)));
    public static final RegistryObject<HoeItem> SEBASTIAN_HOE = ITEMS.register("sebastian_hoe", () ->
            new HoeItem(ModItemTier.SEBASTIAN, 0f, new Item.Properties().group(SebastiansMod.MODTAB)));
    public static final RegistryObject<MultiPickaxeItem> SEBASTIAN_HACKAXE = ITEMS.register("sebastian_hackaxe", () ->
            new MultiPickaxeItem(ModItemTier.SEBASTIAN, 6, -3f, HackaxeData.HACKAXE_EFFECTIVE_ON , new Item.Properties().group(SebastiansMod.MODTAB).addToolType(ToolType.AXE, 4)));
    
    //armor
    public static final RegistryObject<ArmorItem> SEBASTAINIUM_HELMET = ITEMS.register("sebastainium_helmet", () -> 
        new ArmorItem(ModArmorMaterial.SEBASTIANIUM, EquipmentSlotType.HEAD, new Item.Properties().group(SebastiansMod.MODTAB)));
    public static final RegistryObject<ArmorItem> SEBASTAINIUM_CHESTPLATE = ITEMS.register("sebastainium_chestplate", () -> 
        new ArmorItem(ModArmorMaterial.SEBASTIANIUM, EquipmentSlotType.CHEST, new Item.Properties().group(SebastiansMod.MODTAB)));
    public static final RegistryObject<ArmorItem> SEBASTAINIUM_LEGGINGS = ITEMS.register("sebastainium_leggings", () -> 
        new ArmorItem(ModArmorMaterial.SEBASTIANIUM, EquipmentSlotType.LEGS, new Item.Properties().group(SebastiansMod.MODTAB)));
    public static final RegistryObject<ArmorItem> SEBASTAINIUM_BOOTS = ITEMS.register("sebastainium_boots", () -> 
        new ArmorItem(ModArmorMaterial.SEBASTIANIUM, EquipmentSlotType.FEET, new Item.Properties().group(SebastiansMod.MODTAB)));
    
    //Blocks
    public static final RegistryObject<Block> ONYX_BLOCK = BLOCKS.register("onyx_block", OnyxBlock::new);
    public static final RegistryObject<Block> BLOCK_OF_SEBASTIAN = BLOCKS.register("block_of_sebastian", SebastianBlock::new);
    public static final RegistryObject<Block> SEBASTAINIUM_BLOCK = BLOCKS.register("sebastainium_block", SebastainiumBlock::new);
    public static final RegistryObject<Block> SEBASTAINIUM_ORE = BLOCKS.register("sebastainium_ore", SebastainiumOre::new);
    
    //Block Items
    public static final RegistryObject<Item> ONYX_BLOCK_ITEM = ITEMS.register("onyx_block", () -> new BlockItemBase(ONYX_BLOCK.get()));
    public static final RegistryObject<Item> BLOCK_OF_SEBASTIAN_ITEM = ITEMS.register("block_of_sebastian", () -> new BlockItemBase(BLOCK_OF_SEBASTIAN.get()));
    public static final RegistryObject<Item> SEBASTAINIUM_BLOCK_ITEM = ITEMS.register("sebastainium_block", () -> new BlockItemBase(SEBASTAINIUM_BLOCK.get()));
    public static final RegistryObject<Item> SEBASTAINIUM_ORE_ITEM = ITEMS.register("sebastainium_ore", () -> new BlockItemBase(SEBASTAINIUM_ORE.get()));
    
}
