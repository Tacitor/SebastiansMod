/*
 * Tacitor
 * Oct 12, 2020
 * World generation for Sebastainium ore
 */
package com.tacitor.sebastiansmod.world.gen;

import com.tacitor.sebastiansmod.SebastiansMod;
import com.tacitor.sebastiansmod.util.RegistryHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.pattern.BlockMatcher;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.registries.ForgeRegistries;

/**
 *
 * @author Tacitor
 */
@Mod.EventBusSubscriber(modid = SebastiansMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class SebOreGen {
    
    public static OreFeatureConfig.FillerBlockType END_STONE = OreFeatureConfig.FillerBlockType.create("END_STONE", "end_stone", new BlockMatcher(Blocks.END_STONE));
    
    @SubscribeEvent
    public static void generateOres(FMLLoadCompleteEvent event) {
        for (Biome biome : ForgeRegistries.BIOMES) {
            
            //End generation
            if (biome.getCategory() == Biome.Category.THEEND) {
                genOre(biome, 7, 3, 5, 80, END_STONE , RegistryHandler.SEBASTAINIUM_ORE.get().getDefaultState(), 6); //biome = biome, count = rarity, bottomOffset = lowest y value, topOffset = hight subtracted from max, max = highest y value
            }
        }
    }
    
    protected static void genOre(Biome biome, int count, int bottomOffset, int topOffset, int max, OreFeatureConfig.FillerBlockType filler, BlockState defaultBlockState, int size) {
        CountRangeConfig range = new CountRangeConfig(count, bottomOffset, topOffset, max);
        OreFeatureConfig feature = new OreFeatureConfig(filler, defaultBlockState, size);
        ConfiguredPlacement config = Placement.COUNT_RANGE.configure(range);
        
        //add the feature
        biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(feature).withPlacement(config));
    }
}
