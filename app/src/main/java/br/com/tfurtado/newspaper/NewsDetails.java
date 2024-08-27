package br.com.tfurtado.newspaper;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.MessageFormat;

import br.com.tfurtado.newspaper.adapters.NewsModel;

public class NewsDetails extends AppCompatActivity {
    private NewsModel news;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_news_details);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        getNews();

        ((TextView) findViewById(R.id.title)).setText(news.getTitle());

        TextView description = findViewById(R.id.description);
        description.setText(MessageFormat.format("{0}{1}", description.getText(), news.getDescription()));
    }

    private void getNews() {
        Intent intent = getIntent();
        int id = intent.getIntExtra("id", 0);
        news = NewsModel.getInstances().get(id);
    }
}