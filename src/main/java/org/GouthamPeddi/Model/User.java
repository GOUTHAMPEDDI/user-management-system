package org.GouthamPeddi.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer userId;
    private String  actualName;
    private String userName;
    private String userEmail;
    private String userAddress;
    private String userContact;
    private Type userType;

}