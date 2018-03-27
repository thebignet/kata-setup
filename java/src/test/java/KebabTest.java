import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class KebabTest {

    @Test
    void kebabWithSaladTomateOignonShouldBeVegetarian(){
        Kebab kebab = new Kebab();
        kebab.ingredients = List.of(Ingredient.SALADE, Ingredient.TOMATE, Ingredient.OIGNON);
        assertThat(kebab.isVegetarian()).isTrue();
    }
    @Test
    void kebabWithSaladAgneauTomateOignonShouldNotBeVegetarian(){
        Kebab kebab = new Kebab();
        kebab.ingredients = List.of(Ingredient.SALADE, Ingredient.AGNEAU, Ingredient.TOMATE, Ingredient.OIGNON);
        assertThat(kebab.isVegetarian()).isFalse();
    }
}