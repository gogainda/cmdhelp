# cmdhelp - A Simple ChatGPT Command Line Helper

cmdhelp is a lightweight utility that allows you to ask simple command-line questions to ChatGPT. 
This tool aims to make the installation and usage as straightforward as possible, 
providing you with immediate answers to your command-line queries without any external dependencies once built.

## Features

- Ask common command-line questions
- Easy setup and usage

## Installation

### Download the executables
_Only for Apple M1_
Go the the latest run action [here](https://github.com/gogainda/cmdhelp/actions/runs) and download the zip file from the `Artifacts` section

## Build

### Build the Jar

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/cmdhelp.git
   cd cmdhelp
   ```

2. Build the project:
   ```bash
   mvn clean install
   ```

3. Run the jar file with your OpenAI API key:
   ```bash
   API_KEY="_your_api_key_" java -jar target/cmdhelp-1.0-SNAPSHOT-jar-with-dependencies.jar "your question here"
   ```

### Build Native Executables

#### Using Local Setup

Follow the instruction from official GraalVM [website](https://www.graalvm.org/latest/reference-manual/native-image/)

#### Using GitHub Actions

1. Fork the project
2. Enable GitHub Actions
3. Add required OS to the build matrix
4. Run the job
5. Once the build completes, download the executable from the GitHub Actions artifacts.

## Usage

After building the project or obtaining a native executable, you can use cmdhelp to ask command-line questions:

```bash
API_KEY="_your_api_key_" ./cmdhelp "How to find the biggest file in a directory?"
```

## Contributing

Contributions are welcome! Please open an issue or submit a pull request for any improvements or bug fixes.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Acknowledgements

Special thanks to the GraalVM team for providing the tools needed to create native images.
