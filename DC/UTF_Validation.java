package DC;

public class UTF_Validation {
    public boolean validUtf8(int[] data) {
        int count=0;
        for(int d:data){
            if(count>0){
                if((0xC0&d)!=(0x80)) return false;
                count--;
            }
            else{
                if((d&0xE0)==0xC0) count=1;
                else if((d&0xF0)==0xE0) count=2;
                else if((d&0xF8)==0xF0) count=3;
                else if((d&0x80)==0) count=0;
                else return false;
            }
        }
        return count==0;
    }
}
