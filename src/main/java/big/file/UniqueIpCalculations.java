package big.file;


import big.file.unsafe.UnsafeUtil;
import big.file.utils.SupperArray;
import sun.misc.Unsafe;

import javax.naming.InsufficientResourcesException;
import java.io.IOException;
import java.lang.foreign.Arena;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;


public class UniqueIpCalculations {


    private static final String FILE = "/home/garik/Downloads/ip_addresses";
    private static final Unsafe UNSAFE = UnsafeUtil.initUnsafe();
    private static final int PROCESSORS = Runtime.getRuntime().availableProcessors();
    private static final long POSSIBLE_IP_ADDRESS_COUNT = 4294967295L;

    private static final int ENTRY_LENGTH = (Unsafe.ARRAY_BYTE_BASE_OFFSET);
    private static final int ENTRY_NAME = ENTRY_LENGTH;

    private final static long SEGMENT_1 = 286331153L;
    private final static long SEGMENT_2 = 572662306L;
    private final static long SEGMENT_3 = 858993459L;
    private final static long SEGMENT_4 = 1145324612L;
    private final static long SEGMENT_5 = 1431655765L;
    private final static long SEGMENT_6 = 1717986918L;
    private final static long SEGMENT_7 = 2004318071L;
    private final static long SEGMENT_8 = 2290649224L;
    private final static long SEGMENT_9 = 2576980377L;
    private final static long SEGMENT_10 = 2863311530L;
    private final static long SEGMENT_11 = 3149642683L;
    private final static long SEGMENT_12 = 3435973836L;
    private final static long SEGMENT_13 = 3722304989L;
    private final static long SEGMENT_14 = 4008636142L;
    private final static long SEGMENT_15 = 4294967295L;

    // Idea of thomaswue, don't wait for slow unmap:
    private static void spawnWorker() throws IOException {
        ProcessHandle.Info info = ProcessHandle.current().info();
        ArrayList<String> workerCommand = new ArrayList<>();
        info.command().ifPresent(workerCommand::add);
        info.arguments().ifPresent(args -> workerCommand.addAll(Arrays.asList(args)));
        workerCommand.add("--worker");
        new ProcessBuilder()
                .command(workerCommand)
                .inheritIO()
                .redirectOutput(ProcessBuilder.Redirect.PIPE)
                .start()
                .getInputStream()
                .transferTo(System.out);
    }

    public static void main(String[] args) throws IOException, InsufficientResourcesException, InterruptedException {

        if (PROCESSORS < 15) {
            throw new InsufficientResourcesException("Available Processors must be at lease 15 for better calculation. In case, change the if condition!");
        }

        if (args.length == 0 || !("--worker".equals(args[0]))) {
            spawnWorker();
            return;
        }

        final FileChannel fileChannel = FileChannel.open(Path.of(FILE), StandardOpenOption.READ);
        final long fileSize = fileChannel.size();
        final long segments = (fileSize + PROCESSORS - 1) / PROCESSORS;
        final long mapAddress = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, fileSize, Arena.global()).address();
        final Thread[] parallelThreads = new Thread[PROCESSORS - 1];
        final SupperArray supperArray = new SupperArray();
        long lastAddress = mapAddress;
        final long endOfFile = mapAddress + fileSize;
        long begin = System.currentTimeMillis();
        for (int i = 0; i < PROCESSORS - 1; i++) {
            final long fromAddress = lastAddress;
            long toAddress = Math.min(endOfFile, fromAddress + segments);
            long finalToAddress = toAddress;
            final Thread thread = new Thread(() -> {
                try {
                    processMemory(fromAddress, finalToAddress, fromAddress == mapAddress, supperArray);
                } catch (UnknownHostException e) {
                    throw new RuntimeException(e);
                }
            });

            thread.start();
            parallelThreads[i] = thread;
            lastAddress = toAddress + 1;
        }

        processMemory(lastAddress, mapAddress + fileSize, false, supperArray);

        for (Thread thread : parallelThreads) {
            thread.join();
        }
        long end = System.currentTimeMillis();
        System.out.println(STR."ms=\{end - begin}");
        System.out.println(STR."Total Unique Addresses = \{supperArray.getUniqueIpAddresses()}");
    }


    public static void processMemory(final long startAddress, final long endAddress, boolean isFileStart, SupperArray supperArray) throws UnknownHostException {
        byte[] entry;
        final Reader reader = new Reader(startAddress, endAddress, isFileStart);
        while (reader.hasNext()) {
            reader.processStart();

            if (!reader.readNext()) {
                entry = new byte[16];
                byte[] ipAddress = combineIpAddress(entry, reader.readBuffer1, reader.readBuffer2);
                String ipAddressStr = new String(ipAddress, StandardCharsets.UTF_8).trim();
                InetAddress inetAddress = InetAddress.getByName(ipAddressStr);
                byte[] bytesss = inetAddress.getAddress();
                long ipAsLongAsAddress = ipToLong(bytesss);
                if (ipAsLongAsAddress <= SEGMENT_1) {
                    supperArray.setUniqueIp1(ipAsLongAsAddress);
                } else if (ipAsLongAsAddress <= SEGMENT_2) {
                    supperArray.setUniqueIp2(ipAsLongAsAddress);
                } else if (ipAsLongAsAddress <= SEGMENT_3) {
                    supperArray.setUniqueIp3(ipAsLongAsAddress);
                } else if (ipAsLongAsAddress <= SEGMENT_4) {
                    supperArray.setUniqueIp4(ipAsLongAsAddress);
                } else if (ipAsLongAsAddress <= SEGMENT_5) {
                    supperArray.setUniqueIp5(ipAsLongAsAddress);
                } else if (ipAsLongAsAddress <= SEGMENT_6) {
                    supperArray.setUniqueIp6(ipAsLongAsAddress);
                } else if (ipAsLongAsAddress <= SEGMENT_7) {
                    supperArray.setUniqueIp7(ipAsLongAsAddress);
                } else if (ipAsLongAsAddress <= SEGMENT_8) {
                    supperArray.setUniqueIp8(ipAsLongAsAddress);
                } else if (ipAsLongAsAddress <= SEGMENT_9) {
                    supperArray.setUniqueIp9(ipAsLongAsAddress);
                } else if (ipAsLongAsAddress <= SEGMENT_10) {
                    supperArray.setUniqueIp10(ipAsLongAsAddress);
                } else if (ipAsLongAsAddress <= SEGMENT_11) {
                    supperArray.setUniqueIp11(ipAsLongAsAddress);
                } else if (ipAsLongAsAddress <= SEGMENT_12) {
                    supperArray.setUniqueIp12(ipAsLongAsAddress);
                } else if (ipAsLongAsAddress <= SEGMENT_13) {
                    supperArray.setUniqueIp13(ipAsLongAsAddress);
                } else if (ipAsLongAsAddress <= SEGMENT_14) {
                    supperArray.setUniqueIp14(ipAsLongAsAddress);
                } else if (ipAsLongAsAddress <= SEGMENT_15) {
                    supperArray.setUniqueIp15(ipAsLongAsAddress);
                }
            }
        }
    }


    public static long ipToLong(byte[] ipAddress) {
        long result = 0;
        for (byte b : ipAddress) {
            result = (result << 8) | (b & 0xFF);
        }
        return result;
    }


    private static byte[] combineIpAddress(byte[] entry, final long readBuffer1, final long readBuffer2) {
        UNSAFE.putLong(entry, ENTRY_NAME, readBuffer1);
        UNSAFE.putLong(entry, ENTRY_NAME + 8, readBuffer2);
        return entry;
    }

    private static class Reader {
        private long ptr;
        private long endAddress;
        private long readBuffer1;
        private long readBuffer2;

        private long hash;
        private long entryStart;

        public int position1;
        public int position2;

        private static final long BACKSLASH_MASK = 0XA0A0A0A0A0A0A0AL; // backslash in hex


        Reader(final long startAddress, final long endAddress, final boolean isFileStart) {
            this.ptr = startAddress;
            this.endAddress = endAddress;

            if (!isFileStart) {
                ptr--;
                while (ptr < endAddress) {
                    if (UNSAFE.getByte(ptr++) == '\n') {
                        break;
                    }
                }
            }
        }

        private boolean hasNext() {
            return (ptr < endAddress);
        }

        private void processStart() {
            hash = 0;
            entryStart = ptr;
        }

        private boolean readNext() {
            long lastRead = UNSAFE.getLong(ptr);

            long comparisonResult1 = (lastRead ^ BACKSLASH_MASK);
            long highBitMask1 = (comparisonResult1 - 0x0101010101010101L) & (~comparisonResult1 & 0x8080808080808080L);
            boolean noContent1 = highBitMask1 == 0;
            long mask1 = noContent1 ? 0 : -(highBitMask1 >>> 7);
            position1 = noContent1 ? 0 : 1 + (Long.numberOfTrailingZeros(highBitMask1) >> 3);

            readBuffer1 = lastRead & ~mask1;
            hash ^= readBuffer1;

            int delimiter1 = position1 == 0 ? 0 : position1;

            if (delimiter1 != 0) {
                hash ^= hash >> 32;
                readBuffer2 = 0;
                ptr += delimiter1;
                return false;
            }
            lastRead = UNSAFE.getLong(ptr + 8);

            // Repeat for long2
            long comparisonResult2 = (lastRead ^ BACKSLASH_MASK);
            long highBitMask2 = (comparisonResult2 - 0x0101010101010101L) & (~comparisonResult2 & 0x8080808080808080L);
            boolean noContent2 = highBitMask2 == 0;
            long mask2 = noContent2 ? 0 : -(highBitMask2 >>> 7);
            position2 = noContent2 ? 0 : 1 + (Long.numberOfTrailingZeros(highBitMask2) >> 3);


            readBuffer2 = lastRead & ~mask2;
            hash ^= readBuffer2;

            int delimiter2 = position2 == 0 ? 0 : position2 + 8;

            hash ^= hash >> 32;

            if (delimiter2 != 0) {
                ptr += delimiter2;
                return false;
            }
            ptr += 16;
            return false;
        }

    }
}
