package com.bettercsw.medium;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        String fileName = "D:\\File\\ProjectCode\\server\\study\\interview\\leetcode\\src\\main\\resources\\1.txt";  // 替换为实际的文件路径

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            int lineNumber = 1;
            Set<String> allSubstrings = new HashSet<>();  // 用于存储所有的子字符串
            Set<String> duplicateSubstrings = new HashSet<>();  // 存储重复的子字符串

            while ((line = br.readLine()) != null) {
                Set<String> currentLineSubstrings = new HashSet<>();  // 存储当前行的子字符串，用于检查重复
                for (int i = 0; i <= line.length() - 10; i++) {
                    String substring = line.substring(i, i + 10);  // 提取长度为10的子字符串
                    if (!allSubstrings.add(substring)) {  // 如果已经存在，说明有重复
                        if (currentLineSubstrings.contains(substring)) {
                            duplicateSubstrings.add(substring);  // 添加到重复子字符串集合中
                        } else {
                            currentLineSubstrings.add(substring);  // 将当前行的子字符串添加到集合中
                            int lineContainingSubstring = findLineContainingSubstring(fileName, substring);
                            if(lineContainingSubstring != lineNumber) {
                                // 打印重复字符串及其出现的行号
                                System.out.println("Duplicate substring found: " + substring +
                                        " on lines: " + lineNumber + " and " + lineContainingSubstring
                                );
                                break;
                            }

                        }
                    }
                }
                lineNumber++;
            }

            if (duplicateSubstrings.isEmpty()) {
                System.out.println("No duplicate substrings found in the file.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 在文件中查找包含特定子字符串的行号
    private static int findLineContainingSubstring(String fileName, String substring) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            int lineNumber = 1;

            while ((line = br.readLine()) != null) {
                if (line.contains(substring)) {
                    return lineNumber;
                }
                lineNumber++;
            }
        }
        return -1;
    }
}



