package net.morimori.pixelmonjei.jei.recipe.pokedex;

import java.util.ArrayList;
import java.util.List;

import com.pixelmonmod.pixelmon.enums.EnumPokemon;

import mezz.jei.api.IJeiHelpers;

public class PokeDexRecipeMaker {
	public static List<PokeDexRecipe> getPokeDexRecipes(IJeiHelpers helpers) {

		List<PokeDexRecipe> recipes = new ArrayList<>();

		for (EnumPokemon poke : EnumPokemon.values()) {
			recipes.add(new PokeDexRecipe(poke));
		}

		return recipes;

	}
}
