import Logging

class LoggerHelper {

    static let shared = LoggerHelper()

    let logger = Logger(label: "GGP")

    init(){}

    func logError(message: String) {
        logger.error("\(message)")
    }

    func logInfo( message: String) {
        logger.info("\(message)")
    }

}