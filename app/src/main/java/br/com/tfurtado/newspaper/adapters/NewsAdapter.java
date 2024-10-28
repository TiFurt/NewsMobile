package br.com.tfurtado.newspaper.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.MessageFormat;
import java.util.List;

import br.com.tfurtado.newspaper.NewsDetails;
import br.com.tfurtado.newspaper.R;

public class NewsAdapter extends ArrayAdapter<NewsModel> {
    private final List<NewsModel> news;

    public NewsAdapter(Context context, List<NewsModel> news) {
        super(context, 0, news);
        this.news = news;
    }

    @Override
    public int getCount() {
        return news.size();
    }

    @Override
    public NewsModel getItem(int i) {
        return news.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_news, parent, false);
        }

        NewsModel news = getItem(position);

        ((TextView) convertView.findViewById(R.id.title)).setText(news.getTitle());

        TextView description = convertView.findViewById(R.id.description);
        description.setText(MessageFormat.format("{0}{1}", description.getText(), news.getDescription()));

        convertView.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), NewsDetails.class);
            intent.putExtra("id", position);
            v.getContext().startActivity(intent);
        });
        return convertView;
    }
}
