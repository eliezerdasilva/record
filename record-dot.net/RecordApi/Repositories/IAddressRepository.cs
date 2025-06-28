using RecordApi.Models;
using System.Collections.Generic;
using System.Threading.Tasks;
using YourNamespace.Models;

namespace RecordApi.Repositories
{
    public interface IAddressRepository
    {
        Task<List<Address>> GetAllAsync();
        Task<Address?> GetByIdAsync(long id);
        Task AddAsync(Address address);
        Task UpdateAsync(Address address);
        Task RemoveAsync(long id);
    }
}