package cn.hgxsp.miaosha_1.Domain;

import lombok.Data;

@Data
public class MiaoshaOrder {
	private Long id;
	private Long userId;
	private Long  orderId;
	private Long goodsId;

}
