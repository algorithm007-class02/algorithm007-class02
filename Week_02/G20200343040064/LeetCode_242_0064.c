/**
 * 242. 有效的字母异位词
 * */

bool isAnagram(char * s, char * t){
    if(s==NULL || t==NULL) 
        return false;
    int len = strlen(s);
    if(len != strlen(t))
        return false;

    int num1[26] = {0};
    int num2[26] = {0};
    for(int i=0;i<len;i++) {
        num1[s[i]-'a'] ++;
        num2[t[i]-'a'] ++;        
    }
    return memcmp(num1,num2,26*sizeof(int))==0;
}