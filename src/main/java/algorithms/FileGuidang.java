package algorithms;

import java.util.*;

public class FileGuidang {
    public static void main(String[] args) {

        String files = "my.song.mp3 11b\n" +
                "ggsong.flac 1000b\n" +
                "bit.txt 5b\n" +
                "viv.mp4 200b\n" +
                "game.exe 100b\n" +
                "mov.mkv 10000b\n";
        String solution = solution(files);
        System.out.println(solution);
    }

    public static String solution(String files) {
        Map<String, List<String>> map = new HashMap<>();
        Map<String, Integer> fileMap = new LinkedHashMap<>();
        createMap(map, fileMap);

        String[] split = files.split("\n");

        for (String file : split) {
            String[] nameSize = file.split(" ");
            String key = getKey(nameSize[0], map);
            int size = Integer.parseInt(nameSize[1].substring(0, nameSize[1].lastIndexOf("b")))
                    + fileMap.get(key);
            fileMap.put(key, size);
        }
        StringBuilder res = new StringBuilder();
        fileMap.entrySet().stream().forEach(a-> res.append(a.getKey()+" "+a.getValue()+"b\n"));
        return res.toString();
    }


    public static String getKey(String fileName, Map<String, List<String>> map) {
        String type = fileName.substring(fileName.lastIndexOf(".") + 1);
        Iterator<Map.Entry<String, List<String>>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, List<String>> next = iterator.next();
            if (next.getValue().contains(type)) {
                return next.getKey();
            }
        }
        return "other";
    }

    public static void createMap(Map<String, List<String>> map, Map<String, Integer> fileMap) {
        fileMap.put("music", 0);
        fileMap.put("image", 0);
        fileMap.put("movie", 0);
        fileMap.put("other", 0);

        List<String> types1 = new ArrayList<>();
        List<String> types2 = new ArrayList<>();
        List<String> types3 = new ArrayList<>();
        types1.add("mp3");
        types1.add("aac");
        types1.add("flac");
        types2.add("jpg");
        types2.add("bmp");
        types2.add("gif");
        types3.add("mp4");
        types3.add("avi");
        types3.add("mkv");
        map.put("music", types1);
        map.put("image", types2);
        map.put("movie", types3);
    }
}
