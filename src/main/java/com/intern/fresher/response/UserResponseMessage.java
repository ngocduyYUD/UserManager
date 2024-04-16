package com.intern.fresher.response;

import com.intern.fresher.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserResponseMessage {
    @Autowired
    private int status;
    @Autowired
    private String message;
    @Autowired
    private int code;
    @Autowired
    private List<User> data;

}
