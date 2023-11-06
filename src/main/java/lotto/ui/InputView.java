package lotto.ui;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.InputValidator;

public class InputView {
    private final InputValidator inputValidator;

    public InputView(final InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public String scanLottoAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        inputValidator.validate(input);
        return input;
    }
}
