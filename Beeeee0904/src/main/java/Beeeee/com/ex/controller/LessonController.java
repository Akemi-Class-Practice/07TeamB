package Beeeee.com.ex.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import Beeeee.com.ex.model.entity.AdminEntity;
import Beeeee.com.ex.model.entity.LessonEntity;
import Beeeee.com.ex.service.LessonService;
import jakarta.servlet.http.HttpSession;

@RequestMapping("admin/lesson")
@Controller
public class LessonController {
	@Autowired
	private LessonService lessonService;
	
	@Autowired
	private HttpSession session;
	
	//講座一覧画面の表示
	@GetMapping("/list")
	public String getLessonListPage(Model model) {
		AdminEntity adminList = (AdminEntity) session.getAttribute("admin");
		Long adminId = adminList.getAdminId();
		String adminName = adminList.getAdminName();
		List<LessonEntity>lessonList = lessonService.findAllLessonPost(adminId);
		model.addAttribute("adminName",adminName);
		model.addAttribute("lessonList",lessonList);
		return "admin_list.html";
	}
	
	@GetMapping("/register")
	public String getLessonRegisterPage(Model model) {
		AdminEntity adminList =  (AdminEntity) session.getAttribute("admin");
		
		String adminName = adminList.getAdminName();
		model.addAttribute("adminName",adminName);
		model.addAttribute("registerLesson","新規講座登録");
		return "admin_register.html";
		
	}
	
	@PostMapping("/register/process")
	public String lessonRegister(
			@RequestParam LocalDate lessonRegisterDate,
			@RequestParam String imgName,
			@RequestParam String lessonName,
			@RequestParam Long lessonFee, 
			@RequestParam String lessonDetail,
			Model model) {
		AdminEntity adminList = (AdminEntity) session.getAttribute("admin");
		Long adminId = adminList.getAdminId();
		
		String fileName = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-").format(new Date())
			+ imgName.getOriginalFilename();
			try {
				Files.copy(imgName.getInputStream(), Path.of("src/main/resources/static/images/" + fileName));
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(lessonService.createLessonPost(lessonName, lessonFee, lessonDetail, imgName, null, null, lessonRegisterDate, lessonRegisterDate)) {
				return "redirect:admin/lesson/list";
			}else {
				model.addAttribute("registerMessage","既に登録完成です");
				return "lesson_register.html";
			}
	}

	
	//ログアウト
	@GetMapping("/logout")
	public String Logout() {
		session.invalidate();
		return "redirect:admin/login";
	}

	

}
