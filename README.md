# Urban foraging app

## Description and goal
This app was designed to help recognise if a plant is edieble with the help of Azure Cognitive Services and other PasS offerings.
It's purpose is to help discover which wild plants are edible - ideal usage scenario in today's times.

## Usage scenarios

### Typical usage of our solution would be as follows:

1. User takes/downloads an image of a plant they want.
2. User sends it to our API via a client app/mobile app etc. (only CLI client is prepared at the time of writing).
3. Our backend processes the request (binary image), and detects if it's recognized as an edieble plant.
4. Our backend sends a response containing info about the plant - name, certainity etc.
5. User can now take a more informed decision whether to eat the plant or not :)

### The API could be used to:
- power a powerful mobile app
- be a part of a more versatile solution
- be a demo of possible Azure AI usage

## Technology stack

![urban-foraging-diagram drawio](https://user-images.githubusercontent.com/81482531/204142180-56e186f6-0bb3-4099-b540-b0e4d3beb39c.png)

Azure services:
 - Azure Custom Vision
 - Azure Api Management
 - Azure Function App (Java based)

Native apps:
- cli tool (client written in Rust)

## Usage

### Building tool
For more specific information on the building process see the cli-tool/README.md. To build the application please run from the project root:
```terminal
cd cli-tool && \
cargo build --release && \
mv cli-tool/target/release/urban-foraging-clli .
```
### Running the tool
In order to upload image file of a plant you wish recognised use:
```terminal
urban-foraging-cli <path to your plant image file>
```
The expected response should be:
```json
{
	"plantName": "<plant name>",
	"description": "<description>",
	"certaintyPercentage": <percentage>
}
```

## Contributors
- [Maciej Michalski](https://github.com/legeof008)
- [Patryk Ferenc](https://github.com/patrykferenc)
