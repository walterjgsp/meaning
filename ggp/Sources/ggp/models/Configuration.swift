import Foundation

class Configuration : Decodable {
    var crossover_rate: Double = 0.0
    var mutation_rate: Double = 0.0
    var population: Int = 0

    static let shared = Configuration()

    init(){}

    private enum CodingKeys: String, CodingKey {
        case crossover_rate
        case mutation_rate
        case population
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