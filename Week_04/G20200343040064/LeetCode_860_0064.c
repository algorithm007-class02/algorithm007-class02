/**
 * 860. 柠檬水找零
 * */

bool lemonadeChange(int* bills, int billsSize){
    int dollar5  = 0;
    int dollar10 = 0;
    for(int i=0;i<billsSize;++i) {
        if(bills[i]==5) ++dollar5;
        else if(bills[i] == 10)  --dollar5,++dollar10;
        else if(dollar10)  -- dollar10, -- dollar5;        
        else dollar5 -= 3;
        if(dollar5 < 0) return false;
    }
    return true;
}