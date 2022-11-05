package lotto.views;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import lotto.LottoProcessor;
import lotto.enums.Rank;
import lotto.numbers.Lotto;

public class OutputView {
    public static void printNumbers(Lotto lotto) {
        for (List<Integer> targetNumbers : lotto.getNumbers()) {
            System.out.print("[");
            printEachNumber(targetNumbers);
            System.out.println("]");
        }
        System.out.println();
    }

    public static void printWinningStatsResult(LottoProcessor lottoProcessor, int purchaseAmount) {
        Map<Rank, Integer> rankingMap = lottoProcessor.getRanks();
        printWinningStats(rankingMap);
        System.out.println("총 수익률은 " + lottoProcessor.getYield(purchaseAmount / LottoProcessor.PRICE)+ "입니다.");
    }

    public static void printWinningStats(Map<Rank, Integer> rankingMap) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        Arrays.stream(Rank.values()).forEach(rank -> {
            int count = rankingMap.getOrDefault(rank,0);
            System.out.println(rank.getCountsOfSameNumbers() + "개 일치 (" + rank.getRewards() + ")원-" + count + "개");
        });
    }

    private static void printEachNumber(List<Integer> targetNumbers) {
        for (int j = 0; j < targetNumbers.size(); j++) {
            System.out.print(targetNumbers.get(j));
            printComma(j, targetNumbers.size() - 1);
        }
    }

    private static void printComma(int index, int endIndex) {
        if (index < endIndex) {
            System.out.print(", ");
        }
    }
}
