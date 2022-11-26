package dev.patrykferenc.urban.foraging.endpoint.prediction.predictor;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
class CustomVisionProjectConfiguration {

    static final String PREDICTION_KEY = System.getenv("customVisionPredictionKey");
    static final String PREDICTION_ENDPOINT = System.getenv("customVisionPredictionEndpoint");
    static final UUID PROJECT_ID = UUID.fromString(System.getenv("customVisionProjectId"));
    static final String PUBLISHED_NAME = System.getenv("customVisionPublishedName");

}
