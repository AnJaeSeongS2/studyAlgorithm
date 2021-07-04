package com.sonan.programmers.naverwebtoon;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

/**
 * 문제 설명
 * 쿠폰을 사용하면 물건을 살 때 할인을 받을 수 있습니다. 쿠폰이 여러 장 주어졌을 때, 쿠폰을 적절히 사용해 할인을 최대한 많이 받으려고 합니다. 한 제품에는 쿠폰을 하나만 적용할 수 있으며, 사용한 쿠폰은 사라집니다.
 *
 * 주문할 제품의 가격 prices, 쿠폰별 할인율 discounts가 매개변수로 주어집니다. 할인을 최대한 많이 받도록 쿠폰을 적용했을 때 얼마를 내야 하는지 return 하도록 solution 함수를 완성해주세요.
 *
 * 제한 사항
 * prices 배열의 길이는 1 이상 1,000 이하입니다.
 * prices 배열의 원소는 5,000 이상 150,000 이하인 자연수이며, 항상 100으로 나누어 떨어집니다.
 * discounts 배열의 길이는 1 이상 1,000 이하입니다.
 * discounts 배열의 원소는 1 이상 100 이하인 자연수입니다.
 * 입출력 예
 * prices	discounts	result
 * [13000, 88000, 10000]	[30, 20]	82000
 * [32000, 18000, 42500]	[50, 20, 65]	45275
 * 입출력 예 설명
 * 입출력 예 #1
 *
 * 13,000원짜리 제품에 20% 쿠폰을 적용해 10,400원을 결제합니다.
 * 88,000원짜리 제품에 30% 쿠폰을 적용해 61,600원을 결제합니다.
 * 10,000원짜리 제품에는 쿠폰을 적용하지 않습니다.
 *
 * 따라서 82,000원을 내야 합니다.
 *
 * 입출력 예 #2
 *
 * 32,000원짜리 제품에 50% 쿠폰을 적용해 16,000원을 결제합니다.
 * 18,000원짜리 제품에 20% 쿠폰을 적용해 14,400원을 결제합니다.
 * 42,500원짜리 제품에 65% 쿠폰을 적용해 14,875원을 결제합니다.
 *
 * 따라서 45,275원을 내야 합니다.
 * Created by Jaeseong on 2021/07/04
 * Git Hub : https://github.com/AnJaeSeongS2
 */
public class Sol1 {
    public int solution(int[] prices, int[] discounts) {
        TreeSet<Integer> pricesTS = new TreeSet((o1, o2) -> (Integer)o2 - (Integer)o1);
        TreeSet<Integer> discountsTS = new TreeSet((o1, o2) -> (Integer)o2 - (Integer)o1);

        for (int price : prices) {
            pricesTS.add(price);
        }

        for (int discount : discounts) {
            discountsTS.add(discount);
        }
        Iterator<Integer> pricesIter = pricesTS.iterator();
        Iterator<Integer> discountIter = discountsTS.iterator();

        Integer resultPrice = 0;
        while (pricesIter.hasNext()) {
            Integer discountValue = 0;
            if (discountIter.hasNext()) {
                discountValue = discountIter.next();
            }

            resultPrice += (pricesIter.next() / 100) * (100 - discountValue);
        }
        return resultPrice;
    }
}
