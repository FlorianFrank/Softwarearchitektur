/*
* This class represents a simple string with a cursorPosition.
* The defaultposition of the cursor is before the first letter of the string.
* You can shift the cursor and print out the substring from the cursorposition to the end of the string
*
* Hochschule München, Fakultät 07
* Softwarearchitektur, IF4B
* @author Florian Frank, Alioun Diagne
* @version 29.03.2016
*
**/
public class SimpleSplitString implements SplitString {

    /*The current position of the cursor*/
    protected int cursorPosition;
    /**deliverd string*/
    protected String string;

    /**
     * constructor allocates the delivered string
     * and sets the cursorPosition to 0
     * @param string delivered String
     */
    public SimpleSplitString(String string){
        if(string == null){
            throw new NullPointerException();
        }
            this.string = string;
        this.cursorPosition = 0;
    }

    /**
     * returns the current cursorposition
     * @return current cursorposition
     */
    @Override
    public int getCursor() {
        return cursorPosition;
    }

    /**
     * shifts the cursor about one step forward and returns the current object
     * if the cursor is at the end of the string it only returns the object
     * @return current object
     */
    @Override
    public SplitString forward() {
        if(this.cursorPosition != this.string.length()){
            this.cursorPosition++;
        }
        return this;
    }

    /**
     * sets the cursor to the defaultposition
     * @return current object
     */
    @Override
    public SplitString home() {
        this.cursorPosition = 0;
        return this;
    }

    /**
     * returns a substring from the cursorposition to the end of the string
     * @return substring from cursorposition to the end
     */
    @Override
    public String toString(){
            return this.string.substring(this.cursorPosition,this.string.length());
    }

    /**
     * checks if string and cursorposition of the current and the delivered object are equal
     * @param anything object to compare
     * @return boolean if objects are equal or not
     */
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
