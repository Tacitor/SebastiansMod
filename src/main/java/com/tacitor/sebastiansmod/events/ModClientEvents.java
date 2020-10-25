/*
 * Tacitor
 * Oct 25, 2020
 * 
 */
package com.tacitor.sebastiansmod.events;

import com.tacitor.sebastiansmod.SebastiansMod;
import com.tacitor.sebastiansmod.util.RegistryHandler;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/**
 *
 * @author Tacitor
 */
@Mod.EventBusSubscriber(modid = SebastiansMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ModClientEvents {
    
    @SubscribeEvent
    public static void onJumpEvent(LivingEvent.LivingJumpEvent event) {
        LivingEntity player = event.getEntityLiving();
        if (player.getHeldItemMainhand().getItem() == RegistryHandler.SEBASTIANIUM_INGOT.get()) {
            SebastiansMod.LOGGER.info("Ingot Jump!");
            World world = player.getEntityWorld();
            world.setBlockState(player.getPosition().add(0, -1, 0), RegistryHandler.SEBASTAINIUM_BLOCK.get().getDefaultState());
            
            
            //send chat message
            if (!event.getEntity().getEntityWorld().isRemote) {
                String msg = TextFormatting.AQUA + "Nice jump bro!";
                player.sendMessage(new StringTextComponent(msg));
            }
            
        }
    }
    
}
