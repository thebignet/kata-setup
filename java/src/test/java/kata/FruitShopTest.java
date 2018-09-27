package kata;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class FruitShopTest {

    @Test
    public void unPanierVideNeVautRien() {
        //Given
        Panier panier = new FruitShopPanier();
        Encaissement encaissement = new FruitShopEncaissement(panier);
        //When
        int montantTotal = encaissement.montantTotal();
        //Then
        Assertions.assertEquals(0, montantTotal);
    }
    @Test
    public void unPanierAvecUneBananeVaut150() {
        //Given
        Panier panier = new FruitShopPanier(1);

        Encaissement encaissement = new FruitShopEncaissement(panier);
        //When
        int montantTotal = encaissement.montantTotal();
        //Then
        Assertions.assertEquals(150, montantTotal);
    }
    @Test
    public void unPanierAvecDixBananeVaut1500() {
        //Given
        Panier panier = new FruitShopPanier(10);

        Encaissement encaissement = new FruitShopEncaissement(panier);
        //When
        int montantTotal = encaissement.montantTotal();
        //Then
        Assertions.assertEquals(1500, montantTotal);
    }
}
