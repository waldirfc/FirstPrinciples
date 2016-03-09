package com.convictvs.edisone.firstprinciples.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.convictvs.edisone.firstprinciples.R;
import com.convictvs.edisone.firstprinciples.adapters.AdapterListView;
import com.convictvs.edisone.firstprinciples.adapters.ItemListView;
import com.convictvs.edisone.firstprinciples.data.LoadEstudos;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    public final static String POSITION_ESTUDO = "com.convictvs.edisone.firstprinciples.POSITION_ESTUDO";
    public final static String TITLE_ESTUDO = "com.convictvs.edisone.firstprinciples.TITLE_ESTUDO";
    private List<ItemListView> lista_estudos;
    private ListView listview;
    private AdapterListView adapter;

    private Toolbar tool_bar;

    private ViewGroup footer;

    private Button btn_contato;

    private ImageButton btn_facebook;
    private ImageButton btn_youtube;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tool_bar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(tool_bar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.ic_logo);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        listview = (ListView) findViewById(R.id.lista_estudos);

        final LoadEstudos load_estudos = new LoadEstudos(R.drawable.ic_item_estudo);
        lista_estudos = load_estudos.getListaEstudos();

        adapter = new AdapterListView(this.getApplicationContext(), lista_estudos);

        listview.setAdapter(adapter);

        footer = (ViewGroup) getLayoutInflater().inflate(R.layout.footer, listview, false);
        listview.addFooterView(footer, null, false);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast toast = Toast.makeText(parent.getContext(), position + " - " + id, Toast.LENGTH_LONG);
                //toast.show();
                Intent intent = new Intent(MainActivity.this, StudoActivity.class);
                intent.putExtra(POSITION_ESTUDO, load_estudos.getFileStudo(position));
                intent.putExtra(TITLE_ESTUDO, load_estudos.getTitleStudo(position));
                startActivity(intent);
            }
        });

        btn_contato = (Button) findViewById(R.id.button_contato);
        btn_contato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, StudoActivity.class);
                intent.putExtra(POSITION_ESTUDO, "file:///android_asset/fcontato.html");
                intent.putExtra(TITLE_ESTUDO, "Contato");
                startActivity(intent);
            }
        });

        btn_facebook = (ImageButton) findViewById(R.id.button_facebook);
        btn_facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/groups/188889114555909/"));
                startActivity(browserIntent);
            }
        });

        btn_youtube = (ImageButton) findViewById(R.id.button_youtube);
        btn_youtube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/channel/UCMW3C3drQCYab8DzpAMUadw"));
                startActivity(browserIntent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        switch(item.getItemId()){
            /*case R.id.action_home:
                return true;*/
            /*case R.id.action_settings:
                return  true;*/
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
