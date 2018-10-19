package cn.hgxsp.miaosha_1.Domain;

import lombok.Data;

import java.util.Date;
@Data
public class OrderInfo {
	private int id;
	private int userId;
	private int goodsId;
	private int  deliveryAddrId;
	private String goodsName;
	private Integer goodsCount;
	private Double goodsPrice;
	private Integer orderChannel;
	private Integer status;
	private Date createDate;
	private Date payDate;

}
