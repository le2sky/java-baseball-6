package baseball.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BallsTest {

    @DisplayName("공들(balls)을 생성할 수 있다.")
    @Test
    void create() {
        Balls balls = Balls.from(List.of(1, 2, 3));
        Balls otherBalls = Balls.from(List.of(1, 2, 3));

        assertThat(balls).isEqualTo(otherBalls);
    }

    @DisplayName("알 수 없는 숫자 목록(null)으로 생성할 수 없다.")
    @Test
    void createWithNull() {
        assertThatThrownBy(() -> Balls.from(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("알 수 없는 숫자 목록(null)으로 객체를 생성할 수 없습니다.");
    }

    @DisplayName("알 수 없는 숫자(null)가 포함되어 있는 목록으로 생성할 수 없다.")
    @Test
    void createWithNullIncludedList() {
        List<Integer> nullIncludedList = new ArrayList<>();
        nullIncludedList.add(1);
        nullIncludedList.add(null);
        nullIncludedList.add(3);

        assertThatThrownBy(() -> Balls.from(nullIncludedList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("알 수 없는 숫자(null)가 포함되어 있는 목록으로 객체를 생성할 수 없습니다.");
    }

    @DisplayName("중복된 숫자가 포함되어 있는 목록으로 생성할 수 없다.")
    @Test
    void createWithDuplicateNumbers() {
        assertThatThrownBy(() -> Balls.from(List.of(1, 1, 3)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 숫자는 허용되지 않습니다.");
    }

    @DisplayName("공은 한 라운드에 3개만 생성할 수 있다.")
    @Test
    void createWithOverSizeNumbers() {
        assertThatThrownBy(() -> Balls.from(List.of(1, 2, 3, 4)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("3개의 숫자를 선택해주세요.");
    }
}
