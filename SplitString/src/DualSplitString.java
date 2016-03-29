/**
 *  This class represents a string with two cursorPositions.
 * The defaultposition of the first cursor is before the first lettern the position of the second cursor
 * is after the last letter of the string.
 * You can shift the cursors and print out the substring from one to the other cursorposition.
 *
 * Hochschule München, Fakultät 07
 * Softwarearchitektur, IF4B
 * @author Florian Frank, Alioun Diagne
 * @version 29.03.2016
 *
 */
public class DualSplitString extends SimpleSplitString{

    /**current cursorposition of the second cursor*/
    private int cursorPosition2;

    /**
     * The constructor allocates the delivered string
     * and sets the cursors to the default values
     * @param string delivered string
     */
    public DualSplitString(String string){
        super(string);
        this.cursorPosition2 = string.length();
    }

    /**
     * shifts the second cursor about one step forward and returns the current object
     * if the cursor is at the end of the string it only returns the object
     * @return current object
     */
    public DualSplitString forward2(){
        if(this.cursorPosition2 != this.string.length()){
            this.cursorPosition2++;
        }
        return this;
    }

    /**
     * sets the second cursor to it's default position
     * @return current object
     */
    public DualSplitString home2(){
        this.cursorPosition2 = 0;
        return this;
    }

    /**
     * returns position of the second cursor
     * @return cursorposition2
     */
    public int getCursor2(){
        return this.cursorPosition2;
    }

    /**
     * returns the string between cursor1 and cursor2
     * @return substring between the cursorpositions
     */
    @Override
    public String toString(){
        if(this.cursorPosition > this.cursorPosition2){
            return this.string.substring(this.cursorPosition2,this.cursorPosition);
        }else {
            return this.string.substring(this.cursorPosition,this.cursorPosition2);
        }
    }

    /**
     * checks if string, cursor1 and cursor2 are equal to the delviered object
     * @param anything object to compare
     * @return boolean if comparison is true or false
     */
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
