package Beeeee.com.ex.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="inquiry")

public class InquiryEntity {
	@Id
	@Column(name = "inquiry_id")
	private Long inquiryId;
	
	@Column(name = "inquiry_title")
	private String inquiryTitle;
	
	@Column(name = "inquiry_img")
	private String inquiryImage;
	
	@Column(name = "inquiry_detail")
	private String inquiryDetail;

	public InquiryEntity(String inquiryTitle, String inquiryImage, String inquiryDetail) {
		this.inquiryTitle = inquiryTitle;
		this.inquiryImage = inquiryImage;
		this.inquiryDetail = inquiryDetail;
	}

	public InquiryEntity() {
		
	}

	public Long getInquiryId() {
		return inquiryId;
	}

	public void setInquiryId(Long inquiryId) {
		this.inquiryId = inquiryId;
	}

	public String getInquiryTitle() {
		return inquiryTitle;
	}

	public void setInquiryTitle(String inquiryTitle) {
		this.inquiryTitle = inquiryTitle;
	}

	public String getInquiryImage() {
		return inquiryImage;
	}

	public void setInquiryImage(String inquiryImage) {
		this.inquiryImage = inquiryImage;
	}

	public String getInquiryDetail() {
		return inquiryDetail;
	}

	public void setInquiryDetail(String inquiryDetail) {
		this.inquiryDetail = inquiryDetail;
	}
	
	
	
	
	
	

}
