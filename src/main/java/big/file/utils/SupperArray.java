package big.file.utils;


import big.file.unsafe.UnsafeUtil;
import sun.misc.Unsafe;

public class SupperArray {
    private final static int BYTE = 1;
    private final static long ALL_IP_COUNT = 4294967295L;
    private final static long SEGMENT_1 = 858993459L; // 0 -> 858993459L
    private final static long SEGMENT_2 = 1717986918L; // 858993459L -> 1717986918L
    private final static long SEGMENT_3 = 2576980377L; //1717986918L -> 2576980377L
    private final static long SEGMENT_4 = 3435973836L; //3435973836 -> 4294967295L
    private final static long SEGMENT_5 = 4294967295L;


    private final Unsafe UNSAFE = UnsafeUtil.initUnsafe();
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();
    private final Object lock3 = new Object();
    private final Object lock4 = new Object();
    private final Object lock5 = new Object();

    private long counter1;
    private long counter2;
    private long counter3;
    private long counter4;
    private long counter5;


    private long size;
    private long initialAddress;
    private long currentAddress;

    public SupperArray() {
        initialAddress = UNSAFE.allocateMemory(ALL_IP_COUNT * BYTE);
        this.currentAddress = initialAddress;

    }

    public void setUniqueIp1(long ipAsLongAddress) {
        synchronized (lock1) {
            long tempAddress = ipAsLongAddress + currentAddress;
            int aByte = UNSAFE.getByte(tempAddress);
            if (aByte != 1) {
                UNSAFE.putByte(ipAsLongAddress + currentAddress, (byte) 1);
                counter1++;
            }
        }
    }
    public void setUniqueIp2(long ipAsLongAddress) {
        synchronized (lock2) {
            long tempAddress = ipAsLongAddress + currentAddress;
            int aByte = UNSAFE.getByte(tempAddress);
            if (aByte != 1) {
                UNSAFE.putByte(ipAsLongAddress + currentAddress, (byte) 1);
                counter2++;
            }
        }
    }
    public void setUniqueIp3(long ipAsLongAddress) {
        synchronized (lock3) {
            long tempAddress = ipAsLongAddress + currentAddress;
            int aByte = UNSAFE.getByte(tempAddress);
            if (aByte != 1) {
                UNSAFE.putByte(ipAsLongAddress + currentAddress, (byte) 1);
                counter3++;
            }
        }
    }
    public void setUniqueIp4(long ipAsLongAddress) {
        synchronized (lock4) {
            long tempAddress = ipAsLongAddress + currentAddress;
            int aByte = UNSAFE.getByte(tempAddress);
            if (aByte != 1) {
                UNSAFE.putByte(ipAsLongAddress + currentAddress, (byte) 1);
                counter4++;
            }
        }
    }
    public void setUniqueIp5(long ipAsLongAddress) {
        synchronized (lock5) {
            long tempAddress = ipAsLongAddress + currentAddress;
            int aByte = UNSAFE.getByte(tempAddress);
            if (aByte != 1) {
                UNSAFE.putByte(ipAsLongAddress + currentAddress, (byte) 1);
                counter5++;
            }
        }
    }

    private void freeMemory() {
        UNSAFE.freeMemory(initialAddress);
        System.out.println(STR."Given \{initialAddress} Memory is clean");
    }

    public long getUniqueIpAddresses() {
        long unique =  counter1 + counter2 + counter3 + counter4 + counter5;
        freeMemory();
        return unique;
    }


}
