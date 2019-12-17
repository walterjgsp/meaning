import Foundation

class ConfigurationRepository{

    static let shared = ConfigurationRepository()

    init(){}
    
    func openConfigurationFile() -> Configuration? {

        if let content = try? FileReader.shared.readAssetFile(fileName:"config",fileExtension:"json") {
            do{
                let configuration = try Configuration.shared.decode(data: content)
                return configuration
            }catch{
                LoggerHelper.shared.logError(message:"Unable to get configuration, Error: \(error.localizedDescription)")
            }
        }
        
        return nil
    }
}