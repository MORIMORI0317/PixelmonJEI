package net.morimori.pixelmonjei.jei.ingredient;

import com.pixelmonmod.pixelmon.Pixelmon;
import com.pixelmonmod.pixelmon.enums.EnumPokemon;

import mezz.jei.api.ingredients.IIngredientHelper;
import net.morimori.pixelmonjei.util.PokemonHelper;

public class PokemonIngredientHelper implements IIngredientHelper<EnumPokemon> {

	@Override
	public EnumPokemon copyIngredient(EnumPokemon arg0) {

		return arg0;
	}

	@Override
	public String getDisplayName(EnumPokemon arg0) {

		return PokemonHelper.getPokemonDisplayName(arg0);
	}

	@Override
	public String getErrorInfo(EnumPokemon arg0) {

		return "Error";
	}

	@Override
	public EnumPokemon getMatch(Iterable<EnumPokemon> arg0, EnumPokemon arg1) {

		for (EnumPokemon pok : arg0) {

			if (pok == arg1)
				return pok;

		}

		return null;
	}

	@Override
	public String getModId(EnumPokemon arg0) {

		return Pixelmon.MODID;
	}

	@Override
	public String getResourceId(EnumPokemon arg0) {

		return arg0.name;
	}

	@Override
	public String getUniqueId(EnumPokemon arg0) {

		return arg0.name;
	}

	@Override
	public String getWildcardId(EnumPokemon arg0) {

		return "/";
	}

}
