package org.springcloud.service;

import java.util.List;

import org.springcloud.dao.DeptDao;
import org.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeptServiceImpl implements DeptService {

	@Autowired
	private DeptDao deptDao;

	public boolean addDept(Dept dept) {
		return deptDao.addDept(dept);
	}

	public Dept queryById(Long deptno) {
		return deptDao.queryById(deptno);
	}

	public List<Dept> queryList() {
		return deptDao.queryList();
	}

}
