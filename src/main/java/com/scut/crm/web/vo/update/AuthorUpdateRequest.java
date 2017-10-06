package com.scut.crm.web.vo.update;

import lombok.Data;

@Data
public class AuthorUpdateRequest {

    private Integer id;

    private String serialNumber;

    private String name;

    private String phone;

    private String address;

}
