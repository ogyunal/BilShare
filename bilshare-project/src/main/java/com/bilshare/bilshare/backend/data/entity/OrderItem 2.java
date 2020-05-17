package com.bilshare.bilshare.backend.data.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class OrderItem extends AbstractEntity {


	@Min(1)
	@NotNull
	private Integer quantity = 1;

	@Size(max = 255)
	private String comment;


	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}


}
