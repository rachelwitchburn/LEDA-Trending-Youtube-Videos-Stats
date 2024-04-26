import csv
import sys


def remove_newlines(input_file, output_file):
    encode = "latin-1"
    with open(input_file, 'r', newline='', encoding=encode) as csv_input:
        reader = csv.reader(csv_input)
        with open(output_file, 'w', newline='', encoding=encode) as csv_output:
            writer = csv.writer(csv_output)
            for row in reader:
                try:
                    cleaned_row = [cell.replace("\n", " ").replace("\r", "") for cell in row]
                    writer.writerow(cleaned_row)
                except Exception as e:
                    print("Error in row:", row)
                    print(e)
                    writer.writerow(row)


if __name__ == '__main__':
    dirPath = sys.argv[1] if len(sys.argv) > 1 else './'
    countries = ["CA", "DE", "US", "FR", "GB", "IN", "MX", "KR", "RU", "JP"]

    print('Cleaning data on directory:', dirPath)
    for country in countries:
        file = dirPath + country + 'videos.csv'
        print('Cleaning data from file:', file)
        input_file = file
        output_file = file.replace(".csv", "_cleaned.csv")
        remove_newlines(input_file, output_file)

    print('Data cleaning completed!')

# bash cmd to remove all files with _cleaned.csv
# find . -name "*_cleaned.csv" -type f -delete