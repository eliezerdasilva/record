using RecordApi.Data;
using RecordApi.Repositories;
using RecordApi.Services;
using Microsoft.EntityFrameworkCore;

var builder = WebApplication.CreateBuilder(args);

// Configuração da conexão MySQL
builder.Services.AddDbContext<AppDbContext>(options =>
    options.UseMySql(
        builder.Configuration.GetConnectionString("DefaultConnection"),
        new MySqlServerVersion(new Version(8, 0, 29))
    ));

// Injeção de dependência - Repositories e Services
builder.Services.AddScoped<IRegistryRepository, RegistryRepository>();
builder.Services.AddScoped<ICustomerRepository, CustomerRepository>(); // Não esqueça disso
builder.Services.AddScoped<RegistryService>();
builder.Services.AddScoped<CustomerService>();

// Adiciona controllers e Swagger
builder.Services.AddControllers();
builder.Services.AddEndpointsApiExplorer();

// Configura as URLs da aplicação
builder.WebHost.UseUrls("http://localhost:5287", "https://localhost:7287");

var app = builder.Build();



app.UseHttpsRedirection();
app.UseAuthorization();
app.MapControllers();

app.Run();
