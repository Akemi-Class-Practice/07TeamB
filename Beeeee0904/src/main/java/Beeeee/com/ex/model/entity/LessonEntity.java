package Beeeee.com.ex.model.entity;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="lesson")

public class LessonEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "lesson_id")
	private Long lessonId;
	
	@Column(name = "lesson_name")
	private String lessonName;
	
	@Column(name = "lesson_fee")
	private Long lessonFee;
	
	@Column(name = "lesson_detail")
	private String lessonDetail;
	
	@Column(name = "img_name")
	private String imgName;
	
	@Column(name = "start_time")
	private Time startTime;
	
	@Column(name = "finish_time")
	private Time finishTime;
	
	@Column(name = "register_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate lessonRegisterDate;
	
	@Column(name = "start_date")
	private LocalDate lessonStartDate;
	
	@Column(name = "delete_flag")
	private Long lessonDeleteFlag;

	public LessonEntity(String lessonName, Long lessonFee, String lessonDetail, String imgName, Time startTime,
			Time finishTime, LocalDate lessonRegisterDate, LocalDate lessonStartDate) {
		this.lessonName = lessonName;
		this.lessonFee = lessonFee;
		this.lessonDetail = lessonDetail;
		this.imgName = imgName;
		this.startTime = startTime;
		this.finishTime = finishTime;
		this.lessonRegisterDate = lessonRegisterDate;
		this.lessonStartDate = lessonStartDate;
		
	}

	public LessonEntity() {
		
	}

	public Long getLessonId() {
		return lessonId;
	}

	public void setLessonId(Long lessonId) {
		this.lessonId = lessonId;
	}

	public String getLessonName() {
		return lessonName;
	}

	public void setLessonName(String lessonName) {
		this.lessonName = lessonName;
	}

	public Long getLessonFee() {
		return lessonFee;
	}

	public void setLessonFee(Long lessonFee) {
		this.lessonFee = lessonFee;
	}

	public String getLessonDetail() {
		return lessonDetail;
	}

	public void setLessonDetail(String lessonDetail) {
		this.lessonDetail = lessonDetail;
	}

	public String getImgName() {
		return imgName;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
	}

	public Time getStartTime() {
		return startTime;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	public Time getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(Time finishTime) {
		this.finishTime = finishTime;
	}

	public LocalDate getLessonRegisterDate() {
		return lessonRegisterDate;
	}

	public void setLessonRegisterDate(LocalDate lessonRegisterDate) {
		this.lessonRegisterDate = lessonRegisterDate;
	}

	public LocalDate getLessonStartDate() {
		return lessonStartDate;
	}

	public void setLessonStartDate(LocalDate lessonStartDate) {
		this.lessonStartDate = lessonStartDate;
	}

	public Long getLessonDeleteFlag() {
		return lessonDeleteFlag;
	}

	public void setLessonDeleteFlag(Long lessonDeleteFlag) {
		this.lessonDeleteFlag = lessonDeleteFlag;
	}
	
	
	
	
	

}
