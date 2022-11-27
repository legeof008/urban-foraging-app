package dev.patrykferenc.urban.foraging.endpoint.prediction.predictor;

import com.microsoft.azure.cognitiveservices.vision.customvision.prediction.CustomVisionPredictionClient;
import dev.patrykferenc.urban.foraging.endpoint.prediction.EdiblePlantResponseDTO;
import dev.patrykferenc.urban.foraging.endpoint.prediction.PredictionImage;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class CustomVisionEdiblePlantPredictor implements EdieblePlantImagePredictor {

    private final CustomVisionPredictionClient customVisionPredictionClient;


    @Override
    public EdiblePlantResponseDTO predictEdiblePlantFromImage(PredictionImage image) {
        final var imageToPredict = image.getImageAsBytes();

        final var customVisionPredictionResult = customVisionPredictionClient
                .predictions().classifyImage()
                .withProjectId(CustomVisionProjectConfiguration.PROJECT_ID)
                .withPublishedName(CustomVisionProjectConfiguration.PUBLISHED_NAME)
                .withImageData(imageToPredict)
                .execute();


        final var prediction = customVisionPredictionResult.predictions().get(0);

        return EdiblePlantResponseDTO.builder()
                .plantName(prediction.tagName())
                .certaintyPercentage(prediction.probability() * 100)
                .description(getDescriptionBasedOnProbability(prediction.probability()))
                .build();
    }

    private static String getDescriptionBasedOnProbability(double probability) {
        if (probability < 0.5) {
            return "This plant is not edible or there is not enough certainty to make a good prediction.";
        }

        return "This plant is edible";
    }
}
