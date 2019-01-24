package tk.mybatis.simple.mainclass;

import java.io.IOException;
import java.io.Reader;
import java.util.Date;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import junit.framework.Assert;
import tk.mybatis.simple.mapper.RoleMapper;
import tk.mybatis.simple.mapper.UserMapper;
import tk.mybatis.simple.model.SysRole;
import tk.mybatis.simple.model.SysUser;

public class BaseTest {
	private static SqlSessionFactory sqlSessionFactory;
	
	private static void init(){
		try {
			Reader reader=Resources.getResourceAsReader("learn/mybatis/config/Configuration.xml");
			sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void insertIntoBase() {
		init();
		SqlSession sqlSession=sqlSessionFactory.openSession();
		try{
			UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
			//创建一个user对象
			SysUser user=new SysUser();
			user.setId(1L);
			user.setUserName("test1");
			user.setUserPassword("123456");
			user.setUserEmail("test@mybatis.tk");
			user.setUserInfo("test info");
			//正常情况下应该读入一张图片存到byte数组中
			user.setHeadImg(new byte[]{1,2,3});
			user.setCreateTime(new Date());
			//将创建的对象插入数据库中，特别注意这里的返回值result是执行的SQL影响的行数
			userMapper.insert(user);
			
		}catch (Exception e) {
			// TODO: handle exception
			if(e.getCause().toString().contains("ConstraintViolationException")) {
				System.out.println("主键已存在");
			}
			else
				System.out.println("出现异常："+e.getCause());
		}finally{
			//设置回滚，保证不插入数值
			//sqlSession.rollback();
			sqlSession.close();
		}
	}
	
	public static void main(String[] args) {
		insertIntoBase();
	}
}
