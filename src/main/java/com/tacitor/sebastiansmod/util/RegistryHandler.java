/*
 * Tacitor
 * Sep 26, 2020
 * Registers Blocks and Items
 */
package com.tacitor.sebastiansmod.util;

import com.google.common.collect.Sets;
import com.tacitor.sebastiansmod.SebastiansMod;
import com.tacitor.sebastiansmod.blocks.BlockItemBase;
import com.tacitor.sebastiansmod.items.ItemBase;
import com.tacitor.sebastiansmod.blocks.OnyxBlock;
import com.tacitor.sebastiansmod.blocks.SebastianBlock;
import com.tacitor.sebastiansmod.tools.ModItemTier;
import com.tacitor.sebastiansmod.tools.SebToolItem;
import java.util.Set;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.AxeItem;
import net.minecraft.item.HoeItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolItem;
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
    
    private static final Set<Block> EFFECTIVE_ON = Sets.newHashSet(Blocks.OAK_PLANKS, Blocks.SPRUCE_PLANKS, Blocks.BIRCH_PLANKS, Blocks.STONE, Blocks.COBBLESTONE);
    
    public static void init() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
    
    // Items
    public static final RegistryObject<Item> SEBASTIAN = ITEMS.register("sebastian", ItemBase::new);
    public static final RegistryObject<Item> AMBER = ITEMS.register("amber", ItemBase::new);    
    public static final RegistryObject<Item> SEBASTIANIUM_INGOT = ITEMS.register("sebastianium_ingot", ItemBase::new);
    
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
    public static final RegistryObject<SebToolItem> SEBASTIAN_HACKAXE = ITEMS.register("sebastian_hackaxe", () ->
            new SebToolItem(6f, -3f, ModItemTier.SEBASTIAN, EFFECTIVE_ON, new Item.Properties().group(SebastiansMod.MODTAB)));
    
    //Blocks
    public static final RegistryObject<Block> ONYX_BLOCK = BLOCKS.register("onyx_block", OnyxBlock::new);
    public static final RegistryObject<Block> BLOCK_OF_SEBASTIAN = BLOCKS.register("block_of_sebastian", SebastianBlock::new);
    
    //Block Items
    public static final RegistryObject<Item> ONYX_BLOCK_ITEM = ITEMS.register("onyx_block", () -> new BlockItemBase(ONYX_BLOCK.get()));
    public static final RegistryObject<Item> BLOCK_OF_SEBASTIAN_ITEM = ITEMS.register("block_of_sebastian", () -> new BlockItemBase(BLOCK_OF_SEBASTIAN.get()));
    
}
