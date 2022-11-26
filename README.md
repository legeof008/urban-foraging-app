# Urban foraging app
## Description
This app was designed to help recognise if a picture of a plant matches description of a plant tagged by the Custom Vision Azure service.
## Technology stack
Azure services:
 - Azure Custom Viion
 - Azure Virtual Network
 - Azure Function App

Native apps:
- cli tool
## Usage
### Building tool
To build the application please run from the project root:
```terminal
cd cli-tool && \
cargo build --release && \
mv cli-tool/target/release/urban-foraging-clli .
```
### Running the tool
In order to upload image file of a plant you wish recognised use:
```terminal
urban-foraging-cli <path to image file>
```
The expected response should be:
```json
{
	"plantName": "<plant name>",
	"description": "<description>",
	"certaintyPercentage": <percentage>
}
```