package net.morimori.pixelmonjei.jei;

import javax.annotation.Nullable;

import com.pixelmonmod.pixelmon.client.gui.machines.mechanicalanvil.GuiMechanicalAnvil;
import com.pixelmonmod.pixelmon.config.PixelmonBlocks;
import com.pixelmonmod.pixelmon.items.ItemHammer;

import mezz.jei.Internal;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;
import mezz.jei.api.ingredients.IIngredientRegistry;
import mezz.jei.api.recipe.IRecipeCategoryRegistration;
import mezz.jei.gui.GuiHelper;
import mezz.jei.runtime.JeiHelpers;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.morimori.pixelmonjei.jei.pokeanvil.PokeAnvilRecipeCategory;
import net.morimori.pixelmonjei.jei.pokeanvil.PokeAnvilRecipeMaker;
import net.morimori.pixelmonjei.jei.pokemondrop.PokemonDropRecipeCategory;
import net.morimori.pixelmonjei.jei.pokemondrop.PokemonDropRecipeMaker;

@JEIPlugin
public class PixelmonJeiPlugin implements IModPlugin {
	public static String PokeAnvil = "pixelmon.anvil";
	public static String PokemonDrop = "pixelmon.drop";

	@Nullable
	public static IIngredientRegistry ingredientRegistry;

	@Override
	public void register(IModRegistry registry) {
		ingredientRegistry = registry.getIngredientRegistry();

		JeiHelpers jeiHelpers = Internal.getHelpers();
		registry.addRecipes(PokeAnvilRecipeMaker.getPokeAnvilRecipes(jeiHelpers), PokeAnvil);

		registry.addRecipes(PokemonDropRecipeMaker.getPokemonDropRecipes(jeiHelpers), PokemonDrop);

		registry.addRecipeCatalyst(new ItemStack(PixelmonBlocks.anvil), PokeAnvil);
		registry.addRecipeCatalyst(new ItemStack(PixelmonBlocks.mechanicalAnvil), PokeAnvil);

		for (Item it : ForgeRegistries.ITEMS) {
			if (it instanceof ItemHammer)
				registry.addRecipeCatalyst(new ItemStack(it), PokeAnvil);
		}

		registry.addRecipeClickArea(GuiMechanicalAnvil.class, 78, 32, 28, 23, PokeAnvil);

	}

	@Override
	public void registerCategories(IRecipeCategoryRegistration registry) {
		JeiHelpers jeiHelpers = Internal.getHelpers();
		GuiHelper guiHelper = jeiHelpers.getGuiHelper();

		registry.addRecipeCategories(
				new PokeAnvilRecipeCategory(guiHelper));

		registry.addRecipeCategories(
				new PokemonDropRecipeCategory(guiHelper));
	}

}
