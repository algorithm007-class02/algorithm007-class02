import java.util.TreeMap;

/**
 * @Auther: yys
 * @Date: 2020/2/6 15:23
 * @Description:
 */
public class Trie {

    private class Node{
        public boolean isWord;
        public TreeMap<Character,Node> next;


        public Node(boolean isWord){
            this.isWord=isWord;
            next=new TreeMap<Character, Node>();
        }

        public Node(){
            this(false);
        }

    }

    private Node root;

    public Trie(){
        root=new Node();
    }

    //向Trie添加一个新单词word
    public void insert(String word){

        //根节点
        Node cur=root;
        for (int i = 0; i <word.length() ; i++) {

            //获得单词中的每一个字母
            Character c=word.charAt(i);
            //先判断这个字母在这个树中之前有没有这个字符
            //如果没有的话，我们就添加
            //之前就存在，我们就让他到下面一个节点，继续查下一个字符
            //最后判断
            if (cur.next.get(c)==null){
                cur.next.put(c,new Node());
            }
            cur=cur.next.get(c);
        }
        //要先判断到达最后一个字符的时候，存不存在这个单词
        //如果不存在，则给他设置存在，维护一下size
        if (!cur.isWord){
            cur.isWord=true;
        }

    }

    //查询单词word是否在Trie中
    public boolean search(String word){

        Node cur=root;

        for (int i = 0; i <word.length() ;i++) {
            Character c=word.charAt(i);
            if (cur.next.get(c)==null){
                return false;
            }
            cur=cur.next.get(c);
        }

        return cur.isWord;
    }


    //查询是否在Trie中有单词以prefix为前缀
    public boolean startsWith(String prefix){

        Node cur=root;
        for (int i = 0; i < prefix.length(); i++) {
            Character c=prefix.charAt(i);
            if (cur.next.get(c)==null){
                return false;
            }
            cur=cur.next.get(c);
        }
        return true;
    }

}