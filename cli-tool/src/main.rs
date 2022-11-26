#![allow(unused)]
use clap::Parser;
use core::panic;
use infer;
use reqwest::{blocking::Client, header::CONTENT_TYPE, Url};
use std::error::Error;
use std::fs::File;

#[derive(Parser)]
struct CliArgs {
    filepath: std::path::PathBuf,
}
fn send_request_to_endpoint(endpoint_url: Url, file: File) -> Result<String, Box<dyn Error>> {
    let http_client = Client::new();
    let http_response = http_client
        .post(endpoint_url)
        .header(CONTENT_TYPE, "application/octet-stream")
        .body(file)
        .send()?;
    let textual_response = http_response.text().unwrap();
    Ok((textual_response))
}

fn check_if_file_is_an_accepted_image_type(filepath: &std::path::PathBuf) -> bool {
    let kind = infer::get_from_path(filepath)
        .expect("file read succesfully")
        .expect("file type unknown");
    if kind.extension().eq("jpg") || kind.extension().eq("png") {
        return true;
    } else {
        println!("Wrong image/file type !");
        return false;
    }
}

fn main() {
    let command_line_argument = CliArgs::parse();
    if !check_if_file_is_an_accepted_image_type(&command_line_argument.filepath) {
        return;
    }

    let image = File::open(&command_line_argument.filepath).unwrap();
    let endpoint_url =
        Url::parse("https://urban-foraging-endpoint.azurewebsites.net/api/predict").unwrap();
    let prediction_results = send_request_to_endpoint(endpoint_url, image);

    match prediction_results {
        Ok(result) => print!("Prediction results:\n{}", result),
        Err(error) => panic!("Problem with connection to the endpoint: {:?}", error),
    }
}
