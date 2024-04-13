package com.example.db_booking.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;

@Data
@AllArgsConstructor
public class TableDto {

    public String tableName;
    public HashMap<String, String> columnNamesAndDataTypes;

}
