package cursedflames.bountifulbaubles.common.datagen.recipe;

import java.util.function.Consumer;

import cursedflames.bountifulbaubles.common.BountifulBaubles;
import cursedflames.bountifulbaubles.common.item.ModItems;
import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.data.ShapelessRecipeBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

public class Recipes extends RecipeProvider implements IConditionBuilder {
	public Recipes(DataGenerator generatorIn) {
		super(generatorIn);
	}

	@Override
	protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {
		// TODO add mod integration recipes - e.g. botania runes
//		ConditionalRecipe.builder().addCondition(
//				and(not(modLoaded("minecraft")))
//		);
		registerMainCraftingRecipes(consumer);
		registerDisintegrationCraftingRecipes(consumer);
		registerSpectralSiltCraftingRecipes(consumer);
	}
	
	protected void registerMainCraftingRecipes(Consumer<IFinishedRecipe> consumer) {
		ShapedRecipeBuilder.shapedRecipe(ModItems.ankh_charm)
				.patternLine("glg")
				.patternLine("fsa")
				.patternLine("gvg")
				.key('g', Items.GOLD_BLOCK)
				.key('l', ModItems.sunglasses)
				.key('f', ModItems.ring_free_action)
				.key('s', ModItems.mixed_dragon_scale)
				.key('a', ModItems.apple)
				.key('v', ModItems.vitamins)
				.setGroup(BountifulBaubles.MODID)
				.addCriterion("mixed_dragon_scale",
						InventoryChangeTrigger.Instance.forItems(ModItems.mixed_dragon_scale))
				.build(consumer);
		
		CompoundNBT temp = new CompoundNBT();
		temp.putString("Potion", "minecraft:fire_resistance");
		ItemStack potionFireRes = new ItemStack(Items.POTION);
		potionFireRes.setTag(temp.copy());
		ItemStack potionFireResSplash = new ItemStack(Items.SPLASH_POTION);
		potionFireResSplash.setTag(temp.copy());
		ItemStack potionFireResLinger = new ItemStack(Items.LINGERING_POTION);
		potionFireResLinger.setTag(temp.copy());

		temp.putString("Potion", "minecraft:long_fire_resistance");
		ItemStack potionFireResLong = new ItemStack(Items.POTION);
		potionFireResLong.setTag(temp.copy());
		ItemStack potionFireResSplashLong = new ItemStack(Items.SPLASH_POTION);
		potionFireResSplashLong.setTag(temp.copy());
		ItemStack potionFireResLingerLong = new ItemStack(Items.LINGERING_POTION);
		potionFireResLingerLong.setTag(temp.copy());
		
		// TODO figure out NBT recipes and replace magma cream with fire resist potions
		ShapedRecipeBuilder.shapedRecipe(ModItems.obsidian_skull)
				.patternLine("odo")
				.patternLine("psp")
				.patternLine("odo")
				.key('o', Items.OBSIDIAN)
				.key('d', Items.BLAZE_POWDER)
				.key('s', Tags.Items.HEADS) // TODO maybe only want skulls, not heads?
				.key('p', /*Ingredient.fromStacks(
						potionFireRes, potionFireResSplash, 
						potionFireResLinger, potionFireResLong, 
						potionFireResSplashLong, potionFireResLingerLong)*/ Items.MAGMA_CREAM)
				.setGroup(BountifulBaubles.MODID)
				.addCriterion("obsidian", InventoryChangeTrigger.Instance.forItems(Items.OBSIDIAN))
				.build(consumer);
		
		ShapedRecipeBuilder.shapedRecipe(ModItems.black_dragon_scale)
				.patternLine("n")
				.patternLine("e")
				.patternLine("b")
				.key('n', Items.NETHER_STAR)
				.key('e', ModItems.ender_dragon_scale)
				.key('b', ModItems.broken_black_dragon_scale)
				.setGroup(BountifulBaubles.MODID)
				.addCriterion("broken_black_dragon_scale",
						InventoryChangeTrigger.Instance.forItems(ModItems.broken_black_dragon_scale))
				.build(consumer);
		ShapedRecipeBuilder.shapedRecipe(ModItems.amulet_sin_gluttony)
				.patternLine("c")
				.patternLine("a")
				.patternLine("g")
				.key('c', Items.CAKE)
				.key('a', ModItems.amulet_sin_empty)
				.key('g', Items.GOLDEN_APPLE)
				.setGroup(BountifulBaubles.MODID)
				.addCriterion("amulet_sin_empty",
						InventoryChangeTrigger.Instance.forItems(ModItems.amulet_sin_empty))
				.build(consumer);
		ShapedRecipeBuilder.shapedRecipe(ModItems.amulet_sin_pride) // TODO readd gold crown, revert temp recipe
				.patternLine(" d ")
				.patternLine("dad")
				.patternLine(" g ")
				.key('d', Items.DIAMOND)
				.key('a', ModItems.amulet_sin_empty)
				.key('g', Items.GOLD_BLOCK)
				.setGroup(BountifulBaubles.MODID)
				.addCriterion("amulet_sin_empty",
						InventoryChangeTrigger.Instance.forItems(ModItems.amulet_sin_empty))
				.build(consumer);
		ShapedRecipeBuilder.shapedRecipe(ModItems.amulet_sin_wrath)
				.patternLine(" b ")
				.patternLine("bab")
				.patternLine(" h ")
				.key('b', Items.BONE)
				.key('a', ModItems.amulet_sin_empty)
				.key('h', Tags.Items.HEADS)
				.setGroup(BountifulBaubles.MODID)
				.addCriterion("amulet_sin_empty",
						InventoryChangeTrigger.Instance.forItems(ModItems.amulet_sin_empty))
				.build(consumer);
		ShapedRecipeBuilder.shapedRecipe(ModItems.wormhole_mirror)
				.patternLine("owo")
				.patternLine("pMp")
				.patternLine("opo")
				.key('o', Items.OBSIDIAN)
				.key('w', ModItems.ender_dragon_scale)
				.key('M', ModItems.magic_mirror)
				.key('p', ModItems.potion_wormhole)
				.setGroup(BountifulBaubles.MODID)
				.addCriterion("magic_mirror",
						InventoryChangeTrigger.Instance.forItems(ModItems.magic_mirror))
				.build(consumer);
		ShapelessRecipeBuilder.shapelessRecipe(ModItems.phylactery_charm)
				.addIngredient(Items.WITHER_SKELETON_SKULL)
				.addIngredient(Items.DIAMOND) // TODO rubies
				.addIngredient(ModItems.magic_mirror)
				.addIngredient(ModItems.broken_heart)
				.setGroup(BountifulBaubles.MODID)
				.addCriterion("broken_heart",
						InventoryChangeTrigger.Instance.forItems(ModItems.broken_heart))
				.build(consumer);
		ShapedRecipeBuilder.shapedRecipe(ModItems.disintegration_tablet)
				.patternLine("qbq")
				.patternLine("brb")
				.patternLine("qbq")
				.key('q', Items.QUARTZ)
				.key('r', Items.REDSTONE)
				.key('b', Items.BLAZE_POWDER)
				.setGroup(BountifulBaubles.MODID)
				.addCriterion("quartz",
						InventoryChangeTrigger.Instance.forItems(Items.QUARTZ))
				.build(consumer);
	}
	
	private static void addDisintegrationRecipe(Consumer<IFinishedRecipe> consumer, Item item) {
		addDisintegrationRecipe(consumer, item, 1);
	}
	private static void addDisintegrationRecipe(Consumer<IFinishedRecipe> consumer, Item item, int amt) {
		ShapelessRecipeBuilder.shapelessRecipe(ModItems.spectral_silt, amt)
				.addIngredient(item)
				.addIngredient(ModItems.disintegration_tablet)
				.setGroup(BountifulBaubles.MODID)
				.addCriterion("disintegrationTablet",
						InventoryChangeTrigger.Instance.forItems(ModItems.disintegration_tablet))
				.build(consumer,
						new ResourceLocation(BountifulBaubles.MODID,
								"disintegration/"+item.getRegistryName().getPath()));
	}
	

	protected void registerDisintegrationCraftingRecipes(Consumer<IFinishedRecipe> consumer) {
		addDisintegrationRecipe(consumer, Items.DIAMOND_BLOCK);
		addDisintegrationRecipe(consumer, Items.EMERALD_BLOCK);
		
		addDisintegrationRecipe(consumer, ModItems.balloon);
		addDisintegrationRecipe(consumer, ModItems.sunglasses);
		// allow ender dragon scale as an endgame way of getting items without looting dungeons
		addDisintegrationRecipe(consumer, ModItems.ender_dragon_scale);
		addDisintegrationRecipe(consumer, ModItems.broken_black_dragon_scale);
		addDisintegrationRecipe(consumer, ModItems.black_dragon_scale, 2);
		addDisintegrationRecipe(consumer, ModItems.mixed_dragon_scale, 2);
		addDisintegrationRecipe(consumer, ModItems.ankh_charm, 5);
		addDisintegrationRecipe(consumer, ModItems.shield_cobalt);
		addDisintegrationRecipe(consumer, ModItems.shield_obsidian);
		addDisintegrationRecipe(consumer, ModItems.shield_ankh, 7);
		addDisintegrationRecipe(consumer, ModItems.magic_mirror);
		addDisintegrationRecipe(consumer, ModItems.wormhole_mirror, 2);
		addDisintegrationRecipe(consumer, ModItems.lucky_horseshoe);
		addDisintegrationRecipe(consumer, ModItems.amulet_sin_empty);
		addDisintegrationRecipe(consumer, ModItems.amulet_sin_gluttony);
		addDisintegrationRecipe(consumer, ModItems.amulet_sin_pride);
		addDisintegrationRecipe(consumer, ModItems.amulet_sin_wrath);
		addDisintegrationRecipe(consumer, ModItems.broken_heart);
		addDisintegrationRecipe(consumer, ModItems.phylactery_charm, 2);
		addDisintegrationRecipe(consumer, ModItems.amulet_cross);
		addDisintegrationRecipe(consumer, ModItems.gloves_dexterity);
	}
	

	protected void registerSpectralSiltCraftingRecipes(Consumer<IFinishedRecipe> consumer) {
		ShapedRecipeBuilder.shapedRecipe(ModItems.balloon)
				.patternLine("sws")
				.patternLine("w w")
				.patternLine("sws")
				.key('s', ModItems.spectral_silt)
				.key('w', ItemTags.WOOL)
				.setGroup(BountifulBaubles.MODID)
				.addCriterion("silt",
						InventoryChangeTrigger.Instance.forItems(ModItems.spectral_silt))
				.build(consumer, new ResourceLocation(BountifulBaubles.MODID, "silt/balloon"));
		ShapedRecipeBuilder.shapedRecipe(ModItems.sunglasses)
				.patternLine("s s")
				.patternLine("gSg")
				.patternLine("s s")
				.key('s', ModItems.spectral_silt)
				.key('S', Items.STICK)
				.key('g', Items.BLACK_STAINED_GLASS)
				.setGroup(BountifulBaubles.MODID)
				.addCriterion("silt",
						InventoryChangeTrigger.Instance.forItems(ModItems.spectral_silt))
				.build(consumer, new ResourceLocation(BountifulBaubles.MODID, "silt/sunglasses"));
		ShapedRecipeBuilder.shapedRecipe(ModItems.broken_black_dragon_scale)
				.patternLine("sds")
				.patternLine("sSs")
				.patternLine("sss")
				.key('s', ModItems.spectral_silt)
				.key('S', ModItems.ender_dragon_scale)
				.key('d', Items.BLACK_DYE)
				.setGroup(BountifulBaubles.MODID)
				.addCriterion("silt",
						InventoryChangeTrigger.Instance.forItems(ModItems.spectral_silt))
				.build(consumer, new ResourceLocation(BountifulBaubles.MODID, "silt/broken_black_dragon_scale"));
		ShapedRecipeBuilder.shapedRecipe(ModItems.shield_cobalt)
				.patternLine("sDs")
				.patternLine("sSs")
				.patternLine("sss")
				.key('s', ModItems.spectral_silt)
				.key('S', Items.SHIELD)
				.key('D', Items.DIAMOND_BLOCK)
				.setGroup(BountifulBaubles.MODID)
				.addCriterion("silt",
						InventoryChangeTrigger.Instance.forItems(ModItems.spectral_silt))
				.build(consumer, new ResourceLocation(BountifulBaubles.MODID, "silt/shield_cobalt"));
		ShapedRecipeBuilder.shapedRecipe(ModItems.magic_mirror)
				.patternLine("sps")
				.patternLine("gdg")
				.patternLine("sps")
				.key('s', ModItems.spectral_silt)
				.key('p', ModItems.potion_recall)
				.key('d', Items.DIAMOND)
				.key('g', Tags.Items.GLASS)
				.setGroup(BountifulBaubles.MODID)
				.addCriterion("silt",
						InventoryChangeTrigger.Instance.forItems(ModItems.spectral_silt))
				.build(consumer, new ResourceLocation(BountifulBaubles.MODID, "silt/magic_mirror"));
		ShapedRecipeBuilder.shapedRecipe(ModItems.lucky_horseshoe)
				.patternLine("gsg")
				.patternLine("gsg")
				.patternLine("sgs")
				.key('s', ModItems.spectral_silt)
				.key('g', Items.GOLD_INGOT)
				.setGroup(BountifulBaubles.MODID)
				.addCriterion("silt",
						InventoryChangeTrigger.Instance.forItems(ModItems.spectral_silt))
				.build(consumer, new ResourceLocation(BountifulBaubles.MODID, "silt/lucky_horseshoe"));
		ShapedRecipeBuilder.shapedRecipe(ModItems.amulet_sin_empty)
				.patternLine("sSs")
				.patternLine("sis")
				.patternLine("sss")
				.key('s', ModItems.spectral_silt)
				.key('i', Items.IRON_INGOT)
				.key('S', Items.STRING)
				.setGroup(BountifulBaubles.MODID)
				.addCriterion("silt",
						InventoryChangeTrigger.Instance.forItems(ModItems.spectral_silt))
				.build(consumer, new ResourceLocation(BountifulBaubles.MODID, "silt/amulet_sin_empty"));
		ShapedRecipeBuilder.shapedRecipe(ModItems.broken_heart) // TODO recipe that makes more sense
				.patternLine("sds")
				.patternLine("shs")
				.patternLine("sds")
				.key('s', ModItems.spectral_silt)
				.key('h', ModItems.shulker_heart)
				.key('d', Items.DIAMOND)
				.setGroup(BountifulBaubles.MODID)
				.addCriterion("silt",
						InventoryChangeTrigger.Instance.forItems(ModItems.spectral_silt))
				.build(consumer, new ResourceLocation(BountifulBaubles.MODID, "silt/broken_heart"));
		ShapedRecipeBuilder.shapedRecipe(ModItems.amulet_cross)
				.patternLine("sSs")
				.patternLine("sgs")
				.patternLine("sgs")
				.key('s', ModItems.spectral_silt)
				.key('g', Items.GOLD_INGOT)
				.key('S', Items.STRING)
				.setGroup(BountifulBaubles.MODID)
				.addCriterion("silt",
						InventoryChangeTrigger.Instance.forItems(ModItems.spectral_silt))
				.build(consumer, new ResourceLocation(BountifulBaubles.MODID, "silt/amulet_cross"));
		ShapedRecipeBuilder.shapedRecipe(ModItems.gloves_dexterity)
				.patternLine("sls")
				.patternLine("lel")
				.patternLine("sis")
				.key('s', ModItems.spectral_silt)
				.key('i', Items.IRON_INGOT)
				.key('l', Items.LEATHER)
				.key('e', Items.EMERALD)
				.setGroup(BountifulBaubles.MODID)
				.addCriterion("silt",
						InventoryChangeTrigger.Instance.forItems(ModItems.spectral_silt))
				.build(consumer, new ResourceLocation(BountifulBaubles.MODID, "silt/gloves_dexterity"));
	}
}
