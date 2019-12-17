import Foundation

class GrammarRepository{

    static let shared = GrammarRepository()

    init(){}
    
    func getFullGrammarTree() -> GrammarNode? {
        
        if let content = try? FileReader.shared.readAssetFile(fileName:"grammar",fileExtension:"json") {
            do{
                let decoder = JSONDecoder()
                let grammarTree = try decoder.decode(GrammarNode.self, from: content)
                return grammarTree
            }catch{
                LoggerHelper.shared.logError(message:"Unable to get full grammar tree, Error: \(error.localizedDescription)")
            }
        }
        
        return nil
    }

    func getClassifiers() -> [Classifier] {

        if let content = try? FileReader.shared.readAssetFile(fileName:"classifiers",fileExtension:"json"){
            do{
                let decoder = JSONDecoder()
                let classifierList = try decoder.decode(ClassifierList.self,from: content)
                return classifierList.classifiers
            }catch{
                LoggerHelper.shared.logError(message:"Unable to load the list of classidiers, Error: \(error.localizedDescription)")
            }
        }

        return [Classifier]()
    }
}