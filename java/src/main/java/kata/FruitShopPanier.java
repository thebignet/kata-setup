package kata;

public class FruitShopPanier implements Panier {
    private final int nombreDeBanane;

    public FruitShopPanier(int nombreDeBanane) {
        this.nombreDeBanane = nombreDeBanane;
    }

    public FruitShopPanier() {
        this.nombreDeBanane = 0;
    }

    @Override
    public int nbBanane() {
        return nombreDeBanane;
    }
}
