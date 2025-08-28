package make.kon;

/**
 * @author MakeCat
 */
public interface Select<Cursor> {
    Cursor cursor();

    int length();
    char[] copy();
}
