package com.scut.crm.web.vo.save;

import lombok.Data;

@Data
public class PatentSaveRequest {

    private String name;

    private String type;

    private String state;

    private String author_serialNumber;

}
