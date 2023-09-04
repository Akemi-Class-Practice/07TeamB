package Beeeee.com.ex.model.dao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import Beeeee.com.ex.model.entity.LessonEntity;
import jakarta.transaction.Transactional;

public interface LessonDao extends JpaRepository<LessonEntity, Long> {
	List<LessonEntity> findByAdminId(Long adminId);
	
	LessonEntity save(LessonEntity lessonEntity);
	
	LessonEntity findByLessonNameAndlessonRegisterDate(String LessonName,LocalDate lessonRegisterDate);
	
	LessonEntity findByBlogId(Long lessonId);
	
	@Transactional
	List<LessonEntity> deleteByLessonId(Long lessonId);

}
