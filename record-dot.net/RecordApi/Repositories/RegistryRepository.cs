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

        public async Task<IEnumerable<Registry>> GetAllAsync()
        {
            return await _context.Registries.ToListAsync();
        }

        public async Task<Registry> GetByIdAsync(long id)
        {
            return await _context.Registries.FindAsync(id);
        }

        public async Task AddAsync(Registry registry)
        {
            await _context.Registries.AddAsync(registry);
        }

        public void Update(Registry registry)
        {
            _context.Registries.Update(registry);
        }

        public void Remove(Registry registry)
        {
            _context.Registries.Remove(registry);
        }

        public async Task SaveChangesAsync()
        {
            await _context.SaveChangesAsync();
        }
    }
}
