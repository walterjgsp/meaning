import Foundation

struct GrammarNode : Decodable{
    let name : String
    let key: String
    let probability: Float
    let terminal: Bool
    let children: [GrammarNode]
}