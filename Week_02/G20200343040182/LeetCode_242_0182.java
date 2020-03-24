class Solution {
    public boolean isAnagram(String s, String t) {

        char[] arrS = s.toCharArray();
        char[] arrT = t.toCharArray();

        if (arrS.length != arrT.length) {
            return false;
        }
        
        //solv1: sort array
        Arrays.sort(arrS);
        Arrays.sort(arrT);

        if (Arrays.equals(arrS, arrT)) {
            return true;
        }else {
            return false;
        }
    }
}