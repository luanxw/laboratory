package com.app.luan.DataMaskAnnotation;

import lombok.Data;


@Data
public class User {
    /**
     * 主键ID
     */
    private Long id =1L;

    /**
     * 姓名
     */
    @DataMasking(maskFunc = DataMaskingFunc.ALL_MASK)
    private String name = "allen";

    /**
     * 年龄
     */
    private Integer age =18;

    /**
     * 邮箱
     */
//    @DataMasking(maskFunc = DataMaskingFunc.ALL_MASK)
    private String email = "ai-ways@email.com ";

}