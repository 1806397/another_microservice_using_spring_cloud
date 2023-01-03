package com.dailycodebuffer.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.dailycodebuffer.user.VO.Department;
import com.dailycodebuffer.user.VO.ResponseTemplateVo;
import com.dailycodebuffer.user.model.User;
import com.dailycodebuffer.user.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RestTemplate restTemplate;
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	public ResponseTemplateVo getUserWithDepartment(Long userId) {
		ResponseTemplateVo vo=new ResponseTemplateVo();
		User user=userRepository.findByUserId(userId);
		Department department=restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"+user.getDepartmentId(), Department.class);
	vo.setUser(user);
	vo.setDepartment(department);
	return vo;
	
	}
	
}
