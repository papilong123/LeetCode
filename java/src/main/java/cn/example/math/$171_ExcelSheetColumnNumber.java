package cn.example.math;

public class $171_ExcelSheetColumnNumber {
    public int titleToNumber(String columnTitle) {
        int len = columnTitle.length(), res = 0;
        int multiple = 1;
        for(int i = len-1; i >= 0; i--){
            res += (columnTitle.charAt(i) - 'A' + 1) * multiple;
            multiple *= 26;
        }
        return res;
    }

    public static void main(String[] args) {
        $171_ExcelSheetColumnNumber instance = new $171_ExcelSheetColumnNumber();
        int res = instance.titleToNumber("FXSHRXW");
        System.out.println(res);
    }
}
