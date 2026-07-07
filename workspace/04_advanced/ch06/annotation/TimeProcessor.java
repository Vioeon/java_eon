package ch06.annotation;

import java.lang.reflect.Method;

public class TimeProcessor {
    public void process(Object target){
        Method[] methods = target.getClass().getDeclaredMethods();

        for(Method method : methods){
            // 어노테이션 객체 정보 확인
            // @MeasureTime 어노테이션이 붙어 있는지 확인
            if(method.isAnnotationPresent(MeasureTime.class)){
                MeasureTime measureTime = method.getAnnotation(MeasureTime.class);
                String taskName = measureTime.taskName().isEmpty()? method.getName() : measureTime.taskName();
                long start = System.currentTimeMillis();
                try {
                    method.invoke(target); // target 객체의 method 메서드를 호출
                }catch(Exception e){
                    System.err.println("대상 메소드 호출 예외: " + e.getMessage());
                }
                long end = System.currentTimeMillis();
                System.out.println(taskName + " 소요시간: " + (end-start) + "ms");
            }
        }
    }
}
