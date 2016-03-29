/* (C) 2016, R. Schiedermeier, rs@cs.hm.edu
 * Hochschule Muenchen, Fakultaet fuer Informatik und Mathematik, Praktikum Software-Architektur
 * Java 1.8.0_72, Linux x86_64 4.3.0
 * bluna (Intel Core i7-5600U CPU/2.60GHz, 4 cores, 1849 MHz, 16000 MByte RAM)
 **/

/** Unveraenderliche Strings mit einem beweglichen Cursor, der den String in zwei Teile trennt.
 * @author R. Schiedermeier, rs@cs.hm.edu
 * @version 2016-02-19
 */
public interface SplitString {
    /** Liefert die aktuelle Cursorposition.
     * @return Cursorposition zwischen 0 und Stringlaenge (inklusive).
     */
    int getCursor();

    /** Bewegt den Cursor um 1 Zeichen weiter zum Ende des Strings.
     * Ohne Wirkung, wenn der Cursor schon am Ende steht.
     * @return Dieser Splitstring, eventuell mit veraendertem Cursor.
     */
    SplitString forward();

    /** Setzt den Cursor vor das erste Zeichen.
     * @return Dieser Splitstring, eventuell mit veraendertem Cursor.
     */
    SplitString home();

    /** Liefert den Reststring ab dem Cursor.
     * @return Verbleibender String, eventuell leer, aber nicht null.
     */
    @Override
    public String toString();

}