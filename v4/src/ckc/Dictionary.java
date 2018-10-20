package ckc;
import java.util.ArrayList;
/**
 * <div>Lop Dictionary chua mang cac Word{word_target, word_explain}<div>
 * ClassName: Dictionary
 * @author Kieu Chi Cong
 * @author Tran Manh Cuong
 * @version 6.0
 * 
 */
public class Dictionary{
    public ArrayList<Word> arWords= new ArrayList<Word>();
    public ArrayList<Word> arBookMarks = new ArrayList<Word>();
    public ArrayList<Word> arHistorys = new ArrayList<Word>();

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

    /**
     * Them Word vao BookMark
     * @param word Word
     * @return void
     */
    public void addWordToBookMark(Word word) {
        arBookMarks.add(word);
    }

    /**
     * Them Word vao History
     * @param word Word
     * @return void
     */
    public void addWordToHistory(Word word) {
        arHistorys.add(word);
    }

    
}