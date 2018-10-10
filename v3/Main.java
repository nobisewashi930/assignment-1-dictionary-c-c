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
        boolean running = true;
        DictionaryManagement management = new DictionaryManagement();
        Dictionary dict = new Dictionary();
        Dictionary dict2= new Dictionary();
        Dictionary dict3= new Dictionary();
        DictionaryCommandline dc = new DictionaryCommandline();

        //while(running){
            
            // dc.dictionaryBasic(management, dict);
            dict = dc.dictionaryAdvanced(management, dict);
            // dict2 = management.editFromCommandline(dict);
            // dict3 = management.deleteFromComandline(dict2);
            dc.showAllWords(dict);
            dc.dictionarySearcher(dict);
            management.dictionaryExportToFile(dict);
        //}
        
    }
}