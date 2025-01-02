package org.example;

import org.json.simple.*;
import org.json.simple.parser.*;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ConsistanceLv9 {

    // JSON 파일 읽기
    public JSONObject readJSON(String filePath) {
        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader(filePath)) { // try-with-resources 사용
            Object obj = parser.parse(reader);
            return (JSONObject) obj;
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            return null; // 오류 발생 시 null 반환
        }
    }

    // JSON 파일 쓰기
    public void writeJSON(String filePath, JSONObject jsonObject) {
        try (FileWriter writer = new FileWriter(filePath)) { // try-with-resources 사용
            writer.write(jsonObject.toJSONString());
            writer.flush();
            System.out.println("JSON 파일 저장 완료: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}