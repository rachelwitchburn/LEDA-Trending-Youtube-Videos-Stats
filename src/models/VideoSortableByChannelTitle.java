package models;

public class VideoSortableByChannelTitle extends Video implements Comparable<VideoSortableByChannelTitle> {
    public VideoSortableByChannelTitle(String countries, String videoId, String trendingDate, String trendingFullDate, String title, String channelTitle, String categoryId, String publishTime, String tags, int views, int likes, int dislikes, int commentCount, String thumbnailLink, boolean commentsDisabled, boolean ratingsDisabled, boolean videoErrorOrRemoved, String description) {
        super(countries, videoId, trendingDate, trendingFullDate, title, channelTitle, categoryId, publishTime, tags, views, likes, dislikes, commentCount, thumbnailLink, commentsDisabled, ratingsDisabled, videoErrorOrRemoved, description);
    }

    public static VideoSortableByChannelTitle fromCSV(String csvLine) {
        var parts = splitCSV(csvLine);

        return new VideoSortableByChannelTitle(
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

    @Override
    public int compareTo(VideoSortableByChannelTitle o) {
        return getChannelTitle().compareTo(o.getChannelTitle());
    }
}