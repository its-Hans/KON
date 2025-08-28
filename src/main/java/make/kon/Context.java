package make.kon;

/**
 * @author MakeCat
 */
public interface Context<Cursor> {
    void continu();
    void continu(int step);

    boolean hasNext();
    boolean hasNext(int step);

    /**
     * index: current
     * <br>
     * update: false
     * */
    char peek();
    char peek(int step);
    void peek(char[] buf);

    /**
     * index: current
     * <br>
     * update: true
     * */
    char next();
    void next(char[] buf);

    /**
     * index: next
     * <br>
     * update: true
     * */
    char read();

    Select<Cursor> select();
    Context<Cursor> copy();

    void apply(Cursor cursor);
}