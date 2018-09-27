package kata;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PanierTest {

    @Test
    public void unPanierAVecUneBananeAUneBanane() {
        //Given
        Panier panier = new FruitShopPanier(1);
        //When
        int nombreDeBanane = panier.nbBanane();
        //Then
        Assertions.assertEquals(1, nombreDeBanane);
    }
    @Test
    public void unPanierVideNAPasDeBanane() {
        //Given
        Panier panier = new FruitShopPanier();
        //When
        int nombreDeBanane = panier.nbBanane();
        //Then
        Assertions.assertEquals(0, nombreDeBanane);
    }
}
