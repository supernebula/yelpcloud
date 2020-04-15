//package clone;
//
//import cn.hutool.core.convert.Convert;
//import com.google.common.primitives.Bytes;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.stream.Collectors;
//
///**
// * @version 1.0
// * @Author zhoukun
// * @Date 2020/1/3 11:02
// **/
//public class TEAHelper {
//    private static int[] KEY = new int[]{
//            0x5A48,
//            0x4A4B5843, 0x090C0608
//    };
//    public static void main(String[] args) {
//        String deviceNumber = "100001";
//        Integer deviceWay = 10;
//        Integer time = 345;
//        Integer codeId = 100;
//        byte[] ba = deviceNumber.getBytes();
//        String key11 = "";
//        String key2 = "";
//        for (int i = ba.length- 1; i >= 0; i--)
//        {
//            if (i < 4)
//            {
//                key2 += Integer.toHexString(ba[i]);
//            }
//            else
//            {
//                key11 += Integer.toHexString(ba[i]);
//            }
//        }
//
//        List<Integer> keyList = Arrays.stream(KEY).boxed().collect(Collectors.toList());
//        String zzr = Integer.toHexString(Integer.valueOf(keyList.get(0).toString()));
//        keyList.set(0,Convert.toInt("0x" + zzr + key11,16));
//        int item0 = Convert.toInt("0x" + key2, 16);
//        keyList.add(0, item0);
//        int[] result = keyList.stream().mapToInt(Integer::valueOf).toArray();
//        List<Byte> list = new ArrayList<Byte>();
//        byte[] deviceWaybyte = toLH(deviceWay);
//        list.add(deviceWaybyte[0]);
//
//        byte[] timeByte = toLH(time);
//        list.add(timeByte[1]);
//        list.add(timeByte[0]);
//
//        byte[] codeByte = toLH(codeId);
//        list.add(codeByte[3]);
//        list.add(codeByte[2]);
//        list.add(codeByte[1]);
//        list.add(codeByte[0]);
//
//        list.add(toLH(0)[0]);
//
//        byte[] tempEncrpt = encrypt(Bytes.toArray(list),0,result,32);
////        for(int i=0;i<tempEncrpt.length;i++){
////            System.out.println(tempEncrpt[i]);
////        }
//        String str1 = "";
//        for(int i=0;i<4;i++){
//            str1 += Integer.toHexString(tempEncrpt[i]);
//        }
//        System.out.println(str1);
////        int z =  Convert.toInt("0x" + str1, 16);
////        System.out.println(z);
////        //ar z1 = Convert.ToString(z);
////        String zz = Convert.toStr(z, String.valueOf(10));
////        System.out.println(zz);
////        String code = zz.substring(zz.length() - 5, 5);
////        System.out.println(code);
//    }
//
//    /**
//     * int 转 byte[]   低字节在前（低字节序）
//     * @param n
//     * @return
//     */
//    public static byte[] toLH(int n) {
//        byte[] b = new byte[4];
//        b[0] = (byte) (n & 0xff);
//        b[1] = (byte) (n >> 8 & 0xff);
//        b[2] = (byte) (n >> 16 & 0xff);
//        b[3] = (byte) (n >> 24 & 0xff);
//        return b;
//    }
//
//
//    //TEA加密
//    private static byte[] encrypt(byte[] content, int offset, int[] key, int times)
//    {
//        //times为加密轮数
//        long[] tempInt = byteToInt(content, offset);  //将加密数据分为两部分
////        for(int i=0;i<tempInt.length;i++){
////            System.out.println(tempInt[i]);
////        }
//        long left = tempInt[0], right = tempInt[1];
//        long sum = 0;
//        long delta = 0x9e3779b9; //这是算法标准给的值
//        long a = key[0], b = key[1], c = key[2], d = key[3];
//        while (times-- > 0)
//        {
//            sum += delta;
//            System.out.println("sum:"+sum);
//            left += ((right << 4) + a) ^ (right + sum) ^ ((right >> 5) + b);
//            System.out.println("left:"+left);
//            right += ((left << 4) + c) ^ (left + sum) ^ ((left >> 5) + d);
//            System.out.println("right:"+right);
//        }
//
//        tempInt[0] = left;
//        tempInt[1] = right;
//        //System.out.println(tempInt[0]+"!!!!!!!"+tempInt[1]);
//        return intToByte(tempInt, 0);
//    }
//
//    private static long[] byteToInt(byte[] content, int offset)
//    {
//
//        long[] result = new long[2]; //除以2的n次方 == 右移n位 即 content.length / 4 == content.length >> 2
//        for (int i = 0, j = offset; (j < (offset + 8)) && (j < content.length); i++, j += 4)
//        {
//            result[i] = transform(content[j + 3]) << 24 | transform(content[j + 2]) << 16 | transform(content[j + 1]) << 8 | transform(content[j]);
//        }
//        return result;
//
//    }
//
//    //int[]型数据转成byte[]型数据
//    private static byte[] intToByte(long[] content, int offset)
//    {
//        byte[] result = new byte[content.length << 2];//乘以2的n次方 == 左移n位 即 content.length * 4 == content.length << 2
//        for (int i = 0, j = offset; j < result.length; i++, j += 4)
//        {
//            result[j + 3] = (byte)((content[i] >> 24) & 0xff);
//            result[j + 2] = (byte)((content[i] >> 16) & 0xff);
//            result[j + 1] = (byte)((content[i] >> 8) & 0xff);
//            result[j] = (byte)(content[i] & 0xff);
//        }
//        return result;
//    }
//
//
//    private static int transform(byte temp)
//    {
//        int tempInt = (int)temp;
//        if (tempInt < 0)
//        {
//            tempInt += 256;
//        }
//        return tempInt;
//    }
//}
