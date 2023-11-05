package lotto.application;

import static lotto.domain.LottoConfig.LOTTO_COUNT;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

public class LottoFactory {
    private final NumberGenerator numberGenerator;

    public LottoFactory(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public Lotto createLottoByAuto() {
        List<Integer> numbers = numberGenerator.generateNumbers(LOTTO_COUNT.getValue());
        return createLotto(numbers);
    }

    public Lotto createLottoByManual(List<Integer> numbers) {
        return createLotto(numbers);
    }

    private Lotto createLotto(List<Integer> numbers) {
        return new Lotto(numbers.stream()
                .map(LottoNumber::from)
                .toList()
        );
    }
}
