package com.est.test.service;


import java.util.List;

import com.est.test.entity.User_Master;
public interface User_Master_Service_Interface {
    User_Master getuserbyId(Long id);
	User_Master AddUser(User_Master userMaster);
	User_Master updateUser(String userName, User_Master userMaster);
    void deleteUserbyid(Long id);
    List<User_Master> getAllUserdata();

	
}
