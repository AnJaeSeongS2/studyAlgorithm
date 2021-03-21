package com.sonan.codility.baemin;

import java.util.*;

/**
 * Created by Jaeseong on 2021/03/21
 * Git Hub : https://github.com/AnJaeSeongS2
 */
public class Task2 {
    private static final String SEPARATOR_LINE_AND_LINE = "\n";
    private static final String SEPARATOR_FILE_AND_BYTE_VALUE = " ";
    private static final String SEPARATOR_FILE_NAME_AND_EXTENSION = ".";

    public String solution(String S) {
        // init
        LinkedHashMap<FILE_TYPE, Integer> resultMap = genDefaultInitializedTypeMap();

        // parse multiLine
        String[] lines = S.split(SEPARATOR_LINE_AND_LINE);
        for (String line: lines) {
            Map.Entry<FILE_TYPE, Integer> typeAndByte = parseOneLine(line);
            resultMap.put(typeAndByte.getKey(), resultMap.get(typeAndByte.getKey()) + typeAndByte.getValue());
        }

        // stringify result
        return genResultStr(resultMap);
    }

    public LinkedHashMap<FILE_TYPE, Integer> genDefaultInitializedTypeMap() {
        LinkedHashMap<FILE_TYPE, Integer> result = new LinkedHashMap<>();
        for (FILE_TYPE type: FILE_TYPE.values()) {
            result.put(type, 0);
        }
        return result;
    }

    public String genResultStr(LinkedHashMap<FILE_TYPE, Integer> resultMap) {
        StringJoiner resultSJ= new StringJoiner("\n");
        for (Map.Entry<FILE_TYPE, Integer> entry: resultMap.entrySet()) {
            resultSJ.add(String.format("%s %db", entry.getKey().name(), entry.getValue()));
        }
        return resultSJ.toString();
    }

    /**
     * @param line ex: "my.song.mp3 11b"
     * @return ex: Map.Entry(music, 11)
     */
    public Map.Entry<FILE_TYPE, Integer> parseOneLine(String line) {
        String[] splitedLine = line.split(SEPARATOR_FILE_AND_BYTE_VALUE);
        if (splitedLine.length != 2) {
            throw new RuntimeException("invalid line");
        }

        String extension = splitedLine[0].substring(splitedLine[0].lastIndexOf(SEPARATOR_FILE_NAME_AND_EXTENSION) + 1);
        Integer byteValue = Integer.valueOf(splitedLine[1].substring(0, splitedLine[1].length() - 1));
        return new AbstractMap.SimpleEntry<>(FILE_TYPE.findFileType(extension), byteValue);
    }
}

enum FILE_TYPE {
    music,
    images,
    movies,
    other;

    // for key ordering
    private static Map<String, FILE_TYPE> EXTENSION_TO_FILE_TYPE = new HashMap<>();
    static {
        // init typeToExtension
        Map<FILE_TYPE, Set<String>> fileTypeToExtensionTemp = new HashMap<>();
        fileTypeToExtensionTemp.put(FILE_TYPE.music, new HashSet<String>(){{add("mp3"); add("aac"); add("flac");}});
        fileTypeToExtensionTemp.put(FILE_TYPE.images, new HashSet<String>(){{add("jpg"); add("bmp"); add("gif");}});
        fileTypeToExtensionTemp.put(FILE_TYPE.movies, new HashSet<String>(){{add("mp4"); add("avi"); add("mkv");}});

        // init extensionToType, after init typeToExtension (automatically)
        for (Map.Entry<FILE_TYPE, Set<String>> typeToExt: fileTypeToExtensionTemp.entrySet()) {
            for (String ext: typeToExt.getValue()) {
                EXTENSION_TO_FILE_TYPE.put(ext, typeToExt.getKey());
            }
        }
    }

    public static FILE_TYPE findFileType(String extension) {
        if (EXTENSION_TO_FILE_TYPE.containsKey(extension)) {
            return EXTENSION_TO_FILE_TYPE.get(extension);
        }
        return FILE_TYPE.other;
    }
}
