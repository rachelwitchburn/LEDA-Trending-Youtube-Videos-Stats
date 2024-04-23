import javax.swing.*;

public class Task2 {
    public static void main(String[] args) {
        var filePath = "output/videos.csv";
        var data = Utils.readCSV(filePath).toArray(new String[0]);


        // processar
        var processedData = new DynamicArray<String>();
        for (int i =0; i < data.length; i++) {
            if (i == 0) {
                processedData.add(data[i]); // adciona o cabeçalho ao arquivo
            } else {
             //"GB,\"zwrlJwed2mQ\",17.24.12,\"BigCityBeats WORLD CLUB DOME Zero Gravity (Official Trailer)\",\"BigCityBeats\",24,2017-12-13T13:58:13.000Z,";

                // formatar a data no novo arquivo
                var parts = data[i].split(",");
                var dateParts = parts[2].split("\\.");
                if(dateParts.length<2){
                    System.out.println("Not ok");
                }
                var trendingFullDate = dateConverter(parts[2]);
                StringBuilder newLine = new StringBuilder(parts[0] + "," + parts[1] + "," + trendingFullDate);
                for (int j = 3; j < parts.length; j++) {
                    newLine.append(",").append(parts[j]);
                }
                processedData.add(newLine.toString());
            }
        }

        // salvar
        var outputPath = "output/videos_T1.csv";
        var result = Utils.writeCSV(outputPath, processedData);
        if (result) {
            System.out.println("Arquivo escrito com sucesso");
        } else {
            System.out.println("Erro ao escrever o arquivo");
        }
    }

    /**
     *  recebe a data no formato aa.mm.dd e retorna no formato dd/mm/aaaa
     * @param date
     * @return String
     */
    static String dateConverter(String date) {

        var dateParts = date.split("\\.");
        if(dateParts.length<2){
            System.out.println("Not ok");
        }
        var trendingFullDate = dateParts[1] + "/" + dateParts[2] + "/";
        if (dateParts[0].length() == 2) { // 17 -> 20 + 17
            trendingFullDate += "20" + dateParts[0];
        } else { // 2017 -> 2017
            trendingFullDate += dateParts[0];
        }

        return trendingFullDate;

    }
}
