package dev.patrykferenc.urban.foraging.endpoint.prediction.predictor;

import com.microsoft.azure.cognitiveservices.vision.customvision.prediction.CustomVisionPredictionClient;
import com.microsoft.azure.cognitiveservices.vision.customvision.prediction.CustomVisionPredictionManager;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class EdiblePlantPredictorFactory {


    public static EdieblePlantImagePredictor getPredictor() {
        final var customVisionClient = getCustomVisionClient();

        return new CustomVisionEdieblePlantPredictor(customVisionClient);
    }

    private static CustomVisionPredictionClient getCustomVisionClient() {
        return CustomVisionPredictionManager
                .authenticate(CustomVisionProjectConfiguration.PREDICTION_KEY)
                .withEndpoint(CustomVisionProjectConfiguration.PREDICTION_ENDPOINT);
    }

}
