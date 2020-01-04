import Logging

print("Load configuration file")
let configuration = ConfigurationRepository.shared.openConfigurationFile()

if configuration?.description != nil {
    print("Configurations loaded:")
    print(configuration?.description ?? "")
} else {
    LoggerHelper.shared.logError(message:"Unable to load configurations from file")
}

let grammarTree = GrammarRepository.shared.getFullGrammarTree()

print("Load Full Grammar Tree")
print(grammarTree ?? "")

let classifiers = GrammarRepository.shared.getClassifiers()

print("\nClassifiers List")
print(classifiers)

var pool : [String:[Any]] = [:]
pool["classifier"] = classifiers

print(pool)