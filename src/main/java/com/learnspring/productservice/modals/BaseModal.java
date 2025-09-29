package com.learnspring.productservice.modals;

import lombok.Getter;
import lombok.Setter;

import javax.xml.crypto.Data;
import java.util.Date;
@Getter
@Setter
public class BaseModal {
    private long id;
    private Date createdAt;
    private Date updatedAt;
}
