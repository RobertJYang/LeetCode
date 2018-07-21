package Math;

import java.util.Scanner;

public class Q8 {
	public static void main(String[] args) {
		String str1;
		Scanner scanner = new Scanner(System.in);
		for(int i=0;i<5;i++) {
			str1 = scanner.nextLine();
			int res = new Q8().myAtoi(str1);
			System.out.println(res);
			}
	}
    public int myAtoi(String str) {
    	int res = 0;
        int max = 2147483647;
        int min = -2147483648;
        int j=0;
        if(str == null)
            return  0;
        for(;j<str.length();j++) {
        	if(str.charAt(j) == ' ')
        		continue;
        	else 
        		break;
        }
        if(j == str.length())
            return 0;
        str = str.substring(j, str.length());
        if(str.length() == 0)
            return 0;
        else if((str.charAt(0)>'9'||str.charAt(0)<'0')&&(str.charAt(0)!='-'&&str.charAt(0)!='+')) {
            return  0;
        }
        else if(str.charAt(0) == '-' ){
            if(str.length() == 1 || str.charAt(1)>'9'||str.charAt(1)<'0')
                return 0;
            else {
                for(int i=1;i<str.length();i++) {
                    if(str.charAt(i)>'9'||str.charAt(i)<'0')
                        break;
                    else {
                        if((min + str.charAt(i)-'0')/10 <= res)
                            {res = res*10 - str.charAt(i) + '0';
                            }
                        else 
                            return -2147483648;
                    }
                }
            }
        }
        else if(str.charAt(0) == '+') {
            if(str.length() == 1 || str.charAt(1)>'9'||str.charAt(1)<'0')
                return 0;
            else {
                for(int i=1;i<str.length();i++) {
                    if(str.charAt(i)>'9'||str.charAt(i)<'0')
                        break;
                    else {
                    	
                        if((max - str.charAt(i) + '0')/10 >= res)
                            res = res*10 + str.charAt(i) - '0';
                        else 
                            return 2147483647;
                    }
                }
            }
        }
        else {
            for(int i=0;i<str.length();i++) {
                if(str.charAt(i)>'9'||str.charAt(i)<'0')
                    break;
                else {
                    if((max - str.charAt(i) + '0')/10 >= res)
                        {res = res*10 + str.charAt(i) - '0';
                      //  System.out.println(res);
                        }
                    else 
                        return 2147483647;
                }
            }
        }
        return res;

      }
}