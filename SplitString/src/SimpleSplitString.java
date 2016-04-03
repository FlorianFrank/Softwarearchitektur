/**
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

    /**The current position of the cursor.*/
    protected int cursorPosition;
    /**deliverd string.*/
    protected String string;

    /** Constructor allocates the delivered string.
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

    /** Returns the current cursorposition.
     * @return current cursorposition
     */
    @Override
    public int getCursor() {
        return cursorPosition;
    }

    /** Shifts the cursor about one step forward and returns the current object.
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

    /** Sets the cursor to the defaultposition.
     * @return current object
     */
    @Override
    public SplitString home() {
        this.cursorPosition = 0;
        return this;
    }

    /** Returns a substring from the cursorposition to the end of the string.
     * @return substring from cursorposition to the end
     */
    @Override
    public String toString(){
            return this.string.substring(this.cursorPosition,this.string.length());
    }

    /** Checks if string and cursorposition of the current and the delivered object are equal.
     * @param o object to compare
     * @return boolean if objects are equal or not
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final SimpleSplitString string1 = (SimpleSplitString) o;

        if (cursorPosition != string1.cursorPosition) return false;
        return string.equals(string1.string);

    }

    @Override
    public int hashCode() {
        int result = cursorPosition;
        result = 31 * result + string.hashCode();
        return result;
    }
}
