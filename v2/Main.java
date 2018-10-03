/**
 * <div>Lop Main chua ham main chay chuong trinh</div>
 * ClassName: Main
 * @author Kieu Chi Cong
 * @author Tran Manh Cuong
 * @version 1.0
 * 
 */
public class Main{
    public static void main(String[] args){
        DictionaryManagement management = new DictionaryManagement();
        Dictionary dict = new Dictionary();
        DictionaryCommandline dc = new DictionaryCommandline();
        // dc.dictionaryBasic(management, dict);
        dc.dictionaryAdvanced(management, dict);
    }
}