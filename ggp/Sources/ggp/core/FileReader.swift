import Foundation

class FileReader{

    static let shared = FileReader()

    init(){}

    func readAssetFile(fileName: String, fileExtension: String) throws -> Data?{
        let path = FileManager.default.currentDirectoryPath+"/Assets"
        let dir = try? URL.init(fileURLWithPath: path)

        if let fileURL = dir?.appendingPathComponent(fileName).appendingPathExtension(fileExtension) {
            do {
                let content = try Data(contentsOf: fileURL)
                return content
            } catch {
                LoggerHelper.shared.logError(message:"Failed reading from URL: \(fileURL), Error: \(error.localizedDescription)")
            }
        }
        
        return nil
    }
}