# Cli urban foraging app tool
This tool was designed to acess an endpoint of urban-foraging-app API through a command line interface.
## Dependencies and setup
Please visit [this webside](https://rustup.rs) and follow the instructions.
After that enter the `/cli-tool` directory and run:
```terminal
cargo run
``` 
In order to build version with debugging enabled:
```terminal
cargo build
```
In order to build version optimized for release:
```terminal
cargo build --release
```
The compiled file should be present at `/cli-tool/target/debug` or `/cli-tool/target/release`