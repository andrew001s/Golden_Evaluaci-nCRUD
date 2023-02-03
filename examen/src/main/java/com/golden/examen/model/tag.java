package com.golden.examen.model;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Document
public class tag {
    @Id
    private String id;
    private String email;
    private String mailPass;
    private String phone;
    private String CountryPhone;
    private String tag;
    private LocalDateTime createdAt;
    private Boolean active;

}
