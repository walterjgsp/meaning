import Foundation

struct Classifier: Decodable {
    let name: String
    let importPackage: String
    let parameters: [Parameter]

    enum CodingKeys : String, CodingKey {
        case name
        case importPackage = "import_package"
        case parameters
    }

    struct Parameter: Decodable{
        let name: String
        let value: String
    }
}

struct ClassifierList: Decodable{
    let classifiers : [Classifier]
}

