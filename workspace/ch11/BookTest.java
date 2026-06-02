package ch11;

// 하나의 소스코드(.java) 내에 여러개의 클래스를 정의할 수 있음
// 단, public class는 하나에만 지정 가능하고 파일명과 동일한 클래스에만 지정가능함
class Book {
    private String title;
    private String author;

    // 생성자 작성
    public Book(){
        this("제목미상","작가미상"); // 자신의 생성자 호출
    }

    // 생성자 작성
    public Book(String title, String author){
        this.title = title;
        this.author = author;
    }

    public void setBook(String title, String author){
        this.title = title;
        this.author = author;
    }
    public String getTitle(){
        return this.title;
    }
    public String getAuthor(){
        return this.author;

    }
}

public class BookTest{
    public static void main(String[] args) {
        Book book1 = new Book();
        book1.setBook("자바 기초","자바의 신");

        Book book2 = new Book("자바를 자바라! ", "용쌤");

        System.out.println("제목: " + book1.getTitle() + " 작가: " + book1.getAuthor());
        System.out.println("제목: " + book2.getTitle() + " 작가: " + book2.getAuthor());

    }
}
