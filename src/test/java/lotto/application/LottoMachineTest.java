package lotto.application;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import org.junit.jupiter.api.Test;

class LottoMachineTest {
    private final LottoMachine lottoMachine = new LottoMachine(new RandomNumberGenerator());

    @Test
    void 로또를_생성한다() {
        // when
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = lottoMachine.createLotto(numbers);

        // then
        assertNotNull(lotto); // TODO
    }

    @Test
    void 보너스_번호를_생성한다() {
        // given
        int bonus = 1;

        // when
        LottoNumber bonusNumber = lottoMachine.createLottoNumber(bonus);

        // then
        assertNotNull(bonusNumber); // TODO
    }

    @Test
    void 로또를_생성하면_오름차순으로_정렬된다() {
        // given
        List<Integer> numbers = List.of(6, 5, 4, 3, 2, 1);

        // when
        Lotto lotto = lottoMachine.createLotto(numbers);

        // then
        assertNotNull(lotto); // TODO
    }
}