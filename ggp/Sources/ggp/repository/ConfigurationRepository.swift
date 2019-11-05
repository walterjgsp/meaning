class ConfigurationRepository{

    static let shared = ConfigurationRepository()

    init(){}
    
    func openConfigurationFile() -> Configuration{
        //Code Process
        print("Location granted")
        return Configuration()
    }
}