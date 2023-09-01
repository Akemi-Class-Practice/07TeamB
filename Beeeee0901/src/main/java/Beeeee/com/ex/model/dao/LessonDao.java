package Beeeee.com.ex.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import Beeeee.com.ex.model.entity.LessonEntity;

public interface LessonDao extends JpaRepository<LessonEntity, Long> {

}
