import Foundation

class ConfigurationRepository{

    static let shared = ConfigurationRepository()

    init(){}
    
    func openConfigurationFile() -> Configuration? {

        let fileName = "config"
        let path = FileManager.default.currentDirectoryPath+"/Assets"
        let dir = try? URL.init(fileURLWithPath: path)

        if let fileURL = dir?.appendingPathComponent(fileName).appendingPathExtension("json") {
            do {
                let content = try Data(contentsOf: fileURL)
                let configuration = try Configuration.shared.decode(data: content)
                return configuration
            } catch {
                LoggerHelper.shared.logError(message:"Failed reading from URL: \(fileURL), Error: \(error.localizedDescription)")
            }
        }
        
        return nil
    }
}