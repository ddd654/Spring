package com.coding404.myweb.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data@Builder
public class ProductUploadVO {

    private int uploadNo; //pk
    private String filename;
    private String filepath;
    private String uuid;
    private LocalDateTime regdate;
    private int prodId; //fk
    private String prodWriter; //fk
}
