using System.Collections.Generic;
using System.Threading.Tasks;
using RecordApi.Models;
using RecordApi.Repositories;

public class CustomerService
{
    private readonly ICustomerRepository _repository;

    public CustomerService(ICustomerRepository repository)
    {
        _repository = repository;
    }

    public Task<List<Customer>> ListAllAsync()
    {
        return _repository.GetAllAsync();
    }

    public Task<Customer?> GetByIdAsync(long id)
    {
        return _repository.GetByIdAsync(id);
    }

   public async Task<Customer?> CreateAsync(Customer customer)
{
    await _repository.AddAsync(customer);
    return customer;
}


    public Task UpdateAsync(Customer customer)
    {
        return _repository.UpdateAsync(customer);
    }

    public Task DeleteAsync(long id)
    {
        return _repository.RemoveAsync(id);
    }
}
