package net.morimori.pixelmonjei.jei.ingredient;

import com.pixelmonmod.pixelmon.enums.EnumPokemon;

import mezz.jei.api.recipe.IIngredientType;

public class PixelmonTypes {
	public static final IIngredientType<EnumPokemon> POKEMON = () -> EnumPokemon.class;
}
