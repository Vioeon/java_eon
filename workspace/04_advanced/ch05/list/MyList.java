package ch05.list;

public interface MyList<T> {
    /**
     * 지정한 데이터를 마지막 요소로 삽입
     * @param obj 삽입할 데이터
     */
    void add(T obj);

    /**
     * 지정한 데이터를 index위치에 삽입
     * @param index 삽입할 위치
     * @param obj 삽입할 데이터
     */
    void add(int index, T obj);

    /**
     * 지정한 index의 데이터를 삭제
     * @param index 삭제할 위치
     */
     void remove(int index);

    /**
     * 지정한 index의 데이터를 조회
     * @param index 조회할 위치
     * @return 조회할 데이터
     */
     T get(int index);

    /**
     * 데이터의 수를 반환
     * @return 데이터의 개수
     */
     int size();
}
