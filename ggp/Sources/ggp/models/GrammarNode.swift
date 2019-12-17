import Foundation

struct GrammarNode : Decodable{
    let name : String
    let key: String
    let optional: Bool
    let terminal: Bool
    let children: [GrammarNode]
}