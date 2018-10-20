import java.util.ArrayList;
/**
 * <div>Lop Dictionary chua mang cac Word{word_target, word_explain}<div>
 * ClassName: Dictionary
 * @author Kieu Chi Cong
 * @author Tran Manh Cuong
 * @version 1.0
 * 
 */
public class Dictionary{
    public ArrayList<Word> arWords = new ArrayList<Word>();

    /**
     * <div>Contructor</div>
     */
    public Dictionary(){}
    /**
     * Them Word vao Dictionary
     * @param word Word
     * @return void
     */
    public void addWordToDictionary(Word word){
        arWords.add(word);
    }
    
}