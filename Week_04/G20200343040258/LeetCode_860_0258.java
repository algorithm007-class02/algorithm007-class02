class Solution {
    public boolean lemonadeChange(int[] bills) {
       //贪心 20的话 优先使用 10 5
       int five = 0;
       int ten = 0;
       for(int bill : bills){
           switch(bill){
               case 5 : five++; break;
               case 10 : ten++; five--;break;
               case 20 : {
                   if(ten > 0){
                       ten--;
                       five--;
                   }else{
                       five -= 3;
                   }
               }
               default:break;
           }
           if(five < 0){
               return false;
           }
       }
       return true; 
    }
}