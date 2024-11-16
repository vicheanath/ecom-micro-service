package com.ecom.domain.entity;

import com.ecom.shared.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private UUID id;
    private String username;
    private String password;
    private String email;
    private List<Role> roleList;

}
