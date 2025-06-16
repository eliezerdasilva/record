using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using RecordApi.Models;
namespace RecordApi.Repositories
{
    public interface IRegistryRepository
    {   
         Task<IEnumerable<Registry>> GetAllAsync();
        Task<Registry> GetByIdAsync(long id);
        Task AddAsync(Registry registry);
        void Update(Registry registry);
        void Remove(Registry registry);
        Task SaveChangesAsync();
        
    }
}