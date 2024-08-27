package br.com.tfurtado.newspaper;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import br.com.tfurtado.newspaper.adapters.NewsAdapter;
import br.com.tfurtado.newspaper.adapters.NewsModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.allNews);
        listView.setAdapter(new NewsAdapter(this, NewsModel.getInstances()));
    }
}