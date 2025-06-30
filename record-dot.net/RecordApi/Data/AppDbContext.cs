using Microsoft.EntityFrameworkCore;
using RecordApi.Models;
using YourNamespace.Models;

namespace RecordApi.Data
{
    public class AppDbContext : DbContext
    {
        public AppDbContext(DbContextOptions<AppDbContext> options)
            : base(options)
        {
        }

        public DbSet<Registry> Registries { get; set; }
        public DbSet<Customer> Customers { get; set; }
        public DbSet<Address> Addresses { get; set; }
        public DbSet<User> Users { get; set; }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            base.OnModelCreating(modelBuilder);

 modelBuilder.Entity<User>()
        .HasOne(u => u.Address)
        .WithMany()
        .HasForeignKey("endereco_id") // Nome da coluna FK no banco
        .IsRequired();


            modelBuilder.Entity<User>(entity =>
            {
                // Índices únicos
                entity.HasIndex(u => u.Cpf).IsUnique();
                entity.HasIndex(u => u.Email).IsUnique();

                // Restrições de coluna
                entity.Property(u => u.Name).HasMaxLength(200).IsRequired();
                entity.Property(u => u.Cpf).IsRequired();
                entity.Property(u => u.Email).HasMaxLength(255).IsRequired();
                entity.Property(u => u.DateBirth).IsRequired();
            });


        }
    }
}