public class linked_list {

    private Node head;
    private Node tail;

    private int size = 0;

    private class Node{
        // 데이터가 저장될 필드
        private movie_data_class data;
        // 다음 노드를 가리키는 필드
        private Node next;
        public Node(movie_data_class input) {
            this.data = input;
            this.next = null;
        }

    }
    Node findNodeByIndex(int index) {
        Node x = head;
        for (int i = 0; i < index; i++) {
            x = x.next;
        }
        return x;
    }
    Node findNodeById(String id){
        Node x = head;
        for (int i = 0; i < size; i++) {
            if (x.next.data.get_id().equals(id)){
                return x;
            }
            else if(x.data == null){
                return null;
            }
            x=x.next;
        }
        return null;
    }
    public int getSize(){
        return size;
    }
    public void insertNode(movie_data_class _data, int index){
        Node newNode = new Node(_data);
        if (size==0){ // 원소가 0개
            head = newNode;
            head.next = newNode;
            newNode.next = tail;
        }
        else if (size>=1){
            if(index==0){ // 처음부분에 삽입
                newNode.next=head.next;
                head.next=newNode;
            }
            else if(index>=1) {
                Node tmp1 = findNodeByIndex(index - 1);
                Node tmp2 = tmp1.next;
                tmp1.next = newNode;
                newNode.next = tmp2;
                if (newNode.next == null) {
                    newNode.next = tail;
                }
            }
        }
        size++;
    }
    public void deleteNode(String id){
        Node a = findNodeById(id);
        Node b= a.next;
        a.next=(b.next).next;
        if (a.next==null){
            a.next = tail;
        }
        b.next = null;
        size--;
    }
    public void render(){

    }
    public void print_timeline(){
        Node x = head;
        String timeline="|---";
        for(int i=0;i<size;i++){
            x=x.next;
            timeline+="["+x.data.get_id()+", "+x.data.get_duration()+"sec"+"]---";
        }
        timeline+="[end]";
        System.out.println(timeline);
    }
}
