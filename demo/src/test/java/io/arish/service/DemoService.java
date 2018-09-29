package io.arish.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.Page;

import io.arish.common.utils.PageResult;
import io.arish.entity.SysUserEntity;

@Service
public class DemoService {

	@Autowired
    private SysUserService sysUserService;

	public SysUserEntity queryUser(Long userId){
        return sysUserService.selectById(userId);
    }
	public PageResult queryUser(){
		Map<String, Object> params=new HashMap<>();
		params.put("page", 1);
		params.put("limit", 10);
		params.put("username", "");
		PageResult data=sysUserService.queryPage(params);
		return data;
    }
	
	public String getUserName(long id){
		return sysUserService.getUserName(id);
	}
	
}
