import Foundation

class Configuration : Decodable {
    var crossover_rate: Double = 0.0
    var mutation_rate: Double = 0.0
    var population: Int = 0
    var generations: Int = 0
    var selection_size: Int = 0

    static let shared = Configuration()

    init(){}

    private enum CodingKeys: String, CodingKey {
        case crossover_rate
        case mutation_rate
        case population
        case generations
        case selection_size
    }

    public var description: String { 
        return "* Crossover Rate: \(crossover_rate)\n"
            + "* Mutation Rate: \(mutation_rate)\n"
            + "* Population: \(population)\n"
            + "* Generations: \(generations)\n"
            + "* Selection Size: \(selection_size)\n" 
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