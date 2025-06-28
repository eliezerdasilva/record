using System.Collections.Generic;
using System.Threading.Tasks;
using RecordApi.Models;

namespace RecordApi.Repositories
{
    public interface IRegistryRepository
    {   
        Task<List<Registry>> GetAllAsync();
        Task<Registry?> GetByIdAsync(long id);
        Task AddAsync(Registry registry);
        Task UpdateAsync(Registry registry);
        Task RemoveAsync(Registry registry);
    }
}
