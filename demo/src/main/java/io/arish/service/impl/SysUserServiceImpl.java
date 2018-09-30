

package io.arish.service.impl;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import io.arish.common.utils.PageResult;
import io.arish.dao.SysUserDao;
import io.arish.entity.SysUserEntity;
import io.arish.service.SysUserService;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import java.util.Map;



/**
 * 系统用户
 * 
 * @date 2018-5-18 15:25:15
 */
@Service("sysUserService")

public class SysUserServiceImpl extends BaseServiceImpl<SysUserDao, SysUserEntity> implements SysUserService {
	
//	@Autowired
//	private SysUserDao sysUserDao;
	@Override
	public PageResult queryPage(Map<String, Object> params) {
		String username = (String)params.get("username");
		int page = (int)params.get("page");
		int limit = (int)params.get("limit");
		Page<SysUserEntity> pages=new Page<SysUserEntity>(page,limit);
		 pages = this.selectPage(
				 pages,
			new EntityWrapper<SysUserEntity>()
				.like(StringUtils.isNotBlank(username),"username", username)
				
		);
	
		return new PageResult(pages);
	}

	@Override
	public String getUserName(long id) {
		// TODO Auto-generated method stub
		return this.baseMapper.queryUserName(id);
	}
	

}
