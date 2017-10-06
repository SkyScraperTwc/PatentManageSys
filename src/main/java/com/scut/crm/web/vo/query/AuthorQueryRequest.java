package com.scut.crm.web.vo.query;

import lombok.Data;

@Data
public class AuthorQueryRequest {

    private String serialNumber;

    private String name;

    private String phone;

    private String currentPage;

}
