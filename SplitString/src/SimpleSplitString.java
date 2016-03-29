/**
 * Created by florianfrank on 29.03.16.
 */
public class SimpleSplitString implements SplitString {

    protected int cursorPosition;
    protected String string;

    public SimpleSplitString(String string){
        if(string == null){
            throw new NullPointerException();
        }
            this.string = string;
        this.cursorPosition = 0;
    }

    @Override
    public int getCursor() {
        return cursorPosition;
    }

    @Override
    public SplitString forward() {
        if(this.cursorPosition != this.string.length()){
            this.cursorPosition++;
        }
        return this;
    }

    @Override
    public SplitString home() {
        this.cursorPosition = 0;
        return this;
    }

    @Override
    public String toString(){
            return this.string.substring(this.cursorPosition,this.string.length());
    }

    @Override
    public boolean equals(Object anything){
        if(anything != null){
        SimpleSplitString compareObject = (SimpleSplitString) anything;
            if(compareObject.string.equals(this.string) && compareObject.cursorPosition == this.cursorPosition){
                return true;
            }else {
                return false;
            }
        }else {
            return false;
        }

    }

}
