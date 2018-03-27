import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class KebabTest {

    @Test
    void kebabWithSaladTomateOignonShouldBeVegetarian(){
        Kebab kebab = new Kebab();
        kebab.ingredients = List.of(Ingredient.PAIN, Ingredient.SALADE, Ingredient.TOMATE, Ingredient.OIGNON);
        assertThat(kebab.isVegetarian()).isTrue();
    }
    @Test
    void kebabWithSaladAgneauTomateOignonShouldNotBeVegetarian(){
        Kebab kebab = new Kebab();
        kebab.ingredients = List.of(Ingredient.PAIN, Ingredient.SALADE, Ingredient.AGNEAU, Ingredient.TOMATE, Ingredient.OIGNON);
        assertThat(kebab.isVegetarian()).isFalse();
    }

    @Test
    void kebabWithSaladPoissonTomateOignonShouldBePescoVeggie(){
        Kebab kebab = new Kebab();
        kebab.ingredients = List.of(Ingredient.PAIN, Ingredient.SALADE, Ingredient.POISSON, Ingredient.TOMATE, Ingredient.OIGNON);
        assertThat(kebab.isPescoVeggie()).isTrue();
    }
    @Test
    void kebabWithSaladTomateOignonSansOignon(){
        Kebab kebab = new Kebab();
        kebab.ingredients = List.of(Ingredient.PAIN, Ingredient.SALADE, Ingredient.TOMATE, Ingredient.OIGNON, Ingredient.OIGNON);
        Kebab kebabSansOignon = kebab.removeOignons();
        assertThat(kebabSansOignon.ingredients).containsExactly(Ingredient.PAIN, Ingredient.SALADE, Ingredient.TOMATE);
    }
    @Test
    void kebabWithSaladTomateDoubleCheese(){
        Kebab kebab = new Kebab();
        kebab.ingredients = List.of(Ingredient.PAIN, Ingredient.SALADE, Ingredient.TOMATE, Ingredient.FROMAGE);
        Kebab kebabSansOignon = kebab.doubleCheese();
        assertThat(kebabSansOignon.ingredients).containsExactly(Ingredient.PAIN, Ingredient.SALADE, Ingredient.TOMATE,
                Ingredient.FROMAGE, Ingredient.FROMAGE);
    }
    @Test
    void kebabWithSaladQuadrupleCheeseTomateDoubleCheese(){
        Kebab kebab = new Kebab();
        kebab.ingredients = List.of(Ingredient.PAIN, Ingredient.SALADE, Ingredient.FROMAGE, Ingredient.FROMAGE, Ingredient.TOMATE, Ingredient.FROMAGE);
        Kebab kebabSansOignon = kebab.doubleCheese();
        assertThat(kebabSansOignon.ingredients).containsExactly(Ingredient.PAIN, Ingredient.SALADE, Ingredient.FROMAGE, Ingredient.FROMAGE,
                Ingredient.FROMAGE, Ingredient.FROMAGE, Ingredient.TOMATE, Ingredient.FROMAGE, Ingredient.FROMAGE);
    }
    @Test
    void kebabWithSaladQuadrupleCheeseTomate(){
        Kebab kebab = new Kebab();
        kebab.ingredients = List.of(Ingredient.PAIN, Ingredient.SALADE, Ingredient.FROMAGE, Ingredient.FROMAGE, Ingredient.TOMATE, Ingredient.FROMAGE);
        Kebab kebabDoubleCheese = kebab.doubleCheese();
        Kebab kebabQuadrupleCheese = kebabDoubleCheese.doubleCheese();
        assertThat(kebabQuadrupleCheese.ingredients).containsExactly(Ingredient.PAIN, Ingredient.SALADE, Ingredient.FROMAGE, Ingredient.FROMAGE,
                Ingredient.FROMAGE, Ingredient.FROMAGE, Ingredient.TOMATE);
    }
}