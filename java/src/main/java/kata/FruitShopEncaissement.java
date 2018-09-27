package kata;

public class FruitShopEncaissement implements Encaissement {


    private final Panier panier;

    public FruitShopEncaissement(Panier panier) {
        this.panier = panier;
    }

    @Override
    public int montantTotal() {
        if(panier.nbBanane()>0) {
            return 150;
        }
        return 0;
    }
}
