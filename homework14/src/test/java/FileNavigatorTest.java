import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FileNavigatorTest {

    private FileNavigator fileNavigator;

    @BeforeEach
    public void setFileNavigator() {
        fileNavigator = new FileNavigator();
    }

    @Test
    public void testAdd() {
        FileData file1 = new FileData("file1.txt", 100, "/path/to/file1.txt");
        FileData file2 = new FileData("file2.txt", 200, "/path/to/file2.txt");
        fileNavigator.add(file1);
        fileNavigator.add(file2);
        List<FileData> fileList = fileNavigator.find("/path/to");
        assertEquals(2, fileList.size());
        assertTrue(fileList.contains(file1));
        assertTrue(fileList.contains(file2));
    }

    @Test
    public void testFind() {
        FileData file1 = new FileData("file1.txt", 100, "/path/to/file1.txt");
        FileData file2 = new FileData("file2.txt", 200, "/path/to/file2.txt");
        fileNavigator.add(file1);
        fileNavigator.add(file2);
        List<FileData> fileList = fileNavigator.find("/path/to");
        assertEquals(2, fileList.size());
        assertTrue(fileList.contains(file1));
        assertTrue(fileList.contains(file2));
    }

    @Test
    public void testFilterBySize() {
        FileData file1 = new FileData("file1.txt", 100, "/path/to/file1.txt");
        FileData file2 = new FileData("file2.txt", 200, "/path/to/file2.txt");
        FileData file3 = new FileData("file3.txt", 300, "/path/to/file3.txt");
        fileNavigator.add(file1);
        fileNavigator.add(file2);
        fileNavigator.add(file3);
        List<FileData> fileList = fileNavigator.filterBySize(250);
        assertEquals(2, fileList.size());
        assertTrue(fileList.contains(file1));
        assertTrue(fileList.contains(file2));
    }

    @Test
    public void testSortBySize() {
        FileNavigator fileNavigator = new FileNavigator();

        fileNavigator.add(new FileData("file1.txt", 100, "/path/to/file1.txt"));
        fileNavigator.add(new FileData("file2.txt", 50, "/path/to/file2.txt"));
        fileNavigator.add(new FileData("file3.txt", 200, "/path/to/file3.txt"));

        List<FileData> sortedList = fileNavigator.sortBySize();

        List<FileData> expectedList = new ArrayList<>();
        expectedList.add(new FileData("file2.txt", 50, "/path/to/file2.txt"));
        expectedList.add(new FileData("file1.txt", 100, "/path/to/file1.txt"));
        expectedList.add(new FileData("file3.txt", 200, "/path/to/file3.txt"));

        assertEquals(expectedList, sortedList);
    }

    @Test
    public void testCheckConsistency() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        FileData fileData1 = new FileData("file.txt", 100, "/path/to/another/file");
        fileNavigator.add(fileData1);
        String consistencyMessage1 = fileNavigator.checkConsistency(fileData1);
        assertEquals("Inconsistent file data: path does not match key.", consistencyMessage1.trim());

        String addedFileMessage1 = outputStream.toString().trim();
        assertEquals("Added file file.txt with path /path/to/another/file", addedFileMessage1.trim());

        outputStream.reset();

        FileData fileData2 = new FileData("file2.txt", 200, "/path/to/file");
        fileNavigator.add(fileData2);

        String expected = "Inconsistent file data: path does not match key.";
        String actual = fileNavigator.checkConsistency(fileData2);
        assertEquals(expected, actual);

        String addedFileMessage2 = outputStream.toString().trim();
        assertEquals("Added file file2.txt with path /path/to/file", addedFileMessage2.trim());

        System.setOut(System.out);
    }

    @Test
    public void testGetKey() {
        FileNavigator fileNavigator = new FileNavigator();

        FileData file1 = new FileData("file1.txt", 100, "/path/to/file");
        FileData file2 = new FileData("file2.txt", 200, "/path/to/file");
        FileData file3 = new FileData("file3.txt", 300, "/path/to/file");
        fileNavigator.add(file1);
        fileNavigator.add(file2);
        fileNavigator.add(file3);

        String key = fileNavigator.getKey(file1);
        assertEquals("/path/to", key);
    }

    @Test
    public void testRemove() {
        FileData file1 = new FileData("file1.txt", 100, "/path/to/file1.txt");
        FileData file2 = new FileData("file2.txt", 200, "/path/to/file2.txt");
        fileNavigator.add(file1);
        fileNavigator.add(file2);
        fileNavigator.remove("/path/to");
        List<FileData> fileList = fileNavigator.find("/path/to");
        assertEquals(0, fileList.size());
    }
}