package dev.patrykferenc.urban.foraging.endpoint;

import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.HttpMethod;
import com.microsoft.azure.functions.HttpRequestMessage;
import com.microsoft.azure.functions.HttpResponseMessage;
import com.microsoft.azure.functions.HttpStatus;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import dev.patrykferenc.urban.foraging.endpoint.prediction.predictor.EdiblePlantPredictorFactory;
import dev.patrykferenc.urban.foraging.endpoint.prediction.PredictionImage;

import java.util.Optional;

@SuppressWarnings("unused")
public class UrbanForagingEndpointFunction {

    @FunctionName("predict")
    public HttpResponseMessage uploadImageAndGetResultsOfCheck(
            @HttpTrigger(
                    name = "req",
                    methods = {HttpMethod.POST},
                    authLevel = AuthorizationLevel.ANONYMOUS,
                    dataType = "binary")
            HttpRequestMessage<Optional<byte[]>> request,
            final ExecutionContext context) {

        context.getLogger().info("Function uploadImageAndGetResultsOfCheck invoked.");

        final var image = request.getBody().orElse(null);
        if (image == null || image.length == 0) {
            return request.createResponseBuilder(HttpStatus.BAD_REQUEST).body("Image is missing").build();
        }


        final var imageToPredict = PredictionImage.fromImageInBytes(image);

        final var predictor = EdiblePlantPredictorFactory.getPredictor();

        final var prediction = predictor.predictEdieblePlantFromImage(imageToPredict);

        return request.createResponseBuilder(HttpStatus.OK).body(prediction).build();
    }
}
