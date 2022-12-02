package BitManipulation;

public class Intermediate {
    // checking ith bit
    public static int getIthBit(int n, int i){
        System.out.println((n>>i)&1);
        return (n>>i)&1;
    }
    


    // set ith bit 
    public static int setIthBit(int n, int i){
        System.out.println((n | (1<<i)));
        return (n | (1<<i));
    }




    // clear ith bit 
    public static int clearIthBit(int n, int i){
        System.out.println(n&(~(1<<i)));
        return n&(~(1<<i));
    }


    // update ith bit 
    public static int updateIthBit(int n, int i, int newBit){
        // if(i==0){
        //     clearIthBit(n, i);
        // }else{
        //     setIthBit(n, i);
        // }

        n = clearIthBit(n, i);
        newBit = newBit<<i;
        
        System.out.println(n | newBit);
        return n | newBit;
    }



    // clear last i bits 
    public static int clearLastBits(int n, int i){
        // n = n>>i;
        // System.out.println(n<<i);
        // return n<<i;

        System.out.println(n&(-1<<i));
        return n&(-1<<i);
    }


    // clear range of bits 
    public static int clearRangeBits(int n, int i, int j){
        i = ~(-1<<i);
        j = -1<<j+1;
        int m = i | j;
        System.out.println(n&m);
        return n&m;
    }


    // check if the number is a power of two 
    // if you take the binary and of a number which is a power of 2 with the number one less then that number
    // then it will give you 0
    public static Boolean powOfTwo(int n){
        return ((n & (n-1))==0);
    }



    // number of set bits 
    public static int numSetbits(int n){
        int count = 0;
        while(n>0){
            int m = n & 1;
            if(m!=0){
                count++;
            }
            n = n>>1;
        }
        return count;
    }


    public static void main(String arg[]){
        // check ith bit 
        getIthBit(6,1);

        // set ith Bit
        setIthBit(5, 1);

        // clear ith Bit 
        clearIthBit(7,1);

        // update ith bit;
        updateIthBit(5,1,1);

        // clear last i bits;
        clearLastBits(5,2);


        // clear range of bits 
        clearRangeBits(10,2,4);



        // check if the number is a power of 2
        System.out.println(powOfTwo(63));


        // number of set bits in a number;
        System.out.println(numSetbits(7));
    }
}
