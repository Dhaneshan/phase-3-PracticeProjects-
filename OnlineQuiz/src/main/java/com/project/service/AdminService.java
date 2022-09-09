package com.project.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.Admin;
import com.project.repo.AdminRepository;

@Service
public class AdminService {
	
	@Autowired
	private AdminRepository adminRepository;
	
	public Boolean verifyAdmin(String email, String password)
	{
		List<Admin> admins = adminRepository.findAll();
		
		for(Admin admin : admins)
		{
			if(admin.getAdmin_mail().equals(email) && admin.getAdmin_password().equals(password)) 
			{ 
				return true;
			}
		}
		return false;
	}
	
	
	
	public void changePassword(int id, String newPassword)
	{
		Admin admin = adminRepository.findById(id).get();
		
		admin.setAdmin_password(newPassword);
		
		adminRepository.save(admin);
		
		System.out.println("Password Changed Successfully");
	}

	
}