package com.convictvs.edisone.firstprinciples.data;

import com.convictvs.edisone.firstprinciples.adapters.ItemListView;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by edisone on 27/01/16.
 */
public class LoadEstudos {
    private List<ItemListView> lista_estudos = new ArrayList<ItemListView>();

    public LoadEstudos(int imageid) {
        addItem(imageid, 0, "Introdução", "file:///android_asset/estudo_introducao.html");
        //addItem(imageid, 1, "O livro de João", "file:///android_asset/estudo_joao.html");
        addItem(imageid, 1, "Buscando a Deus", "file:///android_asset/estudo_buscando.html");
        addItem(imageid, 2, "A Palavra de Deus", "file:///android_asset/estudo_palavra.html");
        addItem(imageid, 3, "Discipulado", "file:///android_asset/estudo_discipulado.html");
        addItem(imageid, 4, "A vinda do Reino", "file:///android_asset/estudo_reino.html");
        addItem(imageid, 5, "Luz e Trevas", "file:///android_asset/estudo_luz_trevas.html");
        addItem(imageid, 6, "Conversão do Novo Testamento", "file:///android_asset/estudo_conversoes.html");
        addItem(imageid, 7, "A Cruz", "file:///android_asset/estudo_cruz.html");
        addItem(imageid, 8, "Relato médico da crucificação de Cristo", "file:///android_asset/estudo_relato_medico.html");

        addItem(imageid, 0, "Batismo com o Espírito Santo", "file:///android_asset/estudo_batismo_espirito.html");
        addItem(imageid, 10, "A Igreja", "file:///android_asset/estudo_igreja.html");
        addItem(imageid, 11, "Dons Milagrosos do Espírito Santo", "file:///android_asset/estudo_dons.html");
        //addItem(imageid, 13, "O livro de Atos", "");
        addItem(imageid, 12, "Fui batizado, e agora?", "file:///android_asset/estudo_fuibatizado.html");
        addItem(imageid, 13, "Cristo é sua vida", "file:///android_asset/estudo_cristo_vida.html");
        addItem(imageid, 14, "Melhores amigos de todos os tempos", "file:///android_asset/estudo_melhores_amigos.html");
        addItem(imageid, 15, "A Missão", "file:///android_asset/estudo_missao.html");
        addItem(imageid, 16, "Perseguição", "file:///android_asset/estudo_perseguicao.html");
        addItem(imageid, 17, "Escrituras a decorar", "file:///android_asset/memory_scriptures.html");
    }

    private void addItem(int imageid, int idestudo, String estudo_titulo, String estudo_file) {
        lista_estudos.add(new ItemListView(imageid, idestudo, estudo_titulo, estudo_file));
    }

    public List<ItemListView> getListaEstudos(){
        return this.lista_estudos;
    }

    public String getFileStudo(int position){
        return lista_estudos.get(position).getFile();
    }

    public String getTitleStudo(int position){
        return lista_estudos.get(position).getTexto();
    }
}
