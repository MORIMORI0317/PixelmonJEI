package net.morimori.pixelmonjei.jei.recipe.evolutions;

import java.util.ArrayList;


import com.pixelmongenerations.common.entity.pixelmon.stats.evolution.conditions.EvoCondition;
import com.pixelmongenerations.core.enums.EnumSpecies;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.morimori.pixelmonjei.jei.ingredient.PixelmonTypes;

public class EvolutionsRecipe implements IRecipeWrapper {
	private final EnumSpecies topokemon;
	private final EnumSpecies frompokemon;
	private final ArrayList<EvoCondition> conditions;

	public EvolutionsRecipe(EnumSpecies to, EnumSpecies from, ArrayList<EvoCondition> conditions) {
		this.frompokemon = from;
		this.topokemon = to;
		this.conditions = conditions;
	}

	@Override
	public void getIngredients(IIngredients ingredients) {
		ingredients.setInput(PixelmonTypes.POKEMON, topokemon);
		ingredients.setOutput(PixelmonTypes.POKEMON, frompokemon);
	}

}
