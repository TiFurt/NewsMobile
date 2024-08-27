package br.com.tfurtado.newspaper.adapters;

import java.util.ArrayList;
import java.util.List;

public class NewsModel {
    private String title;
    private String description;
    private String url;
    private String urlToImage;

    public NewsModel(String title, String description, String url, String urlToImage) {
        this.title = title;
        this.description = description;
        this.url = url;
        this.urlToImage = urlToImage;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public static List<NewsModel> getInstances() {
        ArrayList<NewsModel> news = new ArrayList<>();
        news.add(new NewsModel("Title 1", "Description 1", "http://www.google.com", "http://www.google.com"));
        news.add(new NewsModel("Title 2", "Description 2", "http://www.google.com", "http://www.google.com"));
        news.add(new NewsModel("Title 3", "Description 3", "http://www.google.com", "http://www.google.com"));
        news.add(new NewsModel("Title 4", "Description 4", "http://www.google.com", "http://www.google.com"));
        news.add(new NewsModel("Title 5", "Description 5", "http://www.google.com", "http://www.google.com"));

        return news;
    }
}
