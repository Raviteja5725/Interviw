package com.est.test.service;

import java.sql.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.est.test.entity.User_Master;
import com.est.test.exception.BusinessException;
import com.est.test.repository.RoleMaster_Repository;
import com.est.test.repository.UserMasterrepository;

@Service
public class UserMaster_Service_Implementation implements User_Master_Service_Interface{
	@Autowired
	UserMasterrepository usermaster_repository;
	@Autowired
	RoleMaster_Repository rolemaster_repository;
	@Override
	public User_Master AddUser(User_Master usermaster) {
		User_Master adduser=usermaster;

		if (!(usermaster_repository.findByuserName(adduser.getUsername()) == null)) {
			throw new BusinessException("username  already Exists",
					"Entered username already exsists in DataBase");
		}
		if (!(usermaster_repository.findByEmail(adduser.getEmail()) == null)) {
			throw new BusinessException("Email  already Exists",
					"Entered Email already exsists in DataBase");
		}

		if ((usermaster_repository.findByuserName(adduser.getUsername()) == null
				&& (usermaster_repository.findByEmail(adduser.getEmail()) == null)) ){
				
			try {
				adduser = usermaster_repository.save(usermaster);
				adduser.setEmail(usermaster.getEmail());
				adduser.setFullName(usermaster.getFullName());
				adduser.setStatus(usermaster.getStatus());
				adduser.setRoleName(usermaster.getRoleName());
				adduser.setCreated_Date(usermaster.getCreated_Date());
				adduser.setUpdated_Date(usermaster.getUpdated_Date());
				return adduser;
			} catch (IllegalArgumentException e) {
				throw new BusinessException("useMaster-adduser",
						"Not Valid usermasterName, Please Enter Valid Name " + e.getMessage());
			} catch (Exception e) {
				throw new BusinessException("useMaster",
						"Something went wrong in service layer " + e.getMessage());
			}
		} else {
			throw new BusinessException("useMaster-adduser-1;",
					"Email Id or Mobile Already Exsists in DataBase ");
		}

	}
	 @Override
	    public User_Master updateUser(String userName, User_Master userMaster) {
	        User_Master datas=userMaster;
	        Date date=new Date(0);
	        if (!(usermaster_repository.findByEmail(datas.getEmail()) == null)) {
	        
	            throw new BusinessException("Email ID ", "Entered Email Id already exsists in DataBase");
	        }
	        User_Master modifySaved = usermaster_repository.findByuserName(userName);
	        
	        modifySaved.setEmail(userMaster.getEmail());
	        userMaster.setCreated_Date(modifySaved.getCreated_Date());
	        modifySaved.setFullName(userMaster.getFullName());
	        modifySaved.setStatus(userMaster.getStatus());
	        modifySaved.setUpdated_Date(date.toString());
	        
	        return usermaster_repository.save(modifySaved);
	 }
	@Override
	public void deleteUserbyid(Long id) {
		if(!usermaster_repository.existsById(id)) {
			throw new BusinessException("UserMaster-Delete Group By ID",
					" user ID Not found in DataBase, Please enter valid ID");
		}
		User_Master gc =	usermaster_repository.findById(id).get();
		usermaster_repository.delete(gc);
		
	}
	@Override
	public List<User_Master> getAllUserdata() {
		List<User_Master> userlist = null;
		try {
			userlist = usermaster_repository.findAll();
		} catch (Exception e) {
			throw new BusinessException("UserMaster_Service_Implementation getalluserdata",
					"Something went wrong in service layer while fetching all user details  " + e.getMessage());
		}
		if (userlist.isEmpty()) {
			throw new BusinessException("UserMaster_Service_Implementation getalluserdata",
					" List is Empty, Add Some Data in Register Page... ");
		}
		return userlist;
	}
	@Override
	public User_Master getuserbyId(Long id) {
		if (id.equals(null)) {
			throw new BusinessException("UserMaster_Service_Implementation-userByid",
					"You Entered a null value, please Enter Any int Value");
		}try {
			return usermaster_repository.findById(id).get();
		} catch (NoSuchElementException e) {
			throw new BusinessException("UserMaster_Service_Implementation-userByid",
					"user _Id ID Not found in DataBase, Please enter valid ID " + e.getMessage());
		} catch (IllegalArgumentException e) {
			throw new BusinessException("UserMaster_Service_Implementation-userByid",
					"Something went wrong in service layer " + e.getMessage());
		}

	}
	
	
	
	
}
