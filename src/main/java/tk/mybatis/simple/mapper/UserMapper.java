package tk.mybatis.simple.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import tk.mybatis.simple.model.SysRole;
import tk.mybatis.simple.model.SysUser;

public interface UserMapper {
	/**
	 * 通过ID查询用户
	 * 
	 * @param id
	 * @return
	 */
	SysUser selectById(Long id);//可以有多个参数，相较于只是用SQLSession通过命名空间的方法，避免了暴露命名空间

	/**
	 * 查询全部用户
	 */
	List<SysUser> selectAll();
	
	/**
	 * 根据用户ID获取角色信息
	 * @param id
	 * @return
	 */
	List<SysRole> selectRolesByUserId(Long userId);
	
	/**
	 * 新增用户
	 * @param sysUser
	 * @return
	 */
	int insert(SysUser user);
	
	/**
	 * 新增用户——使用useGeneratedkeys方式
	 * @param sysUser
	 * @return
	 */
	int insert2(SysUser sysUser);
	
	/**
	 * 新增用户——使用selectKey方式
	 * @param sysUser
	 * @return
	 */
	int insert3(SysUser sysUser);
	
	/**
	 * 根据主键更新用户
	 * @param sysUser
	 * @return
	 */
	int updateById(SysUser sysUser);
	
	/**
	 * 根据主键删除用户
	 * @param id
	 * @return
	 */
	int deleteById(Long id);//参数也可以是SysUser sysUser
	
	/**
	 * 根据主键删除用户
	 * @param SysUser
	 * @return
	 */
	int deleteById(SysUser sysUser);
	
	/**
	 * 根据用户id和角色的enabled状态获取用户的角色
	 * @param userId
	 * @param enabled
	 * @return
	 */
	List<SysRole> selectRolesByUserIdAndRoleEnabled(@Param("userId")Long userId, @Param("enabled")Integer enabled);
}
