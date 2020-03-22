package net.morimori.pixelmonjei.jei.recipe.evolutions;

import java.util.ArrayList;
import java.util.List;

import com.pixelmonmod.pixelmon.entities.pixelmon.stats.evolution.Evolution;
import com.pixelmonmod.pixelmon.enums.EnumPokemon;

import mezz.jei.api.IJeiHelpers;
import net.morimori.pixelmonjei.util.PokemonHelper;

public class EvolutionsRecipeMaker {
	public static List<EvolutionsRecipe> getEvolutionsRecipes(IJeiHelpers helpers) {
		List<EvolutionsRecipe> recipes = new ArrayList<>();

		for (EnumPokemon pkm : EnumPokemon.values()) {

			for (Evolution po : PokemonHelper.getEvolutions(pkm)) {

				if (po != null)
					recipes.add(new EvolutionsRecipe(pkm, po.to.getSpecies(), po.conditions));

			}
		}

		return recipes;
	}

}
