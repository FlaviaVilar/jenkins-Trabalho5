package br.com.unicamp.inf335.app;

import br.com.unicamp.inf335.app.AnuncianteBean;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.security.InvalidParameterException;
import java.util.ArrayList;

import static  br.com.unicamp.inf335.app.TestProvider.anunciante;
import static  br.com.unicamp.inf335.app.TestProvider.anuncio2;

public class AnuncianteBeanTest {

    private AnuncianteBean anunciante;

    @BeforeEach
    void setUp() throws MalformedURLException {
        anunciante = anunciante();
    }

    @Test
    @DisplayName("Média de todos os anuncios de 0% a 100% (11 anuncios)")
    public void testAdvertiser() {
        Assertions.assertNotNull(anunciante);
        Assertions.assertAll("anunciante",
                () -> Assertions.assertEquals("73575784027", anunciante.getCPF()),
                () -> Assertions.assertEquals("Flavia", anunciante.getNome()),
                () -> Assertions.assertEquals(6000.0, anunciante.valorMedioAnuncios()),
                () -> Assertions.assertEquals(11, anunciante.getAnuncios().size()));
    }

    @Test
    @DisplayName("Média dos anuncios sem anuncio")
    public void testAdvertiserWithoutAd() {
        anunciante.setAnuncios(new ArrayList<>());
        Assertions.assertNotNull(anunciante);
        Assertions.assertThrows(ArithmeticException.class, () -> anunciante.valorMedioAnuncios());
    }

    @Test
    @DisplayName("Anunciante com CPF inválido")
    public void testAdvertiserWithoutInvalidDocument() {
        Assertions.assertThrows(InvalidParameterException.class, () -> anunciante.setCPF("7357578402"));
    }

    @Test
    @DisplayName("Adicionando anuncio")
    public void testAddAnnouncement() throws MalformedURLException {
        anunciante.addAnuncio(anuncio2(0.2));
        Assertions.assertEquals(12, anunciante.getAnuncios().size());
        Assertions.assertEquals(5860.0, anunciante.valorMedioAnuncios());
    }

    @Test
    @DisplayName("Removendo anuncio (10 anuncios)")
    public void testRemoveAnnouncement() {
        anunciante.removeAnuncio(0);
        Assertions.assertEquals(10, anunciante.getAnuncios().size());
        Assertions.assertEquals(5400.0, anunciante.valorMedioAnuncios());
    }

    @Test
    @DisplayName("Removendo anuncio com index inválido")
    public void testRemoveAnnouncementWithInvalidIndex() {
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> anunciante.removeAnuncio(11));
    }
}
