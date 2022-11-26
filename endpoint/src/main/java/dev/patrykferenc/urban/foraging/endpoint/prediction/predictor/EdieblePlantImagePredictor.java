package dev.patrykferenc.urban.foraging.endpoint.prediction.predictor;

import dev.patrykferenc.urban.foraging.endpoint.prediction.EdiblePlantResponseDTO;
import dev.patrykferenc.urban.foraging.endpoint.prediction.PredictionImage;

public interface EdieblePlantImagePredictor {

    EdiblePlantResponseDTO predictEdieblePlantFromImage(PredictionImage image);
}
