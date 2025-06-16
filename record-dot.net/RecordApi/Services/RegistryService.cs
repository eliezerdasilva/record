using System.Collections.Generic;
using System.Threading.Tasks;
using RecordApi.Models;
using RecordApi.Repositories;

namespace RecordApi.Services
{
    public class RegistryService
    {
        private readonly IRegistryRepository registryRepository;

        public RegistryService(IRegistryRepository repository)
        {
            registryRepository = repository;
        }

        public async Task<List<Registry>> ListarRegistry()
        {
            var registries = await registryRepository.GetAllAsync();
            return registries.ToList();
        }

        public async Task<Registry> CriarRegistry(Registry registry)
        {
            var registryNew = new Registry
            {
                Description = registry.Description,
                Date = registry.Date

            };

            await registryRepository.AddAsync(registryNew);
            return registryNew;
        }
    }
}
