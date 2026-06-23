package ch02.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackTest {
    void main(){
        Stack stc = new Stack();

        stc.push(10);
        stc.push(20);
        stc.push(30);
        stc.push(40);

        System.out.println(stc.size());

        System.out.println(stc.pop());
        System.out.println(stc.pop());
        System.out.println(stc.pop());

        System.out.println(stc.size());
    }
}
