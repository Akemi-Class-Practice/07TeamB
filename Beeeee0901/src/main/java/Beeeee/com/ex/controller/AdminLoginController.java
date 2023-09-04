package Beeeee.com.ex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Beeeee.com.ex.model.entity.AdminEntity;
import Beeeee.com.ex.service.AdminService;
import jakarta.servlet.http.HttpSession;

@RequestMapping("/admin")
@Controller
public class AdminLoginController {
	@Autowired
	private AdminService adminService;
	@Autowired
	private HttpSession session;
	
	@GetMapping("/login")
	public String getAdminLoginPage() {
		return "admin_login.html";
	}

	@PostMapping("/login/process")
	public String login(@RequestParam String adminEmail,@RequestParam String adminPassword) {
		AdminEntity adminList = adminService.loginAdmin(adminEmail, adminPassword);
		if(adminList == null) {
			return "redirect:admin/login";
		}else {
			session.setAttribute("admin", adminList);
			return "redirect:/admin/lesson/list";
		}
	}
	

}
