package kata;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EncaissementTest {

    @Test
    public void unPanierVideNeVautRien() {
        //Given
        Panier panier = mock(Panier.class);
        Encaissement encaissement = new FruitShopEncaissement(panier);
        //When
        int montantTotal = encaissement.montantTotal();
        //Then
        Assertions.assertEquals(0, montantTotal);
    }

    @Test
    public void unPanierAvecUneBananeVaut150() {
        //Given
        Panier panier = mock(Panier.class);
        when(panier.nbBanane()).thenReturn(1);
        Encaissement encaissement = new FruitShopEncaissement(panier);
        //When
        int montantTotal = encaissement.montantTotal();
        //Then
        Assertions.assertEquals(150, montantTotal);
    }

}
