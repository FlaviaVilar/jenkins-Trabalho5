package br.com.unicamp.inf335.app;

import  br.com.unicamp.inf335.app.AnuncianteBean;
import  br.com.unicamp.inf335.app.AnuncioBean;
import  br.com.unicamp.inf335.app.ProdutoBean;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class TestProvider {

    public static ProdutoBean produto1() {
        ProdutoBean produto = new ProdutoBean();
        produto.setCodigo("1");
        produto.setNome("Macbook");
        produto.setDescricao("Notebook da Apple");
        produto.setValor(12000.0);
        return produto;
    }

    public static ProdutoBean produto2() {
        ProdutoBean produto = new ProdutoBean();
        produto.setCodigo("2");
        produto.setNome("Iphone");
        produto.setDescricao("Celular da Apple");
        produto.setValor(5400.0);
        return produto;
    }

    public static AnuncioBean anuncio(double desconto) throws MalformedURLException {
        return new AnuncioBean(produto1(), url(), desconto);
    }

    public static AnuncioBean anuncio2(double desconto) throws MalformedURLException {
        return new AnuncioBean(produto2(), url(), desconto);
    }

    public static ArrayList<URL> url() throws MalformedURLException {
        ArrayList<URL> list = new ArrayList<>();
        URL url = new URL("https://www.google.com");
        list.add(url);
        return list;
    }

    public static ArrayList<URL> urlFalha() throws MalformedURLException {
        ArrayList<URL> list = new ArrayList<>();
        URL url = new URL("url");
        list.add(url);
        return list;
    }

    public static AnuncianteBean anunciante() throws MalformedURLException {
        AnuncianteBean anunciante = new AnuncianteBean();
        anunciante.setCPF("73575784027");
        anunciante.setNome("Flavia");
        anunciante.setAnuncios(listaDeAnuncios());
        return anunciante;
    }

    public static ArrayList<AnuncioBean> listaDeAnuncios() throws MalformedURLException {
        ArrayList<AnuncioBean> lista = new ArrayList<>();
        lista.add(anuncio(0.0));
        lista.add(anuncio(0.1));
        lista.add(anuncio(0.2));
        lista.add(anuncio(0.3));
        lista.add(anuncio(0.4));
        lista.add(anuncio(0.5));
        lista.add(anuncio(0.6));
        lista.add(anuncio(0.7));
        lista.add(anuncio(0.8));
        lista.add(anuncio(0.9));
        lista.add(anuncio(1.0));
        return lista;
    }
}
