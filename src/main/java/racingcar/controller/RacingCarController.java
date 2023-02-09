package racingcar.controller;

import racingcar.controller.response.MovedResultResponse;
import racingcar.domain.Cars;
import racingcar.domain.Lap;
import racingcar.domain.NumberGenerator;

import java.util.Arrays;

import static java.util.stream.Collectors.toUnmodifiableList;

public class RacingCarController {

    private static final String DELIMITER = ",";
    private final NumberGenerator generator;

    public RacingCarController(final NumberGenerator generator) {
        this.generator = generator;
    }

    public Cars createCars(final String carNames) {
        return new Cars(Arrays.stream(carNames.split(DELIMITER))
                .collect(toUnmodifiableList()));
    }

    public Lap confirmTotalLap(final int totalLap) {
        return new Lap(totalLap);
    }

    public MovedResultResponse moveCars(final Cars cars, final Lap lap) {
        cars.move(generator);
        lap.next();
        return new MovedResultResponse(cars);
    }
}
