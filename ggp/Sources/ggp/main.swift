import Logging

print("Load configuration file")
let configuration = ConfigurationRepository.shared.openConfigurationFile()

if configuration?.description != nil {
    print("Configurations loaded:")
    print(configuration?.description ?? "")
} else {
    LoggerHelper.shared.logError(message:"Unable to load configurations from file")
}