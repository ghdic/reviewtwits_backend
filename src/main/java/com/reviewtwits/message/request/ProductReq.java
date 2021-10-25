package com.reviewtwits.message.request;

import lombok.Data;

@Data
public class ProductReq {
    String domain;
    String path;
    int income;
    String goodsName;
    int price;
}
