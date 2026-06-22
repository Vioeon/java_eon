package ch02.array;

import java.util.Collection;

public class PerformanceTest {
    void main(){
        int times = 100000;

        MyArray list = new MyArray(times);

        long start = System.currentTimeMillis();
        //addFirst(list,times);
        addLast(list,times);
        System.out.println("저장된 수: " + list.size());
        long end = System.currentTimeMillis();
        System.out.println("MyArray addFirst 소요 시간: " + (end-start) + "ms");
    }

    void addFirst(MyArray list, int times){
        for(int i=0; i<times; i++){
            list.append(0, "데이터-" + i);
        }
    }

    void addLast(MyArray list, int times){
        for(int i=0; i<times; i++){
            list.append("데이터-" + i);
        }
    }
}
