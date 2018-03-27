public enum Ingredient {
    PAIN(Category.vegetable),
    FROMAGE(Category.vegetable),
    TOMATE(Category.vegetable),
    OIGNON(Category.vegetable),
    AGNEAU(Category.meat),
    POISSON(Category.fish),
    SALADE(Category.vegetable),
    VEAU(Category.meat);

    private Category category;

    Ingredient(Category category){
        this.category = category;
    }

    public boolean vegetarian(){
        return category == Category.vegetable;
    }

    public boolean pescoVeggie() {
        return vegetarian() || category == Category.fish;
    }
}
