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
@SuppressWarnings("PMD.NoPackage")
public class DualSplitString extends SimpleSplitString{

    /**current cursorposition of the second cursor.*/
    private int cursorPosition2;

    /** The constructor allocates the delivered string.
     * and sets the cursors to the default values
     * @param string delivered string
     */
    public DualSplitString(String string){
        super(string);
        this.cursorPosition2 = string.length();
    }

    /** Shifts the second cursor about one step forward and returns the current object.
     * If the cursor is at the end of the string it only returns the object
     * @return current object
     */
    public DualSplitString forward2(){
        if(this.cursorPosition2 != this.getString().length()){
            this.cursorPosition2++;
        }
        return this;
    }

    /** Sets the second cursor to it's default position.
     * @return current object
     */
    public DualSplitString home2(){
        this.cursorPosition2 = 0;
        return this;
    }

    /** Returns position of the second cursor.
     * @return cursorposition2
     */
    public int getCursor2(){
        return this.cursorPosition2;
    }

    /** Returns the string between cursor1 and cursor2.
     * @return substring between the cursorpositions
     */
    @Override
    public String toString(){
        if(this.getCursorPosition() > this.cursorPosition2){
            return this.getString().substring(this.cursorPosition2,this.getCursorPosition());
        }else {
            return this.getString().substring(this.getCursorPosition(),this.cursorPosition2);
        }
    }

    /** Checks if string, cursor1 and cursor2 are equal to the delviered object.
     * @param o object to compare
     * @return boolean if comparison is true or false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        final DualSplitString that = (DualSplitString) o;

        return cursorPosition2 == that.cursorPosition2;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + cursorPosition2;
        return result;
    }
}
