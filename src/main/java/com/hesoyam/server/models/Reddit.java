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
    private int created_utc;
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

    public Reddit(){

    }

    public Reddit(ObjectId _id, String author, String author_flair_css_class, String author_flair_text,
                  boolean brand_safe, boolean contest_mode, int created_utc, String domain, String full_link, String id,
                  boolean is_self, String link_flair_text, boolean locked, int num_comments, boolean over_18,
                  String permalink, int retrieved_on, int score, boolean spoiler, boolean stickied, String subreddit,
                  String subreddit_id, String suggested_sort, String thumbnail, String title, String url,
                  int comments_scrapped) {
        this._id = _id;
        this.author = author;
        this.author_flair_css_class = author_flair_css_class;
        this.author_flair_text = author_flair_text;
        this.brand_safe = brand_safe;
        this.contest_mode = contest_mode;
        this.created_utc = created_utc;
        this.domain = domain;
        this.full_link = full_link;
        this.id = id;
        this.is_self = is_self;
        this.link_flair_text = link_flair_text;
        this.locked = locked;
        this.num_comments = num_comments;
        this.over_18 = over_18;
        this.permalink = permalink;
        this.retrieved_on = retrieved_on;
        this.score = score;
        this.spoiler = spoiler;
        this.stickied = stickied;
        this.subreddit = subreddit;
        this.subreddit_id = subreddit_id;
        this.suggested_sort = suggested_sort;
        this.thumbnail = thumbnail;
        this.title = title;
        this.url = url;
        this.comments_scrapped = comments_scrapped;
    }
    public String getCreatedUtc() {
        return String.valueOf(created_utc);
    }

    public void setCreatedUtc(int created_utc) {
        this.created_utc = created_utc;
    }

    public String getFull_link() {
        return full_link;
    }

    public void setFull_link(String full_link) {
        this.full_link = full_link;
    }

    public String getNum_comments() {
        return String.valueOf(num_comments);
    }

    public void setNum_comments(int num_comments) {
        this.num_comments = num_comments;
    }

    public String getScore() {
        return String.valueOf(score);
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getSubreddit() {
        return subreddit;
    }

    public void setSubreddit(String subreddit) {
        this.subreddit = subreddit;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor(){
        return author;
    }

    public String getAuthor_flair_css_class() {
        return author_flair_css_class;
    }

    public String getAuthor_flair_text() {
        return author_flair_text;
    }

    public boolean isBrand_safe() {
        return brand_safe;
    }

    public boolean isContest_mode() {
        return contest_mode;
    }

    public String getDomain() {
        return domain;
    }

    public String getId() {
        return id;
    }

    public boolean isIs_self() {
        return is_self;
    }

    public String getLink_flair_text() {
        return link_flair_text;
    }

    public boolean isLocked() {
        return locked;
    }

    public boolean isOver_18() {
        return over_18;
    }

    public String getPermalink() {
        return permalink;
    }

    public int getRetrieved_on() {
        return retrieved_on;
    }

    public boolean isSpoiler() {
        return spoiler;
    }

    public boolean isStickied() {
        return stickied;
    }

    public String getSubreddit_id() {
        return subreddit_id;
    }

    public String getSuggested_sort() {
        return suggested_sort;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public String getUrl() {
        return url;
    }

    public int getComments_scrapped() {
        return comments_scrapped;
    }
}
