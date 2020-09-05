package com.sonan.programmers.kakao.y2020;

/**
 * 자물쇠와 열쇠
 * 문제 설명
 * 고고학자인 튜브는 고대 유적지에서 보물과 유적이 가득할 것으로 추정되는 비밀의 문을 발견하였습니다. 그런데 문을 열려고 살펴보니 특이한 형태의 자물쇠로 잠겨 있었고 문 앞에는 특이한 형태의 열쇠와 함께 자물쇠를 푸는 방법에 대해 다음과 같이 설명해 주는 종이가 발견되었습니다.
 *
 * 잠겨있는 자물쇠는 격자 한 칸의 크기가 1 x 1인 N x N 크기의 정사각 격자 형태이고 특이한 모양의 열쇠는 M x M 크기인 정사각 격자 형태로 되어 있습니다.
 *
 * 자물쇠에는 홈이 파여 있고 열쇠 또한 홈과 돌기 부분이 있습니다. 열쇠는 회전과 이동이 가능하며 열쇠의 돌기 부분을 자물쇠의 홈 부분에 딱 맞게 채우면 자물쇠가 열리게 되는 구조입니다. 자물쇠 영역을 벗어난 부분에 있는 열쇠의 홈과 돌기는 자물쇠를 여는 데 영향을 주지 않지만, 자물쇠 영역 내에서는 열쇠의 돌기 부분과 자물쇠의 홈 부분이 정확히 일치해야 하며 열쇠의 돌기와 자물쇠의 돌기가 만나서는 안됩니다. 또한 자물쇠의 모든 홈을 채워 비어있는 곳이 없어야 자물쇠를 열 수 있습니다.
 *
 * 열쇠를 나타내는 2차원 배열 key와 자물쇠를 나타내는 2차원 배열 lock이 매개변수로 주어질 때, 열쇠로 자물쇠를 열수 있으면 true를, 열 수 없으면 false를 return 하도록 solution 함수를 완성해주세요.
 *
 * 제한사항
 * key는 M x M(3 ≤ M ≤ 20, M은 자연수)크기 2차원 배열입니다.
 * lock은 N x N(3 ≤ N ≤ 20, N은 자연수)크기 2차원 배열입니다.
 * M은 항상 N 이하입니다.
 * key와 lock의 원소는 0 또는 1로 이루어져 있습니다.
 * 0은 홈 부분, 1은 돌기 부분을 나타냅니다.
 * 입출력 예
 * key	lock	result
 * [[0, 0, 0], [1, 0, 0], [0, 1, 1]]	[[1, 1, 1], [1, 1, 0], [1, 0, 1]]	true
 * 입출력 예에 대한 설명
 * 자물쇠.jpg
 *
 * key를 시계 방향으로 90도 회전하고, 오른쪽으로 한 칸, 아래로 한 칸 이동하면 lock의 홈 부분을 정확히 모두 채울 수 있습니다.
 *
 * Created by Jaeseong on 2020/09/05
 * Git Hub : https://github.com/AnJaeSeongS2
 */
public class LockAndKey {
    public boolean solution(int[][] key, int[][] lock) {
        boolean[][] keyB = new boolean[key.length][key.length];
        boolean[][] lockB = new boolean[lock.length][lock.length];
        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key.length; j++) {
                if (key[i][j] == 0) {
                    keyB[i][j] = false;
                } else {
                    keyB[i][j] = true;
                }
            }
        }

        for (int i = 0; i < lock.length; i++) {
            for (int j = 0; j < lock.length; j++) {
                if (lock[i][j] == 0) {
                    lockB[i][j] = false;
                } else {
                    lockB[i][j] = true;
                }
            }
        }

        int m = key.length;
        int n = lock.length;
        for (int kxStart = 0; kxStart < m; kxStart++) {
            for (int kyStart = 0; kyStart < m; kyStart++) {
                //정방향
                for (int lxStart = 0; lxStart < n; lxStart++) {
                    for (int lyStart = 0; lyStart < n; lyStart++) {
                        if (isOpen(keyB, lockB, kxStart, kyStart, lxStart, lyStart, 0) == true) {
                            return true;
                        }
                        if (isOpen(keyB, lockB, kxStart, kyStart, lxStart, lyStart, 1) == true) {
                            return true;
                        }
                        if (isOpen(keyB, lockB, kxStart, kyStart, lxStart, lyStart, 2) == true) {
                            return true;
                        }
                        if (isOpen(keyB, lockB, kxStart, kyStart, lxStart, lyStart, 3) == true) {
                            return true;
                        }
                    }
                }

                //회전 3회
            }
        }
        return false;
    }

    private boolean isOpen(boolean[][] key, boolean[][] lock, int kxStart, int kyStart, int lxStart, int lyStart, int way) {
        for (int lx = 0; lx < lock.length; lx++) {
            for (int ly = 0; ly < lock.length; ly++) {
                int kxNext = -1;
                int kyNext = -1;
                switch (way) {
                    case 0:
                        kxNext = kxStart + (lx - lxStart);
                        kyNext = kyStart + (ly - lyStart);
                        break;
                    case 1:
                        kxNext = kxStart - (ly - lyStart);
                        kyNext = kyStart + (lx - lxStart);
                        break;
                    case 2:
                        kxNext = kxStart - (lx - lxStart);
                        kyNext = kyStart - (ly - lyStart);
                        break;
                    case 3:
                        kxNext = kxStart + (ly - lyStart);
                        kyNext = kyStart - (lx - lxStart);
                        break;
                }
                boolean kNext = false;
                if (kxNext >= 0 && kyNext >= 0 && kxNext < key.length && kyNext < key.length) {
                    kNext = key[kxNext][kyNext];
                }
                if (!lock[lx][ly]^kNext) {
                    return false;
                }
            }
        }
        return true;
    }
}
