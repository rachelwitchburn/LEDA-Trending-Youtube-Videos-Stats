public class Task1 {
    public static void main(String[] args) {
        var path = "C:\\Users\\raque\\OneDrive\\Área de Trabalho\\faculdade\\leda\\ytbe stats csv extraido\\";
        var countries = new String[]{"CA", "DE", "US", "FR", "GB", "IN", "JP", "KR", "MX", "RU"};
        var totalCountries = countries.length; // = 10

        var allFiles = new DynamicArray<DynamicArray<String>>();
        for (String video : countries) {
            var lines = Utils.readCSV(path + video + "videos_cleaned.csv");
            allFiles.add(lines);
        }

        var allLines = new DynamicArray<String>(); // array com todas as linhas de todos os arquivos
        var header = allFiles.get(0).get(0); // pega o cabeçalho do primeiro arquivo

        var newHeader = "countries," + header; // adiciona a coluna country no cabeçalho
        allLines.add(newHeader); // adiciona o cabeçalho no array

        // video_id,trending_date,title,channel_title,category_id,publish_time,tags,views,likes,dislikes,comment_count,thumbnail_link,comments_disabled,ratings_disabled,video_error_or_removed,description
        // countries, ...

        for (int i = 0; i < totalCountries; i++) {
            var file = allFiles.get(i); // arquivo do pais
            var country = countries[i]; // CA, DE, ...
            boolean isHeader  = true;
            for (String line : file) {
                if (isHeader) // ignorar o cabeçalho dos arquivos
                    isHeader = false;
                else
                    allLines.add(country + "," + line); // adiciona o pais na linha


            }
        }
        System.out.println("Leu " + allLines.getCounter() + " linhas");

        var result = Utils.writeCSV("output/" + "videos.csv", allLines);
        if (result) {
            System.out.println("Arquivo escrito com sucesso");
        } else {
            System.out.println("Erro ao escrever o arquivo");
        }
    }
}
