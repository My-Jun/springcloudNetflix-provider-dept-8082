package org.springcloud.service;

import java.util.List;

//通过其他项目导入相关实体
import org.springcloud.pojo.Dept;


public interface DeptService {

	public boolean addDept(Dept dept);

	public Dept queryById(Long deptno);

	public List<Dept> queryList();

}
