package br.com.tfurtado.newspaper.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.MessageFormat;
import java.util.List;

import br.com.tfurtado.newspaper.NewsDetails;
import br.com.tfurtado.newspaper.R;

public class NewsAdapter extends BaseAdapter {
    private final List<NewsModel> news;
    private final LayoutInflater inflater;

    public NewsAdapter(Context context, List<NewsModel> news) {
        this.news = news;
        this.inflater = LayoutInflater.from(context);
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
    public View getView(int position, View convertView, ViewGroup container) {
        View view = convertView;
        if (view == null) {
            view = inflater.inflate(R.layout.list_news, container, false);
        }

        NewsModel news = getItem(position);

        ((TextView) view.findViewById(R.id.title)).setText(news.getTitle());

        TextView description = view.findViewById(R.id.description);
        description.setText(MessageFormat.format("{0}{1}", description.getText(), news.getDescription()));

        view.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), NewsDetails.class);
            intent.putExtra("id", position);
            v.getContext().startActivity(intent);
        });
        return view;
    }
}
