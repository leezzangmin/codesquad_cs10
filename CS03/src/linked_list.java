public class linked_list {

    private Node head;
    private Node tail;

    private int size = 0;

    private class Node{
        private movie_data_class data;
        private Node next;
        public Node(movie_data_class input) {
            this.data = input;
            this.next = null;
        }

    }
    Node findNodeByIndex(int index) {
        Node x = head;
        for (int i = 0; i < index-1; i++) {
            x = x.next;
        }
        return x;
    }
    Node findNodeById(String id){
        Node x = head;
        for (int i = 0; i < size; i++) {
            if (x.data.get_id().equals(id)){
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
            if(newNode.next==null){
                tail=newNode;
            }
        }
        else if (size>=1){
            if(index==0){ // 처음부분에 삽입
                head.next=newNode.next;
                head=newNode;
            }

            else if(index>=1) {
                Node tmp1 = findNodeByIndex(index);
                newNode.next=tmp1.next;
                tmp1.next=newNode;

                if (newNode.next == null) {
                    tail=newNode;
                }
            }
        }
        size+=1;
    }
    public void deleteNode(String id){
        Node a = findNodeById(id);
        a.next=(a.next).next;
        if (a.next==null){
            tail=a;
        }
        size-=1;
    }
    public void render(){
        Node x = head;
        int wholeDuration=0;
        for(int i=0;i<size;i++){
            wholeDuration+=x.data.get_duration();
            x=x.next;
        }
        System.out.println("영상클립 : "+size+"개");
        System.out.println("전체길이 :"+wholeDuration+"sec");
    }
    public void print_timeline(){
        Node x = head;
        String timeline="|---";
        for(int i=0;i<size;i++){
            timeline+="["+x.data.get_id()+", ";
            timeline+=x.data.get_duration()+"sec"+"]---";
            x=x.next;
        }
        timeline+="[end]";
        System.out.println(timeline);
    }
}