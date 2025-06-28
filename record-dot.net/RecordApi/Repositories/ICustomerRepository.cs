using RecordApi.Models;
using System.Collections.Generic;
using System.Threading.Tasks;

namespace RecordApi.Repositories
{
    public interface ICustomerRepository
    {
        Task<List<Customer>> GetAllAsync();
        Task<Customer?> GetByIdAsync(long id);
        Task AddAsync(Customer customer);
        Task UpdateAsync(Customer customer);
        Task RemoveAsync(long id);
    }
}
