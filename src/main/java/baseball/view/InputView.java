package baseball.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    private static final String READ_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String NUMBER_SPLIT_DELIMITER = "";

    public static List<String> readPlayerNumbers() {
        System.out.print(READ_NUMBER_MESSAGE);

        String playerNumbers = Console.readLine().trim();

        return Arrays.stream(playerNumbers.split(NUMBER_SPLIT_DELIMITER))
                .collect(Collectors.toList());
    }
}