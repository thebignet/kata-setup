public enum Ingredient {
    FROMAGE(true),
    TOMATE(true),
    OIGNON(true),
    AGNEAU(false),
    POISSON(false),
    SALADE(true),
    VEAU(false);

    private boolean isVegetarian;

    Ingredient(boolean isVegetarian){
        this.isVegetarian = isVegetarian;
    }

    public boolean vegetarian(){
        return isVegetarian;
    }
}
