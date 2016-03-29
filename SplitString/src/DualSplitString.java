/**
 * Created by florianfrank on 29.03.16.
 */
public class DualSplitString extends SimpleSplitString{

    private int cursorPosition2;

    public DualSplitString(String string){
        super(string);
        this.cursorPosition2 = string.length();
    }

    public DualSplitString forward2(){
        if(this.cursorPosition2 != this.string.length()){
            this.cursorPosition2++;
        }
        return this;
    }

    public DualSplitString home2(){
        this.cursorPosition2 = 0;
        return this;
    }

    public int getCursor2(){
        return this.cursorPosition2;
    }

    @Override
    public String toString(){
        if(this.cursorPosition > this.cursorPosition2){
            return this.string.substring(this.cursorPosition2,this.cursorPosition);
        }else {
            return this.string.substring(this.cursorPosition,this.cursorPosition2);
        }
    }

    @Override
    public boolean equals(Object anything){
        if(anything != null) {
            DualSplitString compareObject = (DualSplitString) anything;
            if (compareObject.string.equals(this.string) && compareObject.cursorPosition2 == this.cursorPosition2 &&
                    compareObject.cursorPosition == this.cursorPosition) {
                return true;
            } else {
                return false;
            }
        }else {
            return false;
        }
    }


}
