package com.example.android.newsapp;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import java.util.List;

public class NewsAdapter extends ArrayAdapter<News> {

    private static final String LOCATION_SEPARATOR = "T";
    /**
     * The part that will determine where to split the date and time string
     */

    public NewsAdapter(Context context, List<News> news) {
        super(context, 0, news);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        // Check if there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, then inflate a new list item layout.
        View listItemView = convertView;
        if (convertView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.news_list_item, parent, false);
        }



        News currentNews = getItem(position);



        TextView titleTextView = (TextView) listItemView.findViewById(R.id.title_text_view);
        titleTextView.setText(currentNews.getTitle());

        TextView sectionTextView = (TextView) listItemView.findViewById(R.id.section_text_view);
        sectionTextView.setText(currentNews.getSection());

        TextView authorTextView = (TextView) listItemView.findViewById(R.id.author_text_view);
        authorTextView.setText(currentNews.getAuthor());

        String fullDateTime = currentNews.getDate();


        String dateSplit;
        String timeSplit;

        if (fullDateTime.contains(LOCATION_SEPARATOR)) {
            // Split the string into different parts (as an array of Strings)

            String[] parts = fullDateTime.split(LOCATION_SEPARATOR);

            dateSplit = parts[0] ;
            timeSplit = LOCATION_SEPARATOR + parts[1];
        } else {

            dateSplit = fullDateTime;
            timeSplit = null;
        }

        TextView timeView = (TextView) listItemView.findViewById(R.id.time_text_view);
        TextView dateView = (TextView) listItemView.findViewById(R.id.date_text_view);

        // Display the date
        dateView.setText(dateSplit);
        // Display the time
        timeView.setText(timeSplit);

        // Return the list item view that is now showing the appropriate data
        return listItemView;

    }

}