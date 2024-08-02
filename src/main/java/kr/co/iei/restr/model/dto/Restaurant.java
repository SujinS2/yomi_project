package kr.co.iei.restr.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Restaurant {
	private int restrNo;
	private String restrName;
	private String restrAddr1;
	private String restrAddr2;
	private String restrMapx;
	private String restrMapy;
	private String restrTel;
	private String restrContent;
	private String restrImg1;
	private String restrImg2;
}
