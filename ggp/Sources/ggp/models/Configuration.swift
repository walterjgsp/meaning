import Foundation

class Configuration : Decodable {
    var crossoverRate: Double = 0.0
    var mutationRate: Double = 0.0
    var population: Int = 0
    var generations: Int = 0
    var selectionSize: Int = 0

    static let shared = Configuration()

    init(){}

    private enum CodingKeys: String, CodingKey {
        case crossoverRate
        case mutationRate
        case population
        case generations
        case selectionSize
    }

    public var description: String { 
        return "* Crossover Rate: \(crossoverRate)\n"
            + "* Mutation Rate: \(mutationRate)\n"
            + "* Population: \(population)\n"
            + "* Generations: \(generations)\n"
            + "* Selection Size: \(selectionSize)\n" 
    }

    func decode(data: Data) throws -> Configuration? {
        do {
            let decoder = JSONDecoder()
            let configuration = try decoder.decode(Configuration.self, from: data)
            return configuration
        } catch let error {
            LoggerHelper.shared.logError(message: error.localizedDescription)
            return nil
        }
    }
}