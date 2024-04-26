import models.VideoSortableByFullDate;
import sort.QuickSort;

public class SortBestCase {
    public static void main(String[] args) {
        // carrega o arquivo csv
        var filePath = "output/videos_T1.csv";
        var data = Utils.readCSV(filePath).toArray(new String[0]);

        // transforma o csv em objetos para ordenar
        var toSort = new VideoSortableByFullDate[data.length - 1];
        for (var i = 1; i < data.length; i++) {
            toSort[i - 1] = VideoSortableByFullDate.fromCSV(data[i]);
        }

        // ordena
        var qSort = new QuickSort<VideoSortableByFullDate>();
        var start = System.nanoTime();
        qSort.sortDesc(toSort);
        var end = System.nanoTime();

        // log tempo de execucao formatado em segundos
        var elapsedTime = (end - start) / 1e9;
        System.out.println("Tempo de execucao: " + elapsedTime + "s");


        // transforma os objetos ordenados em csv
        var processedData = new DynamicArray<String>();
        processedData.add(data[0]);
        for (var video : toSort) {
            processedData.add(video.toCSV());
        }

        // salvar o arquivo
        var outputPath = "output/videos_T1_trending_full_date_qSort_melhorCaso.csv";
        var result = Utils.writeCSV(outputPath, processedData);
        if (result) {
            System.out.println("Arquivo escrito com sucesso");
        } else {
            System.out.println("Erro ao escrever o arquivo");
        }

    }
}
