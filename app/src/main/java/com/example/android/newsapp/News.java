package com.example.android.newsapp;

import org.json.JSONArray; /** A {@link News} object contains news items **/
public class News {

    /** Title, section and date*/


    private String mTitle;
    private String mSection;
    private String mDate;

    /** Website URL of the article */
    private String mUrl;
    private String mAuthor;


    /** Constructs a new {@link News} object.
     *
     * @param title
     * @param section
     * @param date
     */

    public News(String title, String section, String date, String url, String author) {
        mTitle = title;
        mSection = section;
        mDate = date;
        mUrl = url;
        mAuthor = author;
    }

    public String getTitle(){return mTitle;}
public String getSection(){return mSection;}
public String getDate() { return mDate; }
public String getUrl() { return mUrl; }
public String getAuthor() {return mAuthor;}

}
