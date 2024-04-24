// csv header:  video_id,trending_date,title,channel_title,category_id,publish_time,tags,views,likes,dislikes,comment_count,thumbnail_link,comments_disabled,ratings_disabled,video_error_or_removed,description
public record Video(
        String countries,
        String videoId,
        String trendingDate,
        String trendingFullDate,
        String title,
        String channelTitle,
        String categoryId,
        String publishTime,
        String tags,
        int views,
        int likes,
        int dislikes,
        int commentCount,
        String thumbnailLink,
        boolean commentsDisabled,
        boolean ratingsDisabled,
        boolean videoErrorOrRemoved,
        String description
) {


    static Video fromCSV(String csvLine) {
        // regex fonte: https://www.baeldung.com/java-split-string-commas
        String[] parts = csvLine.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1); // regex para detectar virgulas dentro de aspas

        for (int i = 0; i < parts.length; i++) {
            parts[i] = parts[i].trim();
        }
        // GB,"zwrlJwed2mQ",17.24.12,"BigCityBeats WORLD CLUB DOME Zero Gravity (Official Trailer)","BigCityBeats",24,2017-12-13T13:58:13.000Z,

        var description = "";
        if (parts.length > 17){  // se passar de 17, quer dizer que a descrição existe👍
            description = parts[17];
        }

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
                description
        );
    }


    static boolean toBoolean(String value) {
        return value.equals("True");
    }

    @Override
    public String toString() {
        return "Video{" +
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


