package cn.leetcode.string;

class $551_StudentAttendanceRecordI {
    public boolean checkRecord(String s) {
         int count=0;
        for(int i=0;i<s.length();i++)
            if(s.charAt(i)=='A')
                count++;
        return count<2 && !s.contains("LLL");
    }
}
