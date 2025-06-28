using System.Collections.Generic;
using System.Threading.Tasks;
using Microsoft.EntityFrameworkCore;
using RecordApi.Data;
using RecordApi.Models;

namespace RecordApi.Repositories
{
    public class RegistryRepository : IRegistryRepository
    {
        private readonly AppDbContext _context;

        public RegistryRepository(AppDbContext context)
        {
            _context = context;
        }

        public async Task<List<Registry>> GetAllAsync()
        {
            return await _context.Registries.ToListAsync();
        }


        public async Task<Registry?> GetByIdAsync(long id)
        {
            return await _context.Registries
                                  .Include(r => r.Customer)
                                  .FirstOrDefaultAsync(r => r.Id == id);
        }

        public async Task AddAsync(Registry registry)
        {
            await _context.Registries.AddAsync(registry);
            await _context.SaveChangesAsync();
        }

        public async Task UpdateAsync(Registry registry)
        {
            _context.Registries.Update(registry);
            await _context.SaveChangesAsync();
        }


        public async Task RemoveAsync(Registry registry)
        {
            _context.Registries.Remove(registry);
            await _context.SaveChangesAsync();
        }

       
    }
}
