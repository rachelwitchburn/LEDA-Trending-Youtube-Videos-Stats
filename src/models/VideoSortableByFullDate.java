package models;

public class VideoSortableByFullDate extends Video implements Comparable<VideoSortableByFullDate> {
    public VideoSortableByFullDate(String countries, String videoId, String trendingDate, String trendingFullDate, String title, String channelTitle, String categoryId, String publishTime, String tags, int views, int likes, int dislikes, int commentCount, String thumbnailLink, boolean commentsDisabled, boolean ratingsDisabled, boolean videoErrorOrRemoved, String description) {
        super(countries, videoId, trendingDate, trendingFullDate, title, channelTitle, categoryId, publishTime, tags, views, likes, dislikes, commentCount, thumbnailLink, commentsDisabled, ratingsDisabled, videoErrorOrRemoved, description);
    }

    public static VideoSortableByFullDate fromCSV(String csvLine) {
            var parts = splitCSV(csvLine);

            return new VideoSortableByFullDate(
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
    public int compareTo(VideoSortableByFullDate o) {
        // dd/mm/aaaa
        // dd mm aaaa
        String[] parts1 = this.getTrendingFullDate().split("/");
        String[] parts2 = o.getTrendingFullDate().split("/");

        int day1 = Integer.parseInt(parts1[0]);
        int month1 = Integer.parseInt(parts1[1]);
        int year1 = Integer.parseInt(parts1[2]);

        int day2 = Integer.parseInt(parts2[0]);
        int month2 = Integer.parseInt(parts2[1]);
        int year2 = Integer.parseInt(parts2[2]);

        // Comparar os anos
        if (year1 != year2) {
            return year1 - year2;
        }
        // Comparar os meses
        else if (month1 != month2) {
            return month1 - month2;
        }
        // Comparar os dias
        else {
            return day1 - day2;
        }
    }
}
