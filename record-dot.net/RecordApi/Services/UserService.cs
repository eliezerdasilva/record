using System.Collections.Generic;
using System.Threading.Tasks;
using RecordApi.Models;
using RecordApi.Repositories;
using YourNamespace.Models;

public class UserService
{
    private readonly IUserRepository _repository;

    public UserService(IUserRepository repository)
    {
        _repository = repository;
    }

    public Task<List<User>> ListAllAsync()
    {
        return _repository.GetAllAsync();
    }

    public Task<User?> GetByIdAsync(long id)
    {
        return _repository.GetByIdAsync(id);
    }

    public Task<User?> GetByEmailAsync(string email)
    {
        return _repository.GetByEmailAsync(email);
    }

    public async Task<User?> CreateAsync(User user)
    {
        await _repository.AddAsync(user);
        return user;
    }

    public Task UpdateAsync(User user)
    {
        return _repository.UpdateAsync(user);
    }

    public Task DeleteAsync(long id)
    {
        return _repository.RemoveAsync(id);
    }
}