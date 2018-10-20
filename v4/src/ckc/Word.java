package ckc;
/**
 * <div>Dinh nghia Word gom co tu goc va tu giai nghia</div>
 * ClassName: Word
 * @author Kieu Chi Cong
 * @author Tran Manh Cuong
 * @version 1.0
 * 
 */
public class Word{
    public String word_target, word_explain;
    /**
     * Constructor
     */
    public Word(){}
    /**
     * Constructor
     * @param word_target String
     * @param word_explain String
     */
    public Word(String word_target, String word_explain){
        this.word_target = word_target;
        this.word_explain = word_explain;
    }


}