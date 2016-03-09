package com.convictvs.edisone.firstprinciples.adapters;

/**
 * Created by edisone on 27/01/16.
 */
public class ItemListView {
    private int idItem;
    private int iconeRid;
    private String texto;
    private String file;

    public ItemListView() {
        this(-1, -1, "", "");
    }

    public ItemListView(int iconeRid, int idItem, String texto, String file) {
        this.idItem = idItem;
        this.iconeRid = iconeRid;
        this.texto = texto;
        this.file = file;
    }

    public int getIconeRid() {
        return iconeRid;
    }

    public void setIconeRid(int iconeRid) {
        this.iconeRid = iconeRid;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

}
