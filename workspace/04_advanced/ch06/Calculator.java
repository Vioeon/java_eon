package ch06;

@FunctionalInterface // 메소드 1개만 있어야 한다.
public interface Calculator {
    int add(int a, int b);
}
