package lotto.application;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;
import static lotto.enums.LottoConfig.LOTTO_COUNT;

import java.util.List;
import java.util.stream.IntStream;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;

public class LottoMachine {
    private final NumberGenerator numberGenerator;

    public LottoMachine(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public LottoTicket createLottoTicketByAuto(final int quantity) {
        return IntStream.range(0, quantity)
                .mapToObj(i -> numberGenerator.generateNumbers())
                .map(this::createLotto)
                .collect(collectingAndThen(toList(), LottoTicket::new));
    }

    public Lotto createLotto(final List<Integer> numbers) {
        return numbers.stream()
                .map(this::createLottoNumber)
                .sorted()
                .collect(collectingAndThen(toList(), Lotto::new));
    }

    public LottoNumber createLottoNumber(final int number) {
        return LottoNumber.from(number);
    }
}
