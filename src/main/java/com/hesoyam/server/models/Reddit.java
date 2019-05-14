package com.hesoyam.server.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Reddit {
    @Id
    private ObjectId _id;
    private String author;
    private String author_flair_css_class;
    private String author_flair_text;
    private boolean brand_safe;
    private boolean contest_mode;
    private int date;
    private String domain;
    private String full_link;
    private String id;
    private boolean is_self;
    private String link_flair_text;
    private boolean locked;
    private int num_comments;
    private boolean over_18;
    private String permalink;
    private int retrieved_on;
    private int score;
    private boolean spoiler;
    private boolean stickied;
    private String subreddit;
    private String subreddit_id;
    private String suggested_sort;
    private String thumbnail;
    private String title;
    private String url;
    private int comments_scrapped;
    //private List<String> comments;

    public String get_id() {
        return _id.toHexString();
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor_flair_css_class() {
        return author_flair_css_class;
    }

    public void setAuthor_flair_css_class(String author_flair_css_class) {
        this.author_flair_css_class = author_flair_css_class;
    }

    public String getAuthor_flair_text() {
        return author_flair_text;
    }

    public void setAuthor_flair_text(String author_flair_text) {
        this.author_flair_text = author_flair_text;
    }

    public String isBrand_safe() {
        return String.valueOf(brand_safe);
    }

    public void setBrand_safe(boolean brand_safe) {
        this.brand_safe = brand_safe;
    }

    public String isContest_mode() {
        return String.valueOf(contest_mode);
    }

    public void setContest_mode(boolean contest_mode) {
        this.contest_mode = contest_mode;
    }

    public String getDate() {
        return String.valueOf(date);
    }

    public void setDate(int date) {
        this.date = date;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getFull_link() {
        return full_link;
    }

    public void setFull_link(String full_link) {
        this.full_link = full_link;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isIs_self() {
        return is_self;
    }

    public void setIs_self(boolean is_self) {
        this.is_self = is_self;
    }

    public String getLink_flair_text() {
        return link_flair_text;
    }

    public void setLink_flair_text(String link_flair_text) {
        this.link_flair_text = link_flair_text;
    }

    public String isLocked() {
        return String.valueOf(locked);
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public String getNum_comments() {
        return String.valueOf(num_comments);
    }

    public void setNum_comments(int num_comments) {
        this.num_comments = num_comments;
    }

    public String isOver_18() {
        return String.valueOf(over_18);
    }

    public void setOver_18(boolean over_18) {
        this.over_18 = over_18;
    }

    public String getPermalink() {
        return permalink;
    }

    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    public String getRetrieved_on() {
        return String.valueOf(retrieved_on);
    }

    public void setRetrieved_on(int retrieved_on) {
        this.retrieved_on = retrieved_on;
    }

    public String getScore() {
        return String.valueOf(score);
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String isSpoiler() {
        return String.valueOf(spoiler);
    }

    public void setSpoiler(boolean spoiler) {
        this.spoiler = spoiler;
    }

    public String isStickied() {
        return String.valueOf(stickied);
    }

    public void setStickied(boolean stickied) {
        this.stickied = stickied;
    }

    public String getSubreddit() {
        return subreddit;
    }

    public void setSubreddit(String subreddit) {
        this.subreddit = subreddit;
    }

    public String getSubreddit_id() {
        return subreddit_id;
    }

    public void setSubreddit_id(String subreddit_id) {
        this.subreddit_id = subreddit_id;
    }

    public String getSuggested_sort() {
        return suggested_sort;
    }

    public void setSuggested_sort(String suggested_sort) {
        this.suggested_sort = suggested_sort;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getComments_scrapped() {
        return String.valueOf(comments_scrapped);
    }

    public void setComments_scrapped(int comments_scrapped) {
        this.comments_scrapped = comments_scrapped;
    }
}
