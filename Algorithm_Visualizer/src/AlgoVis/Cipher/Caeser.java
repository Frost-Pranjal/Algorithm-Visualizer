
package AlgoVis.Cipher;

public class Caeser {

    public int getIndex() {
        return index;
    }

    public void setIndex() {
        this.index = -1;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
        setIndex();
        setCode();
    }

    public String getCode() {
        return code;
    }

    public void setCode() {
        for(int i=0;i<msg.length();i++) {
            char c=msg.charAt(i);
            if(Character.isLetter(c)) {
                int c1=5+c;
                c1=(c1<65)?c1+26:c1;
                c1=(c1>90)?c1-26:c1;
                code=code+(char)(c1);
            }
            else
                code=code+c;
        }
    }
    
    private String msg,code;
    private int index;
    public Caeser(String msg){
        this.msg = msg;
    }
    
    public void code(){
        index++;
        if(msg.charAt(index)>code.charAt(index))
            msg=msg.substring(0,index)+(char)(msg.charAt(index)-1)+msg.substring(index+1);
        else if(msg.charAt(index)<code.charAt(index))
            msg=msg.substring(0,index)+(char)(msg.charAt(index)+1)+msg.substring(index+1);
    }
}
