#![allow(unused)]
use clap::Parser;
use core::panic;
use std::error::Error;
use reqwest::{blocking::Client, header::CONTENT_TYPE};
use std::fs::File;
use infer;

#[derive(Parser)]
struct CliArgs {
    filepath: std::path::PathBuf,
}
fn send_request_to_endpoint(file: File) -> Result<(), Box<dyn Error>> {
    let client = Client::new();
    let resp = client.post("https://our_endpoint_url").header(CONTENT_TYPE,"application/octet-stream")
    .body(file).send()?;
    println!("{:#?}", resp);
    Ok(())
}

fn check_if_file_is_an_accepted_image_type(filepath: &std::path::PathBuf) -> bool{
    let kind = infer::get_from_path(filepath).expect("file read succesfully").expect("file type unknown");
    if kind.extension().eq("jpg") || kind.extension().eq("png")
    {
        return true;
    } else {
        println!("Wrong image/file type !");
        return false
    }
}

fn main() {
    let command_line_argument = CliArgs::parse();
    if !check_if_file_is_an_accepted_image_type(&command_line_argument.filepath)
    {
        return;
    }
    let image = File::open(&command_line_argument.filepath).unwrap();
    send_request_to_endpoint(image);

}
