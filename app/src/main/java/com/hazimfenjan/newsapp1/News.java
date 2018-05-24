package com.hazimfenjan.newsapp1;

import java.util.Date;

/**
 * An {@link News} object contains information related to a single news.
 */

public class News {

    // Title for the news
     private final String newsTitle;

     // News Section Name
    private final  String newsSectionName;

    // News Author name
    private final String newsAuthorName;

    // News Date
    private final Date newsPublicationDate;

    // News Website URL
    private final String newsUrl;

    // News Image
    private final String newsImage;


    /**
     * Constructs a new {@link News} object.
     *
     * @param newsTitle
     * @param newsSectionName
     * @param newsAuthorName
     * @param newsPublicationDate
     * @param newsUrl
     * @param newsImage
     */

    public News(String newsTitle, String newsSectionName, String newsAuthorName, Date newsPublicationDate, String newsUrl, String newsImage) {
        this.newsTitle = newsTitle;
        this.newsSectionName = newsSectionName;
        this.newsAuthorName = newsAuthorName;
        this.newsPublicationDate = newsPublicationDate;
        this.newsUrl = newsUrl;
        this.newsImage = newsImage;
    }

    /**
     * Returns News Title.
     */
    public String getNewsTitle() {
        return newsTitle;
    }

    /**
     * Returns News Section Name.
     */
    public String getNewsSectionName() {
        return newsSectionName;
    }

    /**
     * Returns News Author Name.
     */
    public String getNewsAuthorName() {
        return newsAuthorName;
    }

    /**
     * Returns News website URL.
     */
    public String getNewsUrl() {
        return newsUrl;
    }

    /**
     * Returns News Date.
     */
    public Date getNewsPublicationDate() {
        return newsPublicationDate;
    }

    /**
     * Returns News Image.
     */
    public String getNewsImage() {
        return newsImage;
    }
}
