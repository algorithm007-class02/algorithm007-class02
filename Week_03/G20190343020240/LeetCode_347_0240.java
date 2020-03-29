import java.util.*;

class Solution {
    /*
    1.hashMap存储，键存储数字，值存储数字出现次数
    2.使用小顶堆存储k个数字（数字频率从小到大的排列后的map），添加元素时，比较小顶堆堆顶元素和新插入元素出现的次数
    3.list存储小顶堆中k个元素
     */
    public List<Integer> topKFrequent(int[] nums, int k){
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int num : nums){
            if(map.containsKey(num)){
                map.put(num,map.get(num) + 1);
            }else{
                map.put(num,1);
            }
        }

        Queue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer a,Integer b){
                return map.get(a) - map.get(b);
            }
        });
        for(Integer key : map.keySet()){
            if(heap.size() < k){
                heap.add(key);
            }else if(map.get(key) > map.get(heap.peek())){
                heap.remove();
                heap.add(key);
            }
        }

        List<Integer> list = new ArrayList<Integer>();
        while(!heap.isEmpty()){
            list.add(heap.remove());
        }
        return list;
    }
}