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
		//��ȡsqlSession
		SqlSession sqlSession=getSqlSession();
		try{
			//��ȡRoleMapper�ӿ�
			RoleMapper roleMapper=sqlSession.getMapper(RoleMapper.class);
			//����selectById��������ѯid=1�Ľ�ɫ
			SysRole role =roleMapper.selectById(1L);
			//role��Ϊ��
			Assert.assertNotNull(role);
			//roleName=����Ա
			Assert.assertEquals("����Ա",role.getRoleName());
		}finally{
			//��Ҫ���ǹر�sqlSession
			sqlSession.close();
		}
	}
	
	@Test
	public void testSelectById2(){
		//��ȡsqlSession
		SqlSession sqlSession=getSqlSession();
		try{
			//��ȡRoleMapper�ӿ�
			RoleMapper roleMapper=sqlSession.getMapper(RoleMapper.class);
			//����selectById��������ѯid=1�Ľ�ɫ
			SysRole role =roleMapper.selectById2(1L);
			//role��Ϊ��
			Assert.assertNotNull(role);
			//roleName=����Ա
			Assert.assertEquals("����Ա",role.getRoleName());
		}finally{
			//��Ҫ���ǹر�sqlSession
			sqlSession.close();
		}
	}
	
	@Test
	public void testAll(){
		//��ȡSqlSession
		SqlSession sqlSession=getSqlSession();
		try{
			//��ȡRoleMapper�ӿ�
			RoleMapper roleMapper=sqlSession.getMapper(RoleMapper.class);
			//��ȡȫ���û���ɫ
			List<SysRole> roleList=roleMapper.selectAll();
		    //�жϲ�Ϊ��
			Assert.assertNotNull(roleList);
			//�ж��û���ɫ��������0
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
			//��ȡ�ӿ�
			RoleMapper roleMapper=sqlSession.getMapper(RoleMapper.class);
			//��������
			SysRole sysRole=new SysRole();
			sysRole.setRoleName("��ͨ�û�2");
			sysRole.setRoleEnabled(1L);
			sysRole.setCreateBy(1L);
			sysRole.setCreateTime(new Date());
			//��ȡ����ֵ
			int id=roleMapper.insert(sysRole);
			int id2=roleMapper.insert2(sysRole);
			int id3=roleMapper.insert3(sysRole);
			//�ж��Ƿ�Ϊ��
			Assert.assertNotNull(id);
			Assert.assertNotNull(id2);
			Assert.assertNotNull(id3);
			//�жϻ�ȡ��ID�Ƿ����1��Ӱ���������
			Assert.assertEquals(1,id);
			Assert.assertEquals(1,id2);
			Assert.assertEquals(1,id3);
		}finally{
			//���ûع�����֤��������ֵ
			sqlSession.rollback();
			sqlSession.close();
		}
	}
	
	@Test
	public void testUpdateById(){
		SqlSession sqlSession=getSqlSession();
		try{
			RoleMapper roleMapper=sqlSession.getMapper(RoleMapper.class);
			//��������
			SysRole sysRole=new SysRole();
			sysRole.setRoleId(1L);
			sysRole.setRoleName("��ͨ�û�2");
			sysRole.setRoleEnabled(1L);
			sysRole.setCreateBy(1L);
			sysRole.setCreateTime(new Date());
			//��ȡ����ֵ
			int id=roleMapper.updateById(sysRole);
			//�ж��Ƿ�Ϊ��
			Assert.assertNotNull(id);
			//�жϻ�ȡ��ID�Ƿ����1��Ӱ���������
			Assert.assertEquals(1,id);
		}finally{
			sqlSession.rollback();
			sqlSession.close();
		}
	}
	
	@Test
	public void testDeleteById(){
		//��ȡ��������
		SqlSession sqlSession=getSqlSession();
		try{
			//��ȡ�ӿ�
			RoleMapper roleMapper =sqlSession.getMapper(RoleMapper.class);
			//���ö���
			SysRole sysRole=new SysRole();
			sysRole.setRoleId(1L);
			sysRole.setRoleName("��ͨ�û�2");
			sysRole.setRoleEnabled(1L);
			sysRole.setCreateBy(1L);
			sysRole.setCreateTime(new Date());
			//��ȡ����ֵ
			int id=roleMapper.deleteById(sysRole);
			//�ж��Ƿ�Ϊ��
			Assert.assertNotNull(id);
			//�жϻ�ȡ��ID�Ƿ����1��Ӱ���������
			Assert.assertEquals(1,id);
		}finally{
			sqlSession.rollback();
			sqlSession.close();
		}
	}
}
