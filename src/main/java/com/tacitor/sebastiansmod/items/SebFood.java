/*
 * Tacitor
 * Oct 10, 2020
 * Make the Sebatian item edible
 */
package com.tacitor.sebastiansmod.items;

import com.tacitor.sebastiansmod.SebastiansMod;
import java.util.function.Supplier;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

/**
 *
 * @author Tacitor
 */
public class SebFood extends Item {
    
    public SebFood() {
        super(new Item.Properties()
                .group(SebastiansMod.MODTAB)
                .food(new Food.Builder()
                        .hunger(1)
                        .saturation(0)
                        .effect(new EffectInstance(Effects.SATURATION, 10, 0), 1)
                        .build()
                )
        );
    }
    
}
