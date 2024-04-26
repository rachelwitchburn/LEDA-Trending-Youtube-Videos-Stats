package models;


// csv header:  video_id,trending_date,title,channel_title,category_id,publish_time,tags,views,likes,dislikes,comment_count,thumbnail_link,comments_disabled,ratings_disabled,video_error_or_removed,description
public class Video       {

    private String countries;
    private String videoId;
    private String trendingDate;
    private String trendingFullDate;
    private String title;
    private String channelTitle;
    private String categoryId;
    private String publishTime;
    private String tags;
    private int views;
    private int likes;
    private int dislikes;
    private int commentCount;
    private String thumbnailLink;
    private boolean commentsDisabled;
    private boolean ratingsDisabled;
    private boolean videoErrorOrRemoved;
    private String description;

    public Video (String countries, String videoId, String trendingDate, String trendingFullDate, String title, String channelTitle, String categoryId, String publishTime, String tags, int views, int likes, int dislikes, int commentCount, String thumbnailLink, boolean commentsDisabled, boolean ratingsDisabled, boolean videoErrorOrRemoved, String description) {
        this.countries = countries;
        this.videoId = videoId;
        this.trendingDate = trendingDate;
        this.trendingFullDate = trendingFullDate;
        this.title = title;
        this.channelTitle = channelTitle;
        this.categoryId = categoryId;
        this.publishTime = publishTime;
        this.tags = tags;
        this.views = views;
        this.likes = likes;
        this.dislikes = dislikes;
        this.commentCount = commentCount;
        this.thumbnailLink = thumbnailLink;
        this.commentsDisabled = commentsDisabled;
        this.ratingsDisabled = ratingsDisabled;
        this.videoErrorOrRemoved = videoErrorOrRemoved;
        this.description = description;
    }

    public String getCountries() {
        return countries;
    }

    public String getVideoId() {
        return videoId;
    }

    public String getTrendingDate() {
        return trendingDate;
    }

    public String getTrendingFullDate() {
        return trendingFullDate;
    }

    public String getTitle() {
        return title;
    }

    public String getChannelTitle() {
        return channelTitle;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public String getTags() {
        return tags;
    }

    public int getViews() {
        return views;
    }

    public int getLikes() {
        return likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public String getThumbnailLink() {
        return thumbnailLink;
    }

    public boolean isCommentsDisabled() {
        return commentsDisabled;
    }

    public boolean isRatingsDisabled() {
        return ratingsDisabled;
    }

    public boolean isVideoErrorOrRemoved() {
        return videoErrorOrRemoved;
    }

    public String getDescription() {
        return description;
    }

    public String toCSV() {
        return countries + "," +
                videoId + "," +
                trendingDate + "," +
                trendingFullDate + "," +
                title + "," +
                channelTitle + "," +
                categoryId + "," +
                publishTime + "," +
                tags + "," +
                views + "," +
                likes + "," +
                dislikes + "," +
                commentCount + "," +
                thumbnailLink + "," +
                commentsDisabled + "," +
                ratingsDisabled + "," +
                videoErrorOrRemoved + "," +
                description;
    }

    public static String[] splitCSV(String csvLine) {
        // regex fonte: https://www.baeldung.com/java-split-string-commas
        String[] parts = csvLine.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1); // regex para detectar virgulas dentro de aspas

        for (int i = 0; i < parts.length; i++) {
            parts[i] = parts[i].trim();
        }
        // GB,"zwrlJwed2mQ",17.24.12,"BigCityBeats WORLD CLUB DOME Zero Gravity (Official Trailer)","BigCityBeats",24,2017-12-13T13:58:13.000Z,

        if (parts.length < 18){  // se passar de 17, quer dizer que a descrição existe👍
            var parts2 = new String[parts.length+1];
            System.arraycopy(parts, 0, parts2, 0, parts.length);
            parts2[17] = "";
            parts = parts2;
        }

        return  parts;

    }

    public static Video fromCSV(String csvLine) {
       var parts = splitCSV(csvLine);

        return new Video(
                parts[0],
                parts[1],
                parts[2],
                parts[3],
                parts[4],
                parts[5],
                parts[6],
                parts[7],
                parts[8],
                Integer.parseInt(parts[9]),
                Integer.parseInt(parts[10]),
                Integer.parseInt(parts[11]),
                Integer.parseInt(parts[12]),
                parts[13],
                toBoolean(parts[14]),
                toBoolean(parts[15]),
                toBoolean(parts[16]),
                parts[17]
        );
    }


    static boolean toBoolean(String value) {
        return value.equals("True");
    }

    @Override
    public String toString() {
        return "models.Video{" +
                "countries='" + countries + '\'' +
                ", videoId='" + videoId + '\'' +
                ", trendingDate='" + trendingDate + '\'' +
                ", trendingFullDate='" + trendingFullDate + '\'' +
                ", title='" + title + '\'' +
                ", channelTitle='" + channelTitle + '\'' +
                ", categoryId='" + categoryId + '\'' +
                ", publishTime='" + publishTime + '\'' +
                ", tags='" + tags + '\'' +
                ", views=" + views +
                ", likes=" + likes +
                ", dislikes=" + dislikes +
                ", commentCount=" + commentCount +
                ", thumbnailLink='" + thumbnailLink + '\'' +
                ", commentsDisabled=" + commentsDisabled +
                ", ratingsDisabled=" + ratingsDisabled +
                ", videoErrorOrRemoved=" + videoErrorOrRemoved +
                ", description='" + description + '\'' +
                '}';
    }

}



