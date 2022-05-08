package br.com.unicamp.inf335.app;

import  br.com.unicamp.inf335.app.AnuncioBean;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.net.MalformedURLException;

import static  br.com.unicamp.inf335.app.TestProvider.anuncio;
import static  br.com.unicamp.inf335.app.TestProvider.urlFalha;

public class AnuncioBeanTest {

    private AnuncioBean anuncio;

    @ParameterizedTest
    @DisplayName("Desconto de 0% a 100%")
    @ValueSource(doubles = {0.0, 0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9, 1.0})
    public void testDiscount(double discount) throws MalformedURLException {
        anuncio = anuncio(discount);
        Assertions.assertNotNull(anuncio.getValor());
    }

    @Test
    @DisplayName("Desconto de 30%")
    public void test30Discount() throws MalformedURLException {
        anuncio = anuncio(0.3);
        Assertions.assertEquals(8400.0, anuncio.getValor());
    }

    @Test
    @DisplayName("Desconto inválido, maior do que 100%")
    public void testInvalidDiscountGreaterThan100() throws MalformedURLException {
        anuncio = anuncio(1.1);
        Assertions.assertThrows(IllegalArgumentException.class, anuncio::getValor);
    }

    @Test
    @DisplayName("Desconto inválido, menor do que 0%")
    public void testInvalidDiscountLessThan0() throws MalformedURLException {
        anuncio = anuncio(-0.1);
        Assertions.assertThrows(IllegalArgumentException.class, anuncio::getValor);
    }

    @Test
    @DisplayName("URL inválida")
    public void testInvalidUrl() {
        Assertions.assertThrows(MalformedURLException.class, () -> anuncio(0.3).setFotosUrl(urlFalha()));
    }
}
