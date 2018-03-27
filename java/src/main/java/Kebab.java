import java.util.List;

public class Kebab {
    List<Ingredient> ingredients;


    public boolean isVegetarian() {
        return ingredients.stream().allMatch(Ingredient::vegetarian);
    }
}
