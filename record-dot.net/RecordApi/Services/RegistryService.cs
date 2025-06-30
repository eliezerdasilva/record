using System.Collections.Generic;
using System.Threading.Tasks;
using RecordApi.Models;
using RecordApi.Repositories;

namespace RecordApi.Services
{
    public class RegistryService
    {
        private readonly IRegistryRepository _repository;

        public RegistryService(IRegistryRepository repository)
        {
            _repository = repository;
        }

        public async Task<List<Registry>> ListarRegistry()
        {
            var registries = await _repository.GetAllAsync();
            return registries.ToList();
        }

        public async Task<Registry?> BuscarPorId(long id)
        {
            return await _repository.GetByIdAsync(id);
        }

        public async Task CriarRegistry(Registry registry)
        {
            await _repository.AddAsync(registry);
        }

        public async Task<bool> AtualizarRegistry(Registry registry)
        {
            var existing = await _repository.GetByIdAsync(registry.Id);
            if (existing == null)
            {
                return false;
            }

            // Atualizar manualmente os campos (opcional)
            existing.Data = registry.Data;
            existing.Value = registry.Value;
            existing.Paid = registry.Paid;
            existing.CollectionPoint = registry.CollectionPoint;
            existing.DeliveryLocation = registry.DeliveryLocation;
            existing.CustomerId = registry.CustomerId;

            await _repository.UpdateAsync(existing);
            return true;
        }

        public async Task<bool> RemoverRegistry(long id)
        {
            var existing = await _repository.GetByIdAsync(id);
            if (existing == null)
            {
                return false;
            }

            await _repository.RemoveAsync(existing);
            return true;
        }
    }
}
