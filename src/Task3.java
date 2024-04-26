import models.Video;

public class Task3 {
    public static void main(String[] args) {
        // abrir arquivo
        var filePath = "output/videos_T1.csv";
        var data = Utils.readCSV(filePath).toArray(new String[0]);

        // processar
        // filrar estes IDs:
        //42 = shorts | 43 = shows | 44 = trailers
        var processedData = new DynamicArray<String>();

        for (var line : data) {
            if (line.startsWith("countries")) {
                processedData.add(line);
            } else {
                var video = Video.fromCSV(line);
                var category = video.getCategoryId();
                if (category.equals("42") || category.equals("43") || category.equals("44")) {
                    processedData.add(line);
                }
            }
        }

        // salvar
        var outputPath = "output/videos_TSS.csv";
        var result = Utils.writeCSV(outputPath, processedData);
        if (result) {
            System.out.println("Arquivo escrito com sucesso");
        } else {
            System.out.println("Erro ao escrever o arquivo");
        }
    }
}
