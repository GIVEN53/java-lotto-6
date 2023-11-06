package lotto.domain;

import static lotto.enums.ErrorMassage.INVALID_AMOUNT_UNIT;
import static lotto.enums.ErrorMassage.NOT_ENOUGH_AMOUNT;
import static lotto.enums.LottoConfig.LOTTO_PRICE;

public record Amount(int amount) {
    public Amount {
        validateLottoPrice(amount);
        validateAmountUnit(amount);
    }

    private void validateLottoPrice(final int amount) {
        if (amount < LOTTO_PRICE.getValue()) {
            throw new IllegalArgumentException(NOT_ENOUGH_AMOUNT.getMassage());
        }
    }

    private void validateAmountUnit(final int amount) {
        if (amount % LOTTO_PRICE.getValue() != 0) {
            throw new IllegalArgumentException(INVALID_AMOUNT_UNIT.getMassage());
        }
    }

    public int getLottoQuantity() {
        return amount / LOTTO_PRICE.getValue();
    }
}
