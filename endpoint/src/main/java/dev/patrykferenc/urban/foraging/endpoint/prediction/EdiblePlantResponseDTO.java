package dev.patrykferenc.urban.foraging.endpoint.prediction;

import lombok.Builder;
import lombok.Value;


@Value
@Builder
public class EdiblePlantResponseDTO {

    String plantName;
    String description;
    double certaintyPercentage;
}
