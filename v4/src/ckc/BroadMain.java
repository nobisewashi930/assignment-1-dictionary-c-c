package ckc;

/**
 * <div>Lop Main chua ham main chay chuong trinh</div>
 * ClassName: Main
 * @author Kieu Chi Cong
 * @author Tran Manh Cuong
 * @version 6.0
 * 
 */
public class BroadMain{
    public static void main(String[] args){

        //gọi mẫu thử các hàm sử dụng

        Dictionary dict = new Dictionary();
        DictionaryCommandline dcl = new DictionaryCommandline();
        DictionaryManagement dm = new DictionaryManagement();
        ConfigConnection cf = new ConfigConnection();

        Word word = new Word("CONG", "KIEU CHI CONG");

        // NẾU sủ dụng DATABASE để tìm kiếm, thêm, sửa, xóa thì gọi hàm như sau

        //tìm kiếm các từ có dạng "ca......." hiện tại dang để trả ra tối đa 20 từ
        cf.searchInDb("ca");

        //thêm từ vào database
        cf.insert("kieu chi cong","toan cham dead line :v");

        //sửa từ trong database
        cf.update("kieu chi cong","chuyên gia châm dead line");

        //xóa từ khỏi database
        cf.delete("");




        //cac ham đoi voi book mark

        //load dữ liệu từ file txt vào book mark khi bắt đầu chạy chương trình
        dm.BookMarkImportFromFile(dict);

        //chèn dữ liệu trả về file txt khi hết chương trình
        dm.BookMarkExportToFile(dict);

        //thêm 1 từ vào book mark
        dict.addWordToBookMark(word);

        //kiểm tra xem 1 từ đã có trong bookmark hay chưa
        dm.bookMarkLookup(dict,"CONG");



        //các hàm đối với history

        //thêm từ vào lịch sử
        dict.addWordToHistory(word);
    }
}