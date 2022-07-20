package com.app.luan.DataMaskAnnotation;



public interface DataMaskingOperation {

    String MASK_CHAR = "*";
    
    String mask(String content, String maskChar);

}

