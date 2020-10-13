/*
 * Tacitor
 * Oct 3, 2020
 * Large variables that can be called elsware to keep classes cleaner
 */
package com.tacitor.sebastiansmod.util;

import java.util.Arrays;
import java.util.List;
import net.minecraft.item.Item;

/**
 *
 * @author Tacitor
 */
public class ItemGroupOrder {
    
    public static final List<Item> TAB_ORDER = Arrays.asList(
            RegistryHandler.SEBASTIAN.get(), 
            Item.getItemFromBlock(RegistryHandler.BLOCK_OF_SEBASTIAN.get()), 
            RegistryHandler.AMBER.get(), 
            Item.getItemFromBlock(RegistryHandler.ONYX_BLOCK.get()),
            Item.getItemFromBlock(RegistryHandler.SEBASTAINIUM_ORE.get()),
            RegistryHandler.UNREFINED_SEBASTAINIUM.get(),
            RegistryHandler.RAW_SEBASTAINIUM.get(),
            RegistryHandler.SEBASTIANIUM_INGOT.get(),
            Item.getItemFromBlock(RegistryHandler.SEBASTAINIUM_BLOCK.get()),
            RegistryHandler.SEBASTAINIUM_HELMET.get(),
            RegistryHandler.SEBASTAINIUM_CHESTPLATE.get(),
            RegistryHandler.SEBASTAINIUM_LEGGINGS.get(),
            RegistryHandler.SEBASTAINIUM_BOOTS.get(),
            RegistryHandler.SEBASTIAN_SWORD.get(),
            RegistryHandler.SEBASTIAN_PICKAXE.get(), 
            RegistryHandler.SEBASTIAN_HACKAXE.get(), 
            RegistryHandler.SEBASTIAN_AXE.get(),
            RegistryHandler.SEBASTIAN_SHOVEL.get(), 
            RegistryHandler.SEBASTIAN_HOE.get()
    );
}
