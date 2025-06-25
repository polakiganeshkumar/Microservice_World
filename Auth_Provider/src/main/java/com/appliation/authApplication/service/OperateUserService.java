package com.appliation.authApplication.service;

import com.appliation.authApplication.dto.RequestUser;
import com.appliation.authApplication.model.UserDetail;
import com.appliation.authApplication.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperateUserService {


    @Autowired
    private UserDetailsRepository repo;

    public String SaveUser(RequestUser user){
        UserDetail users=new UserDetail();
        users.setUserName(user.getUserName());
        users.setPassword(user.getPassword());
        users.setEmail(user.getEmail());
          repo.save(users);
        return "savedUser";
    }

}
