package net.morimori.pixelmonjei.jei.ingredient;

import com.pixelmongenerations.core.Pixelmon;
import com.pixelmongenerations.core.enums.EnumSpecies;

import mezz.jei.api.ingredients.IIngredientHelper;
import net.morimori.pixelmonjei.util.PokemonHelper;

public class PokemonIngredientHelper implements IIngredientHelper<EnumSpecies> {

	@Override
	public EnumSpecies copyIngredient(EnumSpecies arg0) {

		return arg0;
	}

	@Override
	public String getDisplayName(EnumSpecies arg0) {

		return PokemonHelper.getPokemonDisplayName(arg0);
	}

	@Override
	public String getErrorInfo(EnumSpecies arg0) {

		return "Error";
	}

	@Override
	public EnumSpecies getMatch(Iterable<EnumSpecies> arg0, EnumSpecies arg1) {

		for (EnumSpecies pok : arg0) {

			if (pok == arg1)
				return pok;

		}

		return null;
	}

	@Override
	public String getModId(EnumSpecies arg0) {

		return Pixelmon.MODID;
	}

	@Override
	public String getResourceId(EnumSpecies arg0) {

		return arg0.name;
	}

	@Override
	public String getUniqueId(EnumSpecies arg0) {

		return arg0.name;
	}

	@Override
	public String getWildcardId(EnumSpecies arg0) {

		return "/";
	}

}
