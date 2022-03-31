package org.springcloud.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
//通过其他项目导入相关实体
import org.springcloud.pojo.Dept;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface DeptDao {

	public boolean addDept(Dept dept);

	public Dept queryById(Long deptno);

	public List<Dept> queryList();

}
