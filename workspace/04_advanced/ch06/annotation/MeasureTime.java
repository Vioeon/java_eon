package ch06.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 메소드를 대상으로 지정
@Target(ElementType.METHOD)
// 실행 시점에 사용 가능하도록 유지 정책을 RUNTIME으로 지정
@Retention(RetentionPolicy.RUNTIME)
public @interface MeasureTime {

}
