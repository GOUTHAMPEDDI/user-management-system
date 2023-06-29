package org.GouthamPeddi.Service;

import org.GouthamPeddi.Model.User;
import org.GouthamPeddi.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    public String createUser(User user) {
        userRepo.getUserList().add(user);
        return "User Added";
    }

    public User getUser(Integer uId) {
        List<User> userList = userRepo.getUserList();
        return userList.get(uId);
    }

    public List<User> getAllUsers() {
        return userRepo.getUserList();
    }

    public String modifyUser(Integer uId,User user) {
        List<User> userList = userRepo.getUserList();
        for(User myuser : userList){
            if(myuser.getUserId().equals(uId)) {
                User newuser = getUser(uId);
                newuser.setActualName(user.getActualName());
                newuser.setUserName(user.getUserName());
                newuser.setUserEmail(user.getUserEmail());
                newuser.setUserAddress(user.getUserAddress());
                newuser.setUserContact(user.getUserContact());
                return "User Info Updated";
            }
        }
        return "User " + " : "+ uId +  "  was not found";
    }

    public String removeUser(Integer uId) {
        List<User> userList = getAllUsers();
        for(User user : userList){
            if(user.getUserId().equals(uId)){
                userList.remove(user);
                return "User : " + uId +  "  deleted";
            }
        }
        return "User " +" : "+ uId +  "was not found";
    }
}
