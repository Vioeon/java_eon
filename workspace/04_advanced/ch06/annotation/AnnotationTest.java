package ch06.annotation;

public class AnnotationTest {
    void main(){
        Work w = new Work();
//        w.task1();
//        w.task2();
        TimeProcessor processor = new TimeProcessor();
        processor.process(w);
        // 먼저실행되는 task가 메모리 로딩, 초기화 작업 등으로 인해 시간이 좀더 오래걸린다.
        // 정확한 성능 측정의 지표는 아님. 어노테이션 작동 방식 확인
    }
}
