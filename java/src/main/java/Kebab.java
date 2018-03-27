import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Kebab {
    List<Ingredient> ingredients;


    public boolean isVegetarian() {
        return ingredients.stream().allMatch(Ingredient::vegetarian);
    }

    public boolean isPescoVeggie() {
        return ingredients.stream().allMatch(Ingredient::pescoVeggie);
    }

    public Kebab removeOignons() {
        ingredients = ingredients.stream().filter(ingredient -> ingredient != Ingredient.OIGNON).collect(Collectors.toList());
        return this;
    }

    public Kebab doubleCheese() {
        ingredients = ingredients.stream()
                .flatMap(ingredient -> ingredient == Ingredient.FROMAGE ? Stream.of(Ingredient.FROMAGE, Ingredient.FROMAGE) : Stream.of(ingredient))
                .collect(Collectors.toList());
        return this;
    }
}
