using System.Collections.Generic;
using System.Threading.Tasks;
using RecordApi.Models;
using RecordApi.Repositories;
using YourNamespace.Models;

public class AddressService
{
    private readonly IAddressRepository _repository;

    public AddressService(IAddressRepository repository)
    {
        _repository = repository;
    }

    public Task<List<Address>> ListAllAsync()
    {
        return _repository.GetAllAsync();
    }

    public Task<Address?> GetByIdAsync(long id)
    {
        return _repository.GetByIdAsync(id);
    }

    public async Task<Address?> CreateAsync(Address address)
    {
        await _repository.AddAsync(address);
        return address;
    }

    public Task UpdateAsync(Address address)
    {
        return _repository.UpdateAsync(address);
    }

    public Task DeleteAsync(long id)
    {
        return _repository.RemoveAsync(id);
    }
}