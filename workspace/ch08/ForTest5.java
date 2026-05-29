package ch08;

import java.sql.SQLOutput;

public class ForTest5 {
    public static void main(String[] args) {
        //star1();
        //star2();
        //star3();
        //star4();
    }

    // *
    // **
    // ***
    // ****
    // *****
//    static void star1(){
//        for(int i=0; i<5; i++){
//            for(int j=0; j<i+1; j++){
//                System.out.print("*");
//            }
//            System.out.println();
//        }
//    }

    // *
    // **
    // ***
    // ****
    // **..** 50개
    static void star2(){
        for(int i=0; i<50; i++){
            for(int j=0; j<i+1; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }


    // *****
    // ****
    // ***
    // **
    // *
    static void star3(){
        for(int i=0; i<5; i++){
            for(int j=5; j>i; j--){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    //     *
    //    **
    //   ***
    //  ****
    // *****
//    static void star4(){
//        for(int i=0; i<5; i++){
//            for(int j=5; j>i+1; j--){
//                System.out.print(" ");
//            }
//            for(int k=0; k<i+1; k++){
//                System.out.print("*");
//            }
//            System.out.println();
//        }
//    }
}
