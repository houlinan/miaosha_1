package cn.hgxsp.miaosha_1.Domain;

import lombok.Data;

@Data
public class Goods {
	private int id;
	private String goodsName;
	private String goodsTitle;
	private String goodsImg;
	private String goodsDetail;
	private Double goodsPrice;
	private Integer goodsStock;

}
