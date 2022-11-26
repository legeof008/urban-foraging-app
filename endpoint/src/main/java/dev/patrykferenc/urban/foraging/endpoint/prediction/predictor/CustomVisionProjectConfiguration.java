package dev.patrykferenc.urban.foraging.endpoint.prediction.predictor;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
class CustomVisionProjectConfiguration {

    // TODO: Move to env
    static final String PREDICTION_KEY = "PREDICTION_KEY";
    static final String PREDICTION_ENDPOINT = "PREDICTION_ENDPOINT";
    static final UUID PROJECT_ID = UUID.randomUUID();
    static final String PUBLISHED_NAME = "PUBLISHED_NAME";

}
