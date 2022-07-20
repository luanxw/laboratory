package com.app.luan.DataMaskAnnotation;

import java.lang.annotation.*;

/**
 * @author allen
 */
@Target({ElementType.TYPE,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataMasking {

    DataMaskingFunc maskFunc() default DataMaskingFunc.NO_MASK;

}
