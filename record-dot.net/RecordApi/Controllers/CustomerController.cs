using Microsoft.AspNetCore.Mvc;
using RecordApi.Models;
using RecordApi.Services;
using System.Collections.Generic;
using System.Threading.Tasks;

namespace RecordApi.Controllers
{
    [ApiController]
    [Route("api/customer")]
    public class CustomerController : ControllerBase
    {
        private readonly CustomerService _customerService;

        public CustomerController(CustomerService customerService)
        {
            _customerService = customerService;
        }

        // GET: api/customer
        [HttpGet]
        public async Task<ActionResult<IEnumerable<Customer>>> GetAll()
        {
            var customers = await _customerService.ListAllAsync();
            return Ok(customers);
        }

        // GET: api/customer/{id}
        [HttpGet("{id}")]
        public async Task<ActionResult<Customer>> GetById(long id)
        {
            var customer = await _customerService.GetByIdAsync(id);
            if (customer == null)
                return NotFound();

            return Ok(customer);
        }

        // POST: api/customer
        [HttpPost]
        public async Task<ActionResult<Customer>> Create(Customer customer)
        {
            var createdCustomer = await _customerService.CreateAsync(customer);
            return CreatedAtAction(nameof(GetById), new { id = createdCustomer.Id }, createdCustomer);
        }


        // PUT: api/customer/{id}
        [HttpPut("{id}")]
        public async Task<IActionResult> Update(long id, Customer customer)
        {
            if (id != customer.Id)
                return BadRequest();

            await _customerService.UpdateAsync(customer);


            return NoContent();
        }

        [HttpDelete("{id}")]
        public async Task<IActionResult> Delete(long id)
        {
            var customer = await _customerService.GetByIdAsync(id);
            if (customer == null)
                return NotFound();

            await _customerService.DeleteAsync(id);

            return NoContent();
        }

    }
}
