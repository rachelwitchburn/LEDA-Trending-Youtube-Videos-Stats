public class Task4 {
    public static void main(String[] args) {
        // abrir o arquivo
        var filePath = "output/videos_T1.csv";
        var data = Utils.readCSV(filePath).toArray(new String[0]);

        // processar dados
        var processedData = new DynamicArray<String>();

        // filtrar videos com mais dislikes que likes
        for (var line : data) {
            if (line.startsWith("countries")) {
                processedData.add(line);
            } else {
                var video = Video.fromCSV(line);
                if (video.likes() < video.dislikes()) {
                    processedData.add(line);
                }
            }
        }

        // salvar
        var outputPath = "output/videos_T2.csv";
        var result = Utils.writeCSV(outputPath, processedData);
        if (result) {
            System.out.println("Arquivo escrito com sucesso");
        } else {
            System.out.println("Erro ao escrever o arquivo");
        }
    }
}