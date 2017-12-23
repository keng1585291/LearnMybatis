package tk.mybatis.simple.mapper;

import java.util.Date;
import java.util.List;

import junit.framework.Assert;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import tk.mybatis.simple.model.SysRole;
import tk.mybatis.simple.model.SysUser;

public class UserMapperTest extends BaseMapperTest{
	@Test
	public void testSelectById(){
		SqlSession sqlSession=getSqlSession();
		try {
			// 使用接口编程，不同于仅使用XML
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			
			// 调用SelectByID方法，查询id=1的用户
			SysUser user = userMapper.selectById(1L);
			// User不为空
			Assert.assertNotNull(user);
			// userName=admin
			Assert.assertEquals("admin", user.getUserName());
		} finally {
			sqlSession.close();
		}
	}
	
	@Test
	public void testSelectAll(){
		SqlSession sqlSession=getSqlSession();
		try{
			//获取接口
			UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
			
			List<SysUser> userList=userMapper.selectAll();			
			// User不为空
			Assert.assertNotNull(userList);
						// userName=admin
			Assert.assertTrue(userList.size()>0);
		}finally{
			sqlSession.close();
		}
	}
	
	@Test
	public void testSelectRolesByUserId(){
		SqlSession sqlSession=getSqlSession();
		try{
			UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
			List<SysRole> sysRoleList=userMapper.selectRolesByUserId(1L);
			Assert.assertNotNull(sysRoleList);
			Assert.assertTrue(sysRoleList.size()>0);
		}finally{
			sqlSession.close();
		}
	}
	
	@Test
	public void testInsert(){
		SqlSession sqlSession=getSqlSession();
		try{
			UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
			//创建一个user对象
			SysUser user=new SysUser();
			user.setUserName("test1");
			user.setUserPassword("123456");
			user.setUserEmail("test@mybatis.tk");
			user.setUserInfo("test info");
			//正常情况下应该读入一张图片存到byte数组中
			user.setHeadImg(new byte[]{1,2,3});
			user.setCreateTime(new Date());
			//将创建的对象插入数据库中，特别注意这里的返回值result是执行的SQL影响的行数
			int result =userMapper.insert(user);
			//只插入一条数据
			Assert.assertEquals(1, result);
			//id为null,没有给id赋值，并且没有配置回写ID的值
			Assert.assertNull(user.getId());
		}finally{
			sqlSession.close();
		}
	}
	
	@Test
	public void testInsert2(){
		SqlSession sqlSession = getSqlSession();
		try{
			UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
			//创建一个user对象
			SysUser user=new SysUser();
			user.setUserName("test1");
			user.setUserPassword("123456");
			user.setUserEmail("test@mybatis.tk");
			user.setUserInfo("test info");
			//正常情况下应该读入一张图片存到byte数组中
			user.setHeadImg(new byte[]{1,2,3});
			user.setCreateTime(new Date());
			//将创建的对象插入数据库中，特别注意这里的返回值result是执行的SQL影响的行数
			int result =userMapper.insert2(user);
			//只插入一条数据
			Assert.assertEquals(1, result);
			//id为null,没有给id赋值，并且没有配置回写ID的值
			Assert.assertNotNull(user.getId());
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			sqlSession.rollback();
			sqlSession.close();
		}
	}
	
	@Test
	public void testInsert3(){
		SqlSession sqlSession = getSqlSession();
		try{
			UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
			//创建一个user对象
			SysUser user=new SysUser();
			user.setUserName("test1");
			user.setUserPassword("123456");
			user.setUserEmail("test@mybatis.tk");
			user.setUserInfo("test info");
			//正常情况下应该读入一张图片存到byte数组中
			user.setHeadImg(new byte[]{1,2,3});
			user.setCreateTime(new Date());
			//将创建的对象插入数据库中，特别注意这里的返回值result是执行的SQL影响的行数
			int result =userMapper.insert3(user);
			//只插入一条数据
			Assert.assertEquals(1, result);
			//id为null,没有给id赋值，并且没有配置回写ID的值
			Assert.assertNotNull(user.getId());
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			sqlSession.rollback();
			sqlSession.close();
		}
	}
	
	@Test
	public void testUpdateById(){
		SqlSession sqlSession=getSqlSession();
		try{
			UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
			SysUser user=userMapper.selectById(1L);
			//判断用户不为空
			Assert.assertNotNull(user);
			//admin用户
			Assert.assertEquals("admin", user.getUserName());
			
			user.setUserName("admin_test");
			user.setUserEmail("test@mybatis.tk");
			
			int result=userMapper.updateById(user);			
			Assert.assertEquals(1, result);
			
			user=userMapper.selectById(1L);
			Assert.assertNotNull(user);
			Assert.assertEquals("admin_test", user.getUserName());
		}finally{
			sqlSession.rollback();
			sqlSession.close();
		}
	}
	
	@Test
	public void testDeleteById(){
		SqlSession sqlSession=getSqlSession();
		try{
			UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
			SysUser user1=userMapper.selectById(1L);
			Assert.assertNotNull(user1);
			
			Assert.assertEquals(1, userMapper.deleteById(1L));
			Assert.assertNull(userMapper.selectById(1L));
			
			SysUser user2=userMapper.selectById(1001L);
			Assert.assertNotNull(user2);
			
			Assert.assertEquals(1, userMapper.deleteById(user2));
			Assert.assertNull(userMapper.selectById(1001L));
		}finally{
			sqlSession.rollback();
			sqlSession.close();
		}
	}
	
	@Test
	public void testSelectRolesByUserIdAndRoleEnabled(){
		SqlSession sqlSession=getSqlSession();
		try{
			UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
			//调用selectRolesByUserIdAndRoleEnabled方法查询用户的角色
			List<SysRole> userList=userMapper.selectRolesByUserIdAndRoleEnabled(1L, 1);
			//判断结果是否为空
			Assert.assertNotNull(userList);
		    //判断角色数量是否大于0
			Assert.assertTrue(userList.size()>0);
		}finally{
			sqlSession.close();
		}
	}
}
