import lombok.Data;

import java.util.*;

@Data
public class FileNavigator {

    private Map<String, List<FileData>> fileMap;

    public FileNavigator() {
        fileMap = new HashMap<>();
    }

    public void add(FileData fileData) {
        String dirPath = fileData.getPath().substring(0, fileData.getPath().lastIndexOf("/"));
        if (fileMap.containsKey(dirPath)) {
            List<FileData> fileList = fileMap.get(dirPath);
            fileList.add(fileData);
        } else {
            List<FileData> fileList = new ArrayList<>();
            fileList.add(fileData);
            fileMap.put(dirPath, fileList);
        }
        checkConsistency(fileData);
        System.out.println("Added file " + fileData.getName() + " with path " + fileData.getPath());
    }

    public List<FileData> find(String path) {
        List<FileData> result = fileMap.getOrDefault(path, Collections.emptyList());
        System.out.println("Found " + result.size() + " files at path " + path);
        return result;
    }

    public List<FileData> filterBySize(long maxSize) {
        List<FileData> result = new ArrayList<>();
        for (List<FileData> fileList : fileMap.values()) {
            for (FileData fileData : fileList) {
                if (fileData.getSize() <= maxSize) {
                    result.add(fileData);
                }
            }
        }
        return result;
    }

    public void remove(String path) {
        fileMap.remove(path);
    }

    public List<FileData> sortBySize() {
        List<FileData> result = new ArrayList<>();
        for (List<FileData> fileList : fileMap.values()) {
            result.addAll(fileList);
        }
        result.sort(Comparator.comparingLong(FileData::getSize));
        return result;
    }

    public String checkConsistency(FileData fileData) {
        if (!fileData.getPath().equals(getKey(fileData))) {
            return "Inconsistent file data: path does not match key.";
        }
        return "";
    }

    public String getKey(FileData fileData) {
        for (String key : fileMap.keySet()) {
            if (fileData.getPath().startsWith(key)) {
                return key;
            }
        }
        return null;
    }
}