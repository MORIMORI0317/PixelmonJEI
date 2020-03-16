package net.morimori.pixelmonjei.jei;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import com.pixelmonmod.pixelmon.config.PixelmonBlocks;
import com.pixelmonmod.pixelmon.config.PixelmonItems;
import com.pixelmonmod.pixelmon.enums.EnumPokemon;
import com.pixelmonmod.pixelmon.enums.EnumType;
import com.pixelmonmod.pixelmon.items.ItemHammer;

import mezz.jei.Internal;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;
import mezz.jei.api.ingredients.IIngredientRegistry;
import mezz.jei.api.ingredients.IModIngredientRegistration;
import mezz.jei.api.recipe.IRecipeCategoryRegistration;
import mezz.jei.gui.GuiHelper;
import mezz.jei.runtime.JeiHelpers;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.morimori.pixelmonjei.jei.ingredient.PixelmonTypes;
import net.morimori.pixelmonjei.jei.ingredient.PokemonIngredientHelper;
import net.morimori.pixelmonjei.jei.ingredient.PokemonIngredientRender;
import net.morimori.pixelmonjei.jei.ingredient.TypeIngredientHelper;
import net.morimori.pixelmonjei.jei.ingredient.TypeIngredientRender;
import net.morimori.pixelmonjei.jei.recipe.kousiki.KousikiRecipe;
import net.morimori.pixelmonjei.jei.recipe.kousiki.KousikiRecipeCategory;
import net.morimori.pixelmonjei.jei.recipe.pokeanvil.PokeAnvilRecipeCategory;
import net.morimori.pixelmonjei.jei.recipe.pokeanvil.PokeAnvilRecipeMaker;
import net.morimori.pixelmonjei.jei.recipe.pokedex.PokeDexRecipeCategory;
import net.morimori.pixelmonjei.jei.recipe.pokedex.PokeDexRecipeMaker;
import net.morimori.pixelmonjei.jei.recipe.pokemondrop.PokemonDropRecipeCategory;
import net.morimori.pixelmonjei.jei.recipe.pokemondrop.PokemonDropRecipeMaker;
import scala.actors.threadpool.Arrays;

@JEIPlugin
public class PixelmonJeiPlugin implements IModPlugin {
	public static String PokeAnvil = "pixelmon.anvil";
	public static String PokemonDrop = "pixelmon.drop";
	public static String PokeDex = "pixelmon.dex";
	public static String Kousiki = "pixelmon.kousiki";
	@Nullable
	public static IIngredientRegistry ingredientRegistry;

	@Override
	public void register(IModRegistry registry) {
		ingredientRegistry = registry.getIngredientRegistry();

		JeiHelpers jeiHelpers = Internal.getHelpers();
		registry.addRecipes(PokeAnvilRecipeMaker.getPokeAnvilRecipes(jeiHelpers), PokeAnvil);

		registry.addRecipes(PokemonDropRecipeMaker.getPokemonDropRecipes(jeiHelpers), PokemonDrop);

		registry.addRecipes(PokeDexRecipeMaker.getPokeDexRecipes(jeiHelpers), PokeDex);

		registry.addRecipeCatalyst(new ItemStack(PixelmonBlocks.anvil), PokeAnvil);

		registry.addRecipeCatalyst(new ItemStack(PixelmonItems.pokedex), PokeDex);

		for (Item it : ForgeRegistries.ITEMS) {
			if (it instanceof ItemHammer)
				registry.addRecipeCatalyst(new ItemStack(it), PokeAnvil);
		}

		//	registry.addRecipeClickArea(GuiMechanicalAnvil.class, 78, 32, 28, 23, PokeAnvil);
		List<KousikiRecipe> krecipes = new ArrayList<>();
		krecipes.add(new KousikiRecipe());
		registry.addRecipes(krecipes, Kousiki);
	}

	@Override
	public void registerCategories(IRecipeCategoryRegistration registry) {
		JeiHelpers jeiHelpers = Internal.getHelpers();
		GuiHelper guiHelper = jeiHelpers.getGuiHelper();

		registry.addRecipeCategories(
				new PokeAnvilRecipeCategory(guiHelper));

		registry.addRecipeCategories(
				new PokeDexRecipeCategory(guiHelper));

		registry.addRecipeCategories(
				new PokemonDropRecipeCategory(guiHelper));

		registry.addRecipeCategories(new KousikiRecipeCategory(guiHelper));
	}

	@Override
	public void registerIngredients(IModIngredientRegistration registry) {
		registry.register(PixelmonTypes.POKEMON, Arrays.asList(EnumPokemon.values()), new PokemonIngredientHelper(),
				new PokemonIngredientRender());

		registry.register(PixelmonTypes.TYPE, Arrays.asList(EnumType.values()), new TypeIngredientHelper(),
				new TypeIngredientRender());
	}
}
