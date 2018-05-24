package com.hazimfenjan.newsapp1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * An {@link NewsAdapter} knows how to create a list item layout for each news
 * in the data source (a list of {@link News} objects).
 * <p>
 * These list item layouts will be provided to an adapter view like ListView
 * to be displayed to the user.
 */


public class NewsAdapter extends ArrayAdapter<News> {

    /**
     * Constructs a new {@link NewsAdapter}.
     *
     * @param context
     * @param news
     */
    public NewsAdapter(Context context, List<News> news){
        super(context,0,news);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.news_list_item, parent, false);
        }

        //Find the news at the given position in the list of news
        News currentNews = getItem(position);

        ImageView imageView = listItemView.findViewById(R.id.image);
        Picasso.get().load(currentNews.getNewsImage()).into(imageView);

        // Find the TextView with view ID title
        TextView titleView = listItemView.findViewById(R.id.title);
        // Display the title of the current news in that TextView
        titleView.setText(currentNews.getNewsTitle());

        // Find the TextView with view ID section_name
        TextView sectionNameView = listItemView.findViewById(R.id.section_name);
        // Display the section name of the current news in that TextView
        sectionNameView.setText(currentNews.getNewsSectionName());

        // Find the TextView with view ID author_name
        TextView authorNameView = listItemView.findViewById(R.id.author_name);
        // Display the author name of the current news in that TextView
        if (currentNews.getNewsAuthorName() != "") {
            authorNameView.setText(currentNews.getNewsAuthorName());

            //Set author name view as visible
            authorNameView.setVisibility(View.VISIBLE);
        } else {
            //Set author name view as gone
            authorNameView.setVisibility(View.GONE);
        }

        // Find the TextView with view ID date
        TextView dateView = null;
        TextView timeView = null;
        if (currentNews.getNewsPublicationDate() != null) {
            dateView = listItemView.findViewById(R.id.date);
            // Format the date string (i.e. "Mar 3, 1984")
            String formattedDate = formatDate(currentNews.getNewsPublicationDate()).concat(",");
            // Display the date of the current earthquake in that TextView
            dateView.setText(formattedDate);

            // Find the TextView with view ID time
            timeView = listItemView.findViewById(R.id.time);
            // Format the time string (i.e. "4:30PM")
            String formattedTime = formatTime(currentNews.getNewsPublicationDate());
            // Display the time of the current earthquake in that TextView
            timeView.setText(formattedTime);

            //Set date & time views as visible
            dateView.setVisibility(View.VISIBLE);
            timeView.setVisibility(View.VISIBLE);
        } else {
            //Set date & time views as gone
            dateView.setVisibility(View.GONE);
            timeView.setVisibility(View.GONE);
        }

        return listItemView;
    }
    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }
}
