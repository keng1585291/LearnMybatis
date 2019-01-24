package tk.mybatis.simple.mapper;

import java.util.Date;
import java.util.List;

import junit.framework.Assert;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import tk.mybatis.simple.model.SysRole;

public class RoleMapperTest extends BaseMapperTest{
	@Test
	public void testSelectById(){
		//获取sqlSession
		SqlSession sqlSession=getSqlSession();
		try{
			//获取RoleMapper接口
			RoleMapper roleMapper=sqlSession.getMapper(RoleMapper.class);
			//调用selectById方法，查询id=1的角色
			SysRole role =roleMapper.selectById(1L);
			//role不为空
			Assert.assertNotNull(role);
			//roleName=管理员
			Assert.assertEquals("管理员",role.getRoleName());
		}finally{
			//不要忘记关闭sqlSession
			sqlSession.close();
		}
	}
	
	@Test
	public void testSelectById2(){
		//获取sqlSession
		SqlSession sqlSession=getSqlSession();
		try{
			//获取RoleMapper接口
			RoleMapper roleMapper=sqlSession.getMapper(RoleMapper.class);
			//调用selectById方法，查询id=1的角色
			SysRole role =roleMapper.selectById2(1L);
			//role不为空
			Assert.assertNotNull(role);
			//roleName=管理员
			Assert.assertEquals("管理员",role.getRoleName());
		}finally{
			//不要忘记关闭sqlSession
			sqlSession.close();
		}
	}
	
	@Test
	public void testAll(){
		//获取SqlSession
		SqlSession sqlSession=getSqlSession();
		try{
			//获取RoleMapper接口
			RoleMapper roleMapper=sqlSession.getMapper(RoleMapper.class);
			//获取全部用户角色
			List<SysRole> roleList=roleMapper.selectAll();
		    //判断不为空
			Assert.assertNotNull(roleList);
			//判断用户角色数量大于0
			Assert.assertTrue(roleList.size()>0);
		}finally{
			sqlSession.close();
		}
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testInsert(){
		SqlSession sqlSession=getSqlSession();
		try{
			//获取接口
			RoleMapper roleMapper=sqlSession.getMapper(RoleMapper.class);
			//创建对象
			SysRole sysRole=new SysRole();
			sysRole.setRoleName("普通用户2");
			sysRole.setRoleEnabled(1L);
			sysRole.setCreateBy(1L);
			sysRole.setCreateTime(new Date());
			//获取返回值
			int id=roleMapper.insert(sysRole);
			int id2=roleMapper.insert2(sysRole);
			int id3=roleMapper.insert3(sysRole);
			//判断是否为空
			Assert.assertNotNull(id);
			Assert.assertNotNull(id2);
			Assert.assertNotNull(id3);
			//判断获取的ID是否等于1（影响的行数）
			Assert.assertEquals(1,id);
			Assert.assertEquals(1,id2);
			Assert.assertEquals(1,id3);
		}finally{
			//设置回滚，保证不插入数值
			sqlSession.rollback();
			sqlSession.close();
		}
	}
	
	@Test
	public void testUpdateById(){
		SqlSession sqlSession=getSqlSession();
		try{
			RoleMapper roleMapper=sqlSession.getMapper(RoleMapper.class);
			//创建对象
			SysRole sysRole=new SysRole();
			sysRole.setRoleId(1L);
			sysRole.setRoleName("普通用户2");
			sysRole.setRoleEnabled(1L);
			sysRole.setCreateBy(1L);
			sysRole.setCreateTime(new Date());
			//获取返回值
			int id=roleMapper.updateById(sysRole);
			//判断是否为空
			Assert.assertNotNull(id);
			//判断获取的ID是否等于1（影响的行数）
			Assert.assertEquals(1,id);
		}finally{
			sqlSession.rollback();
			sqlSession.close();
		}
	}
	
	@Test
	public void testDeleteById(){
		//获取数据连接
		SqlSession sqlSession=getSqlSession();
		try{
			//获取接口
			RoleMapper roleMapper =sqlSession.getMapper(RoleMapper.class);
			//设置对象
			SysRole sysRole=new SysRole();
			sysRole.setRoleId(1L);
			sysRole.setRoleName("普通用户2");
			sysRole.setRoleEnabled(1L);
			sysRole.setCreateBy(1L);
			sysRole.setCreateTime(new Date());
			//获取返回值
			int id=roleMapper.deleteById(sysRole);
			//判断是否为空
			Assert.assertNotNull(id);
			//判断获取的ID是否等于1（影响的行数）
			Assert.assertEquals(1,id);
		}finally{
			sqlSession.rollback();
			sqlSession.close();
		}
	}
}
