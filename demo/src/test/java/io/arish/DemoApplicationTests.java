package io.arish;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.baomidou.mybatisplus.plugins.Page;

import io.arish.common.utils.PageResult;
import io.arish.entity.SysUserEntity;
import io.arish.service.DemoService;
import io.arish.service.SysUserService;






@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	 @Autowired
	   DataSourceProperties dataSourceProperties;

	   @Autowired
	   ApplicationContext applicationContext;
//	   @Autowired
//	   DataSource myDataSource;
	 @Autowired
	 private DemoService demoService;
	@Test
	public void contextLoads() {
        SysUserEntity user1=demoService.queryUser(1L);
        System.out.println(ToStringBuilder.reflectionToString(user1));
        
        PageResult data=demoService.queryUser();
        System.out.println("条数"+data.getTotal());       
	}
	@Test
	public void myBatisXmlTest(){
		 System.out.println(demoService.getUserName(1));
	}
//	@Test
//	public void dataSourceTest(){
//		 JdbcTemplate jdbcTemplate = new JdbcTemplate(myDataSource);
//	      List<?> resultList = jdbcTemplate.queryForList("select * from sys_user");
//	      System.out.println("===>>>>>>>>>>>" +resultList.toString());
//	}

}
