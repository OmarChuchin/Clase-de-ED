/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recursion;

/**
 *
 * @author omar
 */
public class Main {
    public static void main(String[] args) {

    }

    public static int factorial(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static int bunnyEars(int bunnies) {
        if (bunnies < 1) {
            return 0;
        }
        return bunnyEars(bunnies - 1) + 2;
    }

    public static int fibonacci(int n) {
        if (n == 1) {
            return 1;
        }
        if (n < 1) {
            return 0;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static int bunnyEars2(int bunnies) {
        if (bunnies < 1) {
            return 0;
        }
        if (bunnies % 2 != 0) {
            return bunnyEars2(bunnies - 1) + 2;
        } else {
            return bunnyEars2(bunnies - 1) + 3;
        }
    }

    public static int triangle(int rows) {
        if (rows < 1) {
            return 0;
        }
        return triangle(rows - 1) + rows;
    }

    public static int sumDigits(int n) {
        if (n < 10) {
            return n;
        }
        return sumDigits(n / 10) + n % 10;
    }

    public static int count7(int n) {
        if (n < 10 && n != 7) {
            return 0;
        } else {
            if (n % 10 == 7) {
                return count7(n / 10) + 1;
            }
        }
        return count7(n / 10);
    }

    public static int count8(int n) {
        if (n < 10) {
            if (n == 8) {
                return 1;
            } else {
                return 0;
            }
        } else if (n % 100 == 88) {
            return count8(n / 10) + 2;
        } else if (n % 10 == 8) {
            return count8(n / 10) + 1;
        } else {
            return count8(n / 10);
        }
    }

    public static int powerN(int base, int n) {
        if (n < 1) {
            return 1;
        }
        return powerN(base, n - 1) * base;
    }

    public static int countX(String str) {
        if (str.length() == 1) {
            if (str.charAt(str.length() - 1) == 'x') {
                return 1;
            } else {
                return 0;
            }
        } else if (str.length() == 0) {
            return 0;
        } else if (str.charAt(str.length() - 1) == 'x') {
            return countX(str.substring(0, str.length() - 1)) + 1;
        } else {
            return countX(str.substring(0, str.length() - 1));
        }
    }

    public static int countHi(String str) {
        if (str.length() <= 1) {
            return 0;
        } else if (str.charAt(0) == 'h') {
            if (str.charAt(1) == 'i') {
                return countHi(str.substring(2, str.length())) + 1;
            } else {
                return countHi(str.substring(2, str.length()));
            }
        } else {
            return countHi(str.substring(1, str.length()));
        }
    }

    public static String changeXY(String str) {
        if (str.length()==0)
            return "";
        else if (str.charAt(0)=='x')
            return "y".concat(changeXY(str.substring(1, str.length())));
        else
            return str.substring(0, 1).concat(changeXY(str.substring(1, str.length())));
    }

    public static String changePi(String str) {
        if (str.length()==0)
            return "";
        else if (str.charAt(0)=='p' && str.length()>1){
            if(str.charAt(1)=='i')
                return "3.14".concat(changePi(str.substring(2, str.length())));
            else
                return str.substring(0, 2).concat(changePi(str.substring(2, str.length())));
        }
        else
            return str.substring(0, 1).concat(changePi(str.substring(1, str.length())));
    }
    
    public static String noX(String str) {
        if (str.length()<1)
            return "";
        else{
            if(str.charAt(0)=='x')
                return "".concat(noX(str.substring(1, str.length())));
            else
                return str.substring(0, 1).concat(noX(str.substring(1, str.length())));
        }
    }

    public static boolean array6(int[] nums, int index) {
        if (nums.length==0 || index>=nums.length)
            return false;
        else if (nums[index]==6)
            return true;
        return array6(nums,index+1);
    }
    
    public static int array11(int[] nums, int index) {
        if(nums.length==0 || index>=nums.length || index<0)
            return 0;
        else if (nums[index]==11)
            return array11(nums,index+1)+1;
        return array11(nums,index+1);
    }
    
    public static boolean array220(int[] nums, int index) {
        if(nums.length<=1 || index+2>nums.length || index<0)
            return false;
        else if (nums[index]*10==nums[index+1])
            return true;
        else
            return array220(nums,index+1);
    }
    
    public static String allStar(String str) {
        if (str.length()<=1)
            return str;
        else
            return str.substring(0, 1).concat("*").concat(allStar(str.substring(1, str.length())));
    }
    
    public static String pairStar(String str) {
        if (str.length()<=1)
            return str;
        else if (str.charAt(0)==str.charAt(1))
            return str.substring(0,1).concat("*").concat(pairStar(str.substring(1, str.length())));
        else
            return str.substring(0, 1).concat(pairStar(str.substring(1,str.length())));
    }
    
    public static String endX(String str) {
        if (str.length()==0)
            return "";
        else if (str.charAt(0)=='x')
            return endX(str.substring(1, str.length())).concat("x");
        else
            return str.substring(0,1).concat(endX(str.substring(1, str.length())));
    }
    
    public static int countPairs(String str) {
        if (str.length()<3)
            return 0;
        else if (str.charAt(0)==str.charAt(2))
            return countPairs(str.substring(1, str.length()))+1;
        else
            return countPairs(str.substring(1, str.length()));
    }
    
    public static int countAbc(String str) {
        if (str.length()<3)
            return 0;
        else if (str.substring(0, 3).equals("abc") || str.substring(0, 3).equals("aba"))
            return countAbc(str.substring(1, str.length()))+1;
        return countAbc(str.substring(1, str.length()));
    }
    
    public static int count11(String str) {
        if(str.length()<2)
            return 0;
        else if (str.substring(0, 2).equals("11"))
            return count11(str.substring(2, str.length()))+1;
        else
            return count11(str.substring(1, str.length()));
    }
    
    public static String stringClean(String str) {
        if (str.length()<=1)
            return str;
        else if (str.charAt(0)==str.charAt(1))
            return stringClean(str.substring(1, str.length()));
        else
            return str.substring(0, 1).concat(stringClean(str.substring(1, str.length())));
    }
    
    public static int countHi2(String str) {
        if (str.length()>=3){
            if (str.charAt(0)=='x' && str.substring(1, 3).equals("hi"))
                return countHi2(str.substring(3, str.length()));
            else if (str.substring(0, 2).equals("hi"))
                return countHi2(str.substring(2, str.length()))+1;
            else
                return countHi2(str.substring(1, str.length()));
        }
        else if (str.length()==2)
            if(str.equals("hi"))
                return 1;
        return 0;
    }
    
    public static String parenBit(String str) {
        if (str.length()==0)
            return str;
        else if (str.charAt(0)=='('){
            int x=1;
            while(str.charAt(x)!=')'){
                x++;
            }
            return str.substring(0,x+1);
        }
        else
            return parenBit(str.substring(1, str.length()));
    }
    
    /*public boolean nestParen(String str) {
        if (str.length()==0)
            return true;
        else{
            if (str.charAt(0)=='(')
                return nestParen(str.substring(1, str.length()));
            else if (str.charAt(0))
        }
    }*/
    
    public static int strCount(String str, String sub) {
        if (str.length()<sub.length())
            return 0;
        else if (str.substring(0, sub.length()).equals(sub))
            return strCount(str.substring(sub.length(),str.length()),sub)+1;
        else
            return strCount(str.substring(1,str.length()),sub);
    }
    
    public static boolean strCopies(String str, String sub, int n) {
        if (n<1 && str.length()<sub.length())
            return true;
        else if(n>0 && str.length()>=sub.length()){
            if(str.substring(0, sub.length()).equals(sub))
                return true && strCopies(str.substring(1, str.length()),sub,n-1);
            else
                return strCopies(str.substring(1, str.length()),sub,n);
        }
        else if (str.length()<sub.length() && n>0)
            return false;
        else if (n<1 && str.length()>=sub.length()){
            if (str.substring(0, sub.length()).equals(sub))
                return false;
            else
                return strCopies(str.substring(1,str.length()),sub,n);
        }
        else 
            return false;
    }
    
    public static int strDist(String str, String sub) {
        if (str.length()<sub.length())
            return 0;
        else if (str.substring(0, sub.length()).equals(sub)){
            int count=sub.length();
            boolean check=false;
            while(check){
                String temp=str.substring(count, str.length());
                if (temp.equals(sub)){
                    check=true;
                    count+=sub.length();}
                else if (temp.length()<sub.length()){
                    count=sub.length();
                    check=true;
                }
                else
                    count++;
            }
            return strDist(str.substring(count, str.length()),sub)+count;
        }
        else 
            return strDist(str.substring(1, str.length()),sub);
    }
    
}
