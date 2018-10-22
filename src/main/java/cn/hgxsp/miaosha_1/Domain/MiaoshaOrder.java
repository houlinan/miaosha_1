package cn.hgxsp.miaosha_1.Domain;

import lombok.Data;

@Data
public class MiaoshaOrder {
	private Long id;
	private int userId;
	private int  orderId;
	private int goodsId;

}
