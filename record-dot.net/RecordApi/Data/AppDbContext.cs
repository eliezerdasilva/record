using Microsoft.EntityFrameworkCore;
using RecordApi.Models;

namespace RecordApi.Data
{
    public class AppDbContext : DbContext
    {
        public AppDbContext(DbContextOptions<AppDbContext> options)
            : base(options)
        {
        }

        public DbSet<Registry> Registries { get; set; }
    }
}
