package com.example.db_booking.service.impl;

import com.example.db_booking.model.dto.TableDto;
import com.example.db_booking.service.CreateTableService;
import lombok.RequiredArgsConstructor;
import org.flywaydb.core.Flyway;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import static com.example.db_booking.constant.DbConstants.TABLE_CREATED;

@Service
@RequiredArgsConstructor
public class CreateTableServiceServiceImpl implements CreateTableService {

    private final JdbcTemplate jdbcTemplate;
    private String tableMigration = "V%s__";
    private String filePath = "C:\\Users\\user\\IdeaProjects\\booking_apartments\\db_booking\\src\\main\\resources\\db\\migration\\%s";




    public String createTable(TableDto tableDto) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("CREATE TABLE IF NOT EXISTS %s(id INT8  PRIMARY KEY NOT NULL ", tableDto.tableName));

        for (int i = 0; i < tableDto.columnNamesAndDataTypes.size(); i++) {

            stringBuilder.append(",%s %s");
        }
        stringBuilder.append(");");



        List<String> toPut = new ArrayList<>();

        for (Map.Entry<String, String> entry : tableDto.columnNamesAndDataTypes.entrySet()) {

            toPut.add(entry.getKey());
            toPut.add(entry.getValue());

        }
        String[] toPutArray = toPut.toArray(new String[0]);
        String sqlCreate = String.format(stringBuilder.toString(), (Object[]) toPutArray);

        writeToFile(sqlCreate, getFileName(tableDto.tableName));

        return TABLE_CREATED;
    }

    private void writeToFile(String script, String fileName) {
        String fileNewName = String.format(filePath, fileName);

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileNewName));
            bufferedWriter.write(script);
            bufferedWriter.flush();
            activateFlyway();
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private String getScriptVersion() {

        String query = "select version from flyway_schema_history;";
        List<String> list = jdbcTemplate.queryForList(query, String.class);
        int x = list.stream().map(e -> Integer.parseInt(e)).sorted().max(Comparator.comparing(Integer::intValue)).orElse(0);
        x++;
        return Integer.toString(x);
    }

    private String getFileName(String tableName) {

        StringBuilder stringBuilder = new StringBuilder(tableMigration);
        stringBuilder.append("create_%s_table.sql");
        String version = getScriptVersion();

        String fileName= String.format(stringBuilder.toString(), version, tableName);
       

        return fileName;
    }


    private void activateFlyway(){

        Flyway flyway = Flyway.configure().dataSource("jdbc:postgresql://localhost:5455/booking_db", "Marina", "events").load();

        // Запускаем миграции
        flyway.migrate();
    }

    private void restartServer() {


    }
}
