package dev.patrykferenc.urban.foraging.endpoint.prediction;

import lombok.Value;


@Value(staticConstructor = "fromImageInBytes")
public class PredictionImage {

    byte[] imageAsBytes;
}
