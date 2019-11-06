import Foundation

class ConfigurationRepository{

    static let shared = ConfigurationRepository()

    init(){}
    
    func openConfigurationFile() -> Configuration{

        let fileName = "config"
        let path = FileManager.default.currentDirectoryPath+"/Assets"
        let dir = try? URL.init(fileURLWithPath: path)

        if let fileURL = dir?.appendingPathComponent(fileName).appendingPathExtension("json") {
            // Then reading it back from the file
            var inString = ""
            do {
                inString = try String(contentsOf: fileURL)
            } catch {
                LoggerHelper.shared.logError(message:"Failed reading from URL: \(fileURL), Error: \(error.localizedDescription)"
                )
            }

            do {
                print(inString)
                let data = inString.data(using: .utf8)!
                if let jsonArray = try JSONSerialization.jsonObject(with: data, options : .allowFragments) as? [Dictionary<String,Any>]{
                print(jsonArray) // use the json here     
                } else {
                    LoggerHelper.shared.logError(message:"Error when parsing string to json")
                }
            } catch let error as NSError {
                LoggerHelper.shared.logError(message:error.localizedDescription)
            }
        }
        
        return Configuration()
    }
}