package ch02.list;

public class MyLinkedList implements MyList{
    // inner 클래스 생성
    private class Node{
        /**
         * 저장할 객체
         */
        private Object data;

        /**
         * 연결된 다음 노드를 참조하는 변수
         */
        private Node nextNode;

        Node(Object data){
            this.data = data;
            this.nextNode = null;
        }
    }

    /**
     * 첫번째 노드
     */
    private Node header;
    /**
     * 전체 요소의 수
     */
    private int size;

    public MyLinkedList(){
        header = new Node(null);
    }
    // 헤더의 값은 null이다
    public void addFirst(Object data){
        Node node = new Node(data);
        // 헤더가 가리키고 있는 첫번째 노드의 주소를 삽입한 노드의 nextNode로 지정
        node.nextNode = header.nextNode;
        // 헤더의 첫번째 노드를 새로 생성한 노드로 지정
        header.nextNode = node;
        size++;
    }

    /**
     * data를 index 위치에 삽입하낟.
     * @param index data가 삽입될 위치
     * @param data 삽입할 데이터
     */
    public void add(int index, Object data){
        if(index == 0){
            addFirst(data);
        }else{
            Node newNode = new Node(data); // 추가할 새로운 노드
            Node pNode = getNode(index-1); // index에 있던 원래 노드
            Node nNode = pNode.nextNode; // 원래 노드의 다음 노드를 nNode에 저장
            newNode.nextNode = nNode; // 새 노드의 다음 노드를 원래 idx다음 노드로 지정
            pNode.nextNode = newNode; // 원래 있던 노드의 다음 노드를 새 노드로 교체

            size++;
        }
    }
    /**
     * data를 리스트의 마지막에 추가한다.
     * @param data 추가할 데이터
     */
    public void add(Object data){
        add(size, data);
    }
    /**
     * 리스트의 첫번째 요소를 삭제한다.
     */
    private void removeFirst() {
        // TODO 첫번째 노드의 다음 노드를 첫번째 노드로 지정하고
        Node firstNode = header.nextNode;
        header.nextNode = firstNode.nextNode;
        // 첫번째 노드의 데이터를 반환한 후 사이즈 감소
        size--;
    }
    /**
     * 지정한 index 요소를 삭제한다.
     * @param index 삭제한 요소의 index
     */
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        } else if (index == 0) {
            removeFirst();
        }

        // TODO 지정한 인덱스의 이전 노드와 해당 노드,
        // 다음 노드를 찾은 후
        Node pNode = getNode(index-1); // 삭제할 노드의 이전 노드
        Node rNode = pNode.nextNode; // 삭제할 노드
        Node nNode = rNode.nextNode; // 삭제할 노드의 다음 노드

        pNode.nextNode = nNode;
        size--;
    }

    /**
     * 전체 요소의 수를 반환
     * @return 전체 요소의 수
     */
    public int size(){
        return this.size;
    }
    public String toString() {
        StringBuffer result = new StringBuffer("[");
        Node node = header.nextNode;
        if (node != null) {
            result.append(node.data);
            node = node.nextNode;
            while (node != null) {
                result.append(", ");
                result.append(node.data);
                node = node.nextNode;
            }
        }
        result.append("]");
        return result.toString();
    }
    /**
     * index 위치의 Node를 찾아서 반환한다
     * @param index 찾을 index
     * @return 찾아낸 Node
     */
    private Node getNode(int index){
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node node = header.nextNode; // 첫번째 노드
        for(int i=0; i < index; i++){
            node = node.nextNode; // 2번째 노드를 node 객체에 담는다.
        }
        return node;
    }
    /**
     * 지정한 index의 요소를 반환한다.
     * @param index 요소의 index
     * @return index 위치의 요소
     */
    public Object get(int index){
        return getNode(index).data;
    }

}
