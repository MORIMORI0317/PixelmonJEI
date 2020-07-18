package net.morimori.pixelmonjei.jei.ingredient;


import com.pixelmongenerations.core.Pixelmon;
import com.pixelmongenerations.core.enums.EnumType;
import mezz.jei.api.ingredients.IIngredientHelper;
import net.morimori.pixelmonjei.util.PokemonHelper;

public class TypeIngredientHelper implements IIngredientHelper<EnumType> {

    @Override
    public EnumType copyIngredient(EnumType arg0) {

        return arg0;
    }

    @Override
    public String getDisplayName(EnumType arg0) {

        return PokemonHelper.getTypeDisplayName(arg0);
    }

    @Override
    public String getErrorInfo(EnumType arg0) {

        return "Error";
    }

    @Override
    public EnumType getMatch(Iterable<EnumType> arg0, EnumType arg1) {

        for (EnumType type : arg0) {

            if (type == arg1)
                return type;

        }

        return null;
    }

    @Override
    public String getModId(EnumType arg0) {

        return Pixelmon.MODID;
    }

    @Override
    public String getResourceId(EnumType arg0) {

        return arg0.getName();
    }

    @Override
    public String getUniqueId(EnumType arg0) {

        return arg0.getName();
    }

    @Override
    public String getWildcardId(EnumType arg0) {

        return "/";
    }

}
