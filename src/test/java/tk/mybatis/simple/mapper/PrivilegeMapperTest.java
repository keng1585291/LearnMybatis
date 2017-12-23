package tk.mybatis.simple.mapper;

import junit.framework.Assert;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import tk.mybatis.simple.model.SysPrivilege;

public class PrivilegeMapperTest extends BaseMapperTest {
	@Test
	public void selectById(){
		//获取数据库连接会话
		SqlSession sqlSession=getSqlSession();
		try{
			//获取接口
			PrivilegeMapper privilegeMapper=sqlSession.getMapper(PrivilegeMapper.class);
			SysPrivilege privilege=privilegeMapper.selectById(1L);
			//判断不为空
			Assert.assertNotNull(privilege);
			//判断PrivilegeName用户管理
			Assert.assertEquals("用户管理", privilege.getPrivilegeName());
		}finally{
			sqlSession.close();
		}
	}
}
