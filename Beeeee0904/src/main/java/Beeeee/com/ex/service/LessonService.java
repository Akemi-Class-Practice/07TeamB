package Beeeee.com.ex.service;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import Beeeee.com.ex.model.dao.LessonDao;
import Beeeee.com.ex.model.entity.LessonEntity;

@Service
public class LessonService {
	@Autowired
	private LessonDao lessonDao;
	
	public List<LessonEntity> findAllLessonPost(Long adminId) {
		if(adminId == null) {
			return null;
		}else {
			return lessonDao.findByAdminId(adminId);
		}
	}
	
	public boolean createLessonPost(String lessonName, Long lessonFee, String lessonDetail, String imgName, Time startTime,
			Time finishTime, LocalDate lessonRegisterDate, LocalDate lessonStartDate) {
		LessonEntity lessonList = lessonDao.findByLessonNameAndlessonRegisterDate(lessonName, lessonRegisterDate);
		if(lessonList == null) {
			lessonDao.save(new LessonEntity(lessonName,lessonFee,lessonDetail,imgName,startTime,finishTime,lessonRegisterDate,lessonStartDate));
			return true;
		}else {
			return false;
		}
	}
	
	public LessonEntity getLessonPost(Long lessonId) {
		if(lessonId == null) {
			return null;
		}else {
			return lessonDao.findByBlogId(lessonId);
		}
	}

}
