using RecordApi.Models;
using System.Collections.Generic;
using System.Threading.Tasks;
using YourNamespace.Models;

namespace RecordApi.Repositories
{
    public interface IUserRepository
    {
        Task<List<User>> GetAllAsync();
        Task<User?> GetByIdAsync(long id);
        Task<User?> GetByEmailAsync(string email); // Método adicional para busca por email
        Task AddAsync(User user);
        Task UpdateAsync(User user);
        Task RemoveAsync(long id);
    }
}