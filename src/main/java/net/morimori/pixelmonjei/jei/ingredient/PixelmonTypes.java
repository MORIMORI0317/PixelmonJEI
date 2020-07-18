package net.morimori.pixelmonjei.jei.ingredient;

import com.pixelmongenerations.core.enums.EnumSpecies;
import com.pixelmongenerations.core.enums.EnumType;
import mezz.jei.api.recipe.IIngredientType;

public class PixelmonTypes {
    public static final IIngredientType<EnumSpecies> POKEMON = () -> EnumSpecies.class;
    public static final IIngredientType<EnumType> TYPE = () -> EnumType.class;

}
