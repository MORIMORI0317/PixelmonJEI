package net.morimori.pixelmonjei.jei;

import com.pixelmongenerations.common.item.ItemHammer;
import com.pixelmongenerations.core.config.PixelmonBlocks;
import com.pixelmongenerations.core.config.PixelmonItems;
import com.pixelmongenerations.core.enums.EnumSpecies;
import com.pixelmongenerations.core.enums.EnumType;
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
import net.morimori.pixelmonjei.jei.ingredient.*;
import net.morimori.pixelmonjei.jei.recipe.evolutions.EvolutionsRecipeCategory;
import net.morimori.pixelmonjei.jei.recipe.evolutions.EvolutionsRecipeMaker;
import net.morimori.pixelmonjei.jei.recipe.kousiki.KousikiRecipe;
import net.morimori.pixelmonjei.jei.recipe.kousiki.KousikiRecipeCategory;
import net.morimori.pixelmonjei.jei.recipe.pokeanvil.PokeAnvilRecipeCategory;
import net.morimori.pixelmonjei.jei.recipe.pokeanvil.PokeAnvilRecipeMaker;
import net.morimori.pixelmonjei.jei.recipe.pokedex.PokeDexRecipeCategory;
import net.morimori.pixelmonjei.jei.recipe.pokedex.PokeDexRecipeMaker;
import net.morimori.pixelmonjei.jei.recipe.pokemondrop.PokemonDropRecipeCategory;
import net.morimori.pixelmonjei.jei.recipe.pokemondrop.PokemonDropRecipeMaker;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@JEIPlugin
public class PixelmonJeiPlugin implements IModPlugin {
    public static String PokeAnvil = "pixelmon.anvil";
    public static String PokemonDrop = "pixelmon.drop";
    public static String PokeDex = "pixelmon.dex";
    public static String Kousiki = "pixelmon.kousiki";
    public static String Evolutions = "pixelmon.evolutions";
    @Nullable
    public static IIngredientRegistry ingredientRegistry;

    @Override
    public void register(IModRegistry registry) {
        ingredientRegistry = registry.getIngredientRegistry();

        JeiHelpers jeiHelpers = Internal.getHelpers();
        registry.addRecipes(PokeAnvilRecipeMaker.getPokeAnvilRecipes(jeiHelpers), PokeAnvil);

        registry.addRecipes(PokemonDropRecipeMaker.getPokemonDropRecipes(jeiHelpers), PokemonDrop);

        registry.addRecipes(PokeDexRecipeMaker.getPokeDexRecipes(jeiHelpers), PokeDex);

        registry.addRecipes(EvolutionsRecipeMaker.getEvolutionsRecipes(jeiHelpers), Evolutions);

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

        registry.addRecipeCategories(
                new EvolutionsRecipeCategory(guiHelper));

        registry.addRecipeCategories(new KousikiRecipeCategory(guiHelper));
    }

    @Override
    public void registerIngredients(IModIngredientRegistration registry) {
        List<EnumSpecies> pokemons = new ArrayList<>();
        pokemons.addAll(Arrays.asList(EnumSpecies.values()));
        registry.register(PixelmonTypes.POKEMON, pokemons, new PokemonIngredientHelper(), new PokemonIngredientRender());

        List<EnumType> types = new ArrayList<>();
        types.addAll(Arrays.asList(EnumType.values()));
        registry.register(PixelmonTypes.TYPE, types, new TypeIngredientHelper(), new TypeIngredientRender());
    }
}
