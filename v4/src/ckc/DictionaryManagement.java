package ckc;
import java.io.*;
import java.util.Scanner;

/**
 * <div>Quan li tu dien</div>
 * ClassName: DictionaryManagement
 * @author Kieu Chi Cong
 * @author Tran Manh Cuong
 * @version 6.0
 * 
 */
public class DictionaryManagement{
    public DictionaryManagement(){}
    
    /**
     * Chen du lieu cho bookMark tu file su dung Scanner
     * @param  dict Dictionary
     * @return dict Dictionary
     */
    public Dictionary BookMarkImportFromFile(Dictionary dict){
        String myPath = "C:/Users/Lenovo/Desktop/1234/src/ckc/";
        File file = new File(myPath+"BookMark.txt");

        try {
            Scanner sc = new Scanner(file);            
            Word word ;    
            while(sc.hasNextLine()){
                String stringWord = sc.nextLine();

                //trong file co dinh dang: phan cach giua tu va giai nghia la dau tab
                Scanner s = new Scanner(stringWord).useDelimiter("s*\ts*");
                String target = s.next();
                String explain = s.next();
                word = new Word(target,explain);            
                dict.addWordToBookMark(word);
            }            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }        
        finally{
            return dict;
        }        
    }

    /**
     * Xuat du lieu tư bookMark ra file su dung Scanner
     * @param dict Dictionary
     * @return dict Dictionary
     */
    public void BookMarkExportToFile(Dictionary dict){

        String myPath = "C:/Users/Lenovo/Desktop/1234/src/ckc/";
        try {
            FileOutputStream outFile = new FileOutputStream(myPath+"BookMark.txt");
            BufferedOutputStream stream = new BufferedOutputStream (outFile);

            int n = dict.arBookMarks.size();
            for(int i = 0; i<n ;i++){
                String line = dict.arBookMarks.get(i).word_target+"\t" + dict.arBookMarks.get(i).word_explain;
                stream.write(line.getBytes());
                stream.write(System.lineSeparator().getBytes()) ;

            }
            stream.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * kiem tra tu da có trong bookMark chưa
     * @param dict Dictionary
     * @return boolean
     */
    public boolean bookMarkLookup(Dictionary dict, String word){
        boolean check = false;
        int n= dict.arBookMarks.size();
        for(int i=0 ; i<n ; i ++)
            if(dict.arBookMarks.get(i).word_target.equals(word))
            {
                check = true;
            }
         return check;
    }


    // hai hàm dưới này dùng khi sử dụng database theo cách load hết dữ liệu vào ArrayList
//    /**
//     * tim kiem tu trong tu dien
//     * @param dict Dictionary
//     * @return void
//     */
//    public void dictionaryLookup(Dictionary dict){
//        String a = "";
//        System.out.println("Ban hay nhap tu muon tra:");
//        Scanner sc = new Scanner(System.in);
//        a= sc.nextLine();
//        int i;
//        int n= dict.arWords.size();
//        for(i=0 ; i<n ; i ++)
//            if(dict.arWords.get(i).word_target.equals(a))
//            {
//                System.out.printf("%s :%s\n",a,dict.arWords.get(i).word_explain);
//            }
//    }
//
//
//
//    /**
//    *Xoa tu khoi tu dien
//    *@return dict Dictionary
//    */
//    public Dictionary deleteFromComandline(Dictionary dict){
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Nhap chinh xac tu tieng anh muon xoa");
//        String word = sc.nextLine();
//        int n = dict.arWords.size();
//        for(int i = 0; i<n ;i++){
//            // if(dict.arWords.get(i)==null)return dict;
//            if(dict.arWords.get(i).word_target.equals(word))
//            {
//                dict.arWords.remove(i);
//                n--;
//            }
//
//        }
//        if(dict.arWords.size()<n)
//            System.out.println("Thao tac xoa khong thanh cong do ban nhap tu khong co trong tu dien");
//
//        return dict;
//    }


}