package com.tacitor.sebastiansmod;

import com.google.common.collect.Ordering;
import com.tacitor.sebastiansmod.util.ItemGroupOrder;
import com.tacitor.sebastiansmod.util.RegistryHandler;
import java.util.Comparator;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("sebsmod")
public class SebastiansMod
{
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "sebsmod";
    
    static Comparator<ItemStack> tabSorter;

    public SebastiansMod() {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the doClientStuff method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);        
        
        //load items
        RegistryHandler.init();

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
    }
    
    public static final ItemGroup MODTAB = new ItemGroup("sebsmodtab") {
        
        //set an icon
        @Override
        public ItemStack createIcon() {
            return new ItemStack(RegistryHandler.SEBASTIAN.get());
        }
        
        //change the order of the items (sorting)
        @Override
        public void fill(NonNullList<ItemStack> items) {
            //sort the tab
            modTabInit();
            
            super.fill(items);
            items.sort(tabSorter);
        }
    };
    
    static void modTabInit() {
        //get the list of items in order
        
        tabSorter = Ordering.explicit(ItemGroupOrder.TAB_ORDER).onResultOf(ItemStack::getItem);
    }
}
