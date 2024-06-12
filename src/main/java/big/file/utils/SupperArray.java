package big.file.utils;


import big.file.unsafe.UnsafeUtil;
import sun.misc.Unsafe;

public class SupperArray {
    private final static int BYTE = 1;
    private final static long ALL_IP_COUNT = 4294967295L;


    private final Unsafe UNSAFE = UnsafeUtil.initUnsafe();
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();
    private final Object lock3 = new Object();
    private final Object lock4 = new Object();
    private final Object lock5 = new Object();
    private final Object lock6 = new Object();
    private final Object lock7 = new Object();
    private final Object lock8 = new Object();
    private final Object lock9 = new Object();
    private final Object lock10 = new Object();
    private final Object lock11 = new Object();
    private final Object lock12 = new Object();
    private final Object lock13 = new Object();
    private final Object lock14 = new Object();
    private final Object lock15 = new Object();

    private long counter1;
    private long counter2;
    private long counter3;
    private long counter4;
    private long counter5;
    private long counter6;
    private long counter7;
    private long counter8;
    private long counter9;
    private long counter10;
    private long counter11;
    private long counter12;
    private long counter13;
    private long counter14;
    private long counter15;


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
    public void setUniqueIp6(long ipAsLongAddress) {
        synchronized (lock6) {
            long tempAddress = ipAsLongAddress + currentAddress;
            int aByte = UNSAFE.getByte(tempAddress);
            if (aByte != 1) {
                UNSAFE.putByte(ipAsLongAddress + currentAddress, (byte) 1);
                counter6++;
            }
        }
    }
    public void setUniqueIp7(long ipAsLongAddress) {
        synchronized (lock7) {
            long tempAddress = ipAsLongAddress + currentAddress;
            int aByte = UNSAFE.getByte(tempAddress);
            if (aByte != 1) {
                UNSAFE.putByte(ipAsLongAddress + currentAddress, (byte) 1);
                counter7++;
            }
        }
    }
    public void setUniqueIp8(long ipAsLongAddress) {
        synchronized (lock8) {
            long tempAddress = ipAsLongAddress + currentAddress;
            int aByte = UNSAFE.getByte(tempAddress);
            if (aByte != 1) {
                UNSAFE.putByte(ipAsLongAddress + currentAddress, (byte) 1);
                counter8++;
            }
        }
    }
    public void setUniqueIp9(long ipAsLongAddress) {
        synchronized (lock9){
            long tempAddress = ipAsLongAddress + currentAddress;
            int aByte = UNSAFE.getByte(tempAddress);
            if (aByte != 1) {
                UNSAFE.putByte(ipAsLongAddress + currentAddress, (byte) 1);
                counter9++;
            }
        }
    }
    public void setUniqueIp10(long ipAsLongAddress) {
        synchronized (lock10) {
            long tempAddress = ipAsLongAddress + currentAddress;
            int aByte = UNSAFE.getByte(tempAddress);
            if (aByte != 1) {
                UNSAFE.putByte(ipAsLongAddress + currentAddress, (byte) 1);
                counter10++;
            }
        }
    }

    public void setUniqueIp11(long ipAsLongAddress) {
        synchronized (lock11) {
            long tempAddress = ipAsLongAddress + currentAddress;
            int aByte = UNSAFE.getByte(tempAddress);
            if (aByte != 1) {
                UNSAFE.putByte(ipAsLongAddress + currentAddress, (byte) 1);
                counter11++;
            }
        }
    }
    public void setUniqueIp12(long ipAsLongAddress) {
        synchronized (lock12) {
            long tempAddress = ipAsLongAddress + currentAddress;
            int aByte = UNSAFE.getByte(tempAddress);
            if (aByte != 1) {
                UNSAFE.putByte(ipAsLongAddress + currentAddress, (byte) 1);
                counter12++;
            }
        }
    }
    public void setUniqueIp13(long ipAsLongAddress) {
        synchronized (lock13) {
            long tempAddress = ipAsLongAddress + currentAddress;
            int aByte = UNSAFE.getByte(tempAddress);
            if (aByte != 1) {
                UNSAFE.putByte(ipAsLongAddress + currentAddress, (byte) 1);
                counter13++;
            }
        }
    }
    public void setUniqueIp14(long ipAsLongAddress) {
        synchronized (lock14) {
            long tempAddress = ipAsLongAddress + currentAddress;
            int aByte = UNSAFE.getByte(tempAddress);
            if (aByte != 1) {
                UNSAFE.putByte(ipAsLongAddress + currentAddress, (byte) 1);
                counter14++;
            }
        }
    }
    public void setUniqueIp15(long ipAsLongAddress) {
        synchronized (lock15) {
            long tempAddress = ipAsLongAddress + currentAddress;
            int aByte = UNSAFE.getByte(tempAddress);
            if (aByte != 1) {
                UNSAFE.putByte(ipAsLongAddress + currentAddress, (byte) 1);
                counter15++;
            }
        }
    }


    private void freeMemory() {
        UNSAFE.freeMemory(initialAddress);
        System.out.println(STR."Given\{initialAddress} Memory is clean");
    }

    public long getUniqueIpAddresses() {
        long unique =  counter1 + counter2 + counter3 + counter4 + counter5 +
                counter6 + counter7 + counter8 + counter9 + counter10 +
                counter11 + counter12 + counter13 + counter14 + counter15;
        freeMemory();
        return unique;
    }


}
