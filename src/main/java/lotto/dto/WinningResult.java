package lotto.dto;

import java.util.Map;
import java.util.function.IntBinaryOperator;
import lotto.domain.Amount;
import lotto.enums.Prize;

public record WinningResult(Map<Prize, Integer> prizes) {
    private static final int ZERO = 0;

    public int countOf(final Prize prize) {
        return prizes.getOrDefault(prize, ZERO);
    }

    public double calculateYield(final Amount amount) {
        return (double) this.totalWinningMoney() / amount.amount() * 100;
    }

    private int totalWinningMoney() {
        IntBinaryOperator multiply = (a, b) -> a * b;
        return prizes.keySet().stream()
                .filter(prize -> prize != Prize.NONE)
                .mapToInt(p -> multiply.applyAsInt(p.getWinningMoney(), prizes.get(p)))
                .sum();
    }
}
