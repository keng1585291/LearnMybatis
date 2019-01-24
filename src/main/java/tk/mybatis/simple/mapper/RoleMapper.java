package tk.mybatis.simple.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import tk.mybatis.simple.model.SysRole;

public interface RoleMapper {
	@Select({"select id,role_name roleName,enabled,create_by createBy,create_time createTime",
			"from sys_role","where id = #{id}"})
	SysRole selectById(Long id);
	
	@Results({
		@Result(property="roleId",column="id",id =true),
		@Result(property="roleName",column="role_name"),
		@Result(property="roleEnabled",column="enabled"),
		@Result(property="createBy",column="create_by"),
		@Result(property="createTime",column="create_time")
	})
	@Select("select id,role_name roleName,enabled,create_by createBy,create_time createTime from sys_role where id = #{id}")
	SysRole selectById2(Long id);
	
	@Results({
		@Result(property="roleId",column="id",id =true),
		@Result(property="roleName",column="role_name"),
		@Result(property="roleEnabled",column="enabled"),
		@Result(property="createBy",column="create_by"),
		@Result(property="createTime",column="create_time")
	})
	//@Results(id="resultmap" value={
	//  @Result(property="id",column="",id=true)})
	@Select("select * from sys_role")
	List<SysRole> selectAll();
	
	//不需要返回主键
	@Insert({"insert into sys_role(role_name,enabled,create_by,create_time)",
		"values(#{roleName},#{roleEnabled},#{createBy},#{createTime,jdbcType=TIMESTAMP})"})
	int insert(SysRole sysRole);
	
	//返回自增主键
	@Insert({"insert into sys_role(role_name,enabled,create_by,create_time)",
		"values(#{roleName},#{roleEnabled},#{createBy},#{createTime,jdbcType=TIMESTAMP})"})
	@Options(useGeneratedKeys=true,keyProperty="id")
	int insert2(SysRole sysRole);
	
	//返回非自增式主键
	@Insert({"insert into sys_role(role_name,enabled,create_by,create_time)",
		"values(#{roleName},#{roleEnabled},#{createBy},#{createTime,jdbcType=TIMESTAMP})"})
	@SelectKey(statement="SELECT LAST_INSERT_ID()",
	           resultType=Long.class,
	           keyProperty="roleId",
	           before=false)
	int insert3(SysRole sysRole);
	
	//更新数据
	@Update({"update sys_role",
		     "set role_name=#{roleName}",
		         "enabled=#{roleEnabled}",
		         "create_by=#{createBy}",
		         "create_time=#{createTime}",
		     "where id=#{roleId}"})
	int updateById(SysRole sysRole);
	
	//删除数据
	@Delete({"delete from sys_role where id=#{roleId}"})
	int deleteById(SysRole sysRole);
}
