package com.sonan.swExpertAcademy.level6.problem1252;

import java.util.Scanner;

class Solution {
    // 1Byte 를 가로 4개의 구역으로 정한다 00 00 00 00
    // 00 : 정상
    // 01 : 손상된부분
    // 11 : 검사완료된 부분

    // 손상된 부분 A
    // 01000000, 00010000, 00000100, 00000001
    private static int[] zeroOne = new int[4];

    // 검사 완료된 부분
    // 11000000, 00110000, 00001100, 00000011
    private static int[] oneOne = new int[4];

    // 11000000 left shift 된 것과 & 연산하여 결과를 얻음.
    private static int checker = 0xc0;

    // 비교될 결과 값들.
    // 00000000, 01000000, 11000000
    private static int none = 0x00;
    private static int notOk = 0x40;
    private static int ok = 0xc0;

    static {
        zeroOne[0] = 0x40;
        zeroOne[1] = 0x10;
        zeroOne[2] = 0x04;
        zeroOne[3] = 0x01;
        oneOne[0] = 0xc0;
        oneOne[1] = 0x30;
        oneOne[2] = 0x0c;
        oneOne[3] = 0x03;
    }


    // score <- f(count, map)
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        byte test = 0x00;
        test |= 0xc0;

        System.out.println(test >> 2);
        System.out.println(byteToBinary(test >> 2));
        System.out.println(byteToBinary(test >> 2));
        for (int t = 1 ; t <= T ; t++) {
            int length = sc.nextInt();
            byte [][] base = new byte[length][length];

        }
    }

    public static String byteToHex(int input) {
        return String.format("%02x ", input&0xff);
    }

    public static String byteToBinary(int input) {
        StringBuilder sb = new StringBuilder();
        int spliter = 0x80;
        for (int i = 0 ; i < 8 ; i++) {
            sb.append((spliter & input) == 0 ? '0' : '1');
            spliter = spliter >>> 1;
        }
        return sb.toString();
    }
}