package store.util;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class StringParser {
    public static List<Map<String, String>> parseFileContent(String fileContent) {
        String[] lines = fileContent.split("\n");
        lines = removeNewLine(lines);
        String[] headers = parseHeaders((lines[0]));
        return parseData(lines, headers);
    }

    private static String[] parseHeaders(String headerLine) {
        return headerLine.split(",");
    }

    private static List<Map<String, String>> parseData(String[] lines, String[] headers) {
        List<Map<String, String>> products = new ArrayList<>();
        for (int i = 1; i < lines.length; i++) {
            Map<String, String> parsedData = mapLineToData(lines[i], headers);
            products.add(parsedData);
        }
        return products;
    }

    private static Map<String, String> mapLineToData(String line, String[] headers) {
        String[] values = line.split(",");
        Map<String, String> parsedData = new LinkedHashMap<>();
        for (int i = 0; i < headers.length; i++) {
            parsedData.put(headers[i], values[i]);
        }
        return parsedData;
    }

    private static String[] removeNewLine(String[] data) {
        for (int i = 0; i < data.length; i++) {
            data[i] = data[i].replaceAll("(\r)", "");
        }
        return data;
    }
}
