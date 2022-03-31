package org.springcloud.controller;

import java.util.List;

import org.springcloud.pojo.Dept;
import org.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author My 提供RestFul 风格服务
 */
@RestController
public class DeptController {

	@Autowired
	private DeptService deptService;

	// 注入DiscoveryClient
	@Autowired
	private DiscoveryClient discoveryClient;

	@PostMapping("/dept/add")
	public boolean addDept(@RequestBody Dept dept) {
		System.err.println("提供者：" + dept);
		return deptService.addDept(dept);
	}

	@GetMapping("/dept/queryById/{deptno}")
	public Dept queryById(@PathVariable("deptno") Long deptno) {
		return deptService.queryById(deptno);
	}

	@GetMapping("/dept/queryList")
	public List<Dept> queryList() {
		return deptService.queryList();
	}

	// 注册进来的微服务！可以获取一些消息
	@GetMapping("/dept/discovery")
	public Object discovery() {
		// 获取微服务列表清单
		List<String> services = discoveryClient.getServices();
		System.out.println("微服务清单discovery=>" + services);
		// 通过具体的微服务id，也就是application-name，获取具体微服务实例内容
		List<ServiceInstance> instances = discoveryClient.getInstances("SPRINGCLOUD-PROVIDER-DEPT");
		for (ServiceInstance instance : instances) {
			System.out.println(instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri() + "\t"
					+ instance.getServiceId() + "\t");
		}
		return this.discoveryClient;
	}

}
