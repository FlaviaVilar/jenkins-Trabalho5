package br.com.unicamp.inf335.app;

import  br.com.unicamp.inf335.app.ProdutoBean;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static  br.com.unicamp.inf335.app.TestProvider.produto1;
import static  br.com.unicamp.inf335.app.TestProvider.produto2;

public class ProdutoBeanTest {

    private ProdutoBean produto1;
    private ProdutoBean produto2;

    @BeforeEach
    void setUp() {
        produto1 = produto1();
        produto2 = produto2();
    }

    @Test
    @DisplayName("Valor do produto 1 é maior do que o produto 2")
    public void testProduct1GreaterThanProduct2() {
        int compare = produto1.compareTo(produto2);
        int MAIOR = 1;
        Assertions.assertEquals(MAIOR, compare);
    }

    @Test
    @DisplayName("Valor do produto 2 é menor do que o produto 1")
    public void testProduct2LessThanProduct1() {
        int compare = produto2.compareTo(produto1);
        int MENOR = -1;
        Assertions.assertEquals(MENOR, compare);
    }

    @Test
    @DisplayName("Valor do produto 1 é idual ao valor do produto 2")
    public void testEqualValue() {
        produto1.setValor(5400.0);
        int compare = produto1.compareTo(produto2);
        int IGUAL = 0;
        Assertions.assertEquals(IGUAL, compare);
    }

}
