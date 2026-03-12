package com.solvd.booksy.database;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.*;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

public class WordCounter {
    public static void count(String inputPath, String outputPath) throws Exception {
        String text = FileUtils.readFileToString(new File(inputPath), StandardCharsets.UTF_8);
        Map<String, Integer> counts = new TreeMap<>();
        for (String word : text.toLowerCase().split("[^a-zA-Z']+")) {
            if (StringUtils.isNotEmpty(word)) counts.merge(word, 1, Integer::sum);
        }
        StringBuilder sb = new StringBuilder("word,count\n");
        for (var entry : counts.entrySet()) {
            sb.append(entry.getKey()).append(",").append(entry.getValue()).append("\n");
        }
        FileUtils.writeStringToFile(new File(outputPath), sb.toString(), StandardCharsets.UTF_8);
    }
}